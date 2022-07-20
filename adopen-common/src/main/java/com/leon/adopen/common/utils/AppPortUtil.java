package com.leon.adopen.common.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.leon.adopen.common.constants.url.UrlConstants;
import com.leon.adopen.common.exception.code.ExCode;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.domain.pojo.BaseInfo;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author leon
 */
@Service
public class AppPortUtil {
    //    @Value("${leon.adopen.host}")
    private final String host = "http://www.adopen.leon.org.cn";

    private static final Digester MD5 = new Digester(DigestAlgorithm.MD5);
    private static final Digester SHA = new Digester(DigestAlgorithm.SHA1);
    private static final Base64.Encoder BASE64 = Base64.getEncoder();

    private static final String NOW_URL = "/cgi-bin/third/third_channel/click_report";
    private static final String NOW_APP_KEY = "eb38f54fd42719dc86215ab0c5fd1d5a";

    public static String encode(final String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, "utf-8");
    }


    /**
     * @param appid 产品 id
     * @param idfa  idfa
     * @param url   回调地址
     * @return {@link  String}  回调结果
     * @throws UnsupportedEncodingException 编码异常
     */
    public static String getcallback(String appid, String idfa, String url) throws UnsupportedEncodingException {
        if (url != null) {
            return encode(UrlConstants.CALLBACK_URL
                    + "appid=" + appid + "&idfa=" + idfa + "&sign=" + encode(DesUtil.encrypt(url)));
        } else {
            return "";
        }
    }

    /**
     * 获取回调地址
     *
     * @param appid  我方渠道id
     * @param idfa   IDFA
     * @param ip     ip
     * @param remark 产品-渠道号 备注信息
     * @return {@link  String}  回调地址
     * @throws AdopenException              空指针异常等
     * @throws UnsupportedEncodingException java自定义异常
     */
    public String getCallbackWithRemark(String appid, String idfa, String ip, String remark) throws AdopenException, UnsupportedEncodingException {
        if (appid.isEmpty() || idfa.isEmpty() || remark.isEmpty()) {
            throw new AdopenException(ExCode.badArgumentValue, "appid:" + appid + ", idfa:" + idfa + ", remark:" + remark + ", exist param is null");
        }
        return encode(host + UrlConstants.CALLBACK_URL + "appid=" + appid + "&idfa=" + idfa + "&ip=" + ip + "&sign=zhuoyin&remark=" + remark);
    }

    /**
     * 获取渠道回调地址
     *
     * @param appid 我方渠道id
     * @param idfa  IDFA
     * @return {@link  String}  回调地址
     * @throws AdopenException              空指针异常等
     * @throws UnsupportedEncodingException java自定义异常
     */
    public String back(String appid, String idfa, String ip) throws AdopenException, UnsupportedEncodingException {
        if (appid.isEmpty() || idfa.isEmpty()) {
            throw new AdopenException(ExCode.badArgumentValue, "appid:" + appid + ", idfa:" + idfa + ", exist param is null");
        }
        return encode(host + UrlConstants.CALLBACK_URL + "appid=" + appid + "&idfa=" + idfa + "&ip=" + ip + "&sign=leon");
    }

    public String backToMe(String appid, String idfa, String ip) throws AdopenException, UnsupportedEncodingException {
        if (appid.isEmpty() || idfa.isEmpty()) {
            throw new AdopenException(ExCode.badArgumentValue, "appid:" + appid + ", idfa:" + idfa + ", exist param is null");
        }
        return encode(host + UrlConstants.BACK_TO_ME_URL + "appid=" + appid + "&idfa=" + idfa + "&ip=" + ip + "&sign=jr");
    }

    public String getBackToLeonServer(String appid, String idfa, String ip, String remark) throws AdopenException, UnsupportedEncodingException {
        if (appid.isEmpty() || idfa.isEmpty() || remark.isEmpty()) {
            throw new AdopenException(ExCode.badArgumentValue, "appid:" + appid + ", idfa:" + idfa + ", remark:" + remark + ", exist param is null");
        }
        return encode(host + UrlConstants.BACK_LEON_URL + "appid=" + appid + "&idfa=" + idfa + "&ip=" + ip + "&sign=puti&remark=" + remark);
    }

    //获取回调地址-不转码
    private static String getcallbackWithRemarkNoEncode(String appid, String idfa, String remark) throws AdopenException {
        if (appid.isEmpty() || idfa.isEmpty() || remark.isEmpty()) {
            throw new AdopenException(ExCode.badArgumentValue, "appid:" + appid + ", idfa:" + idfa + ", remark:" + remark + ", exist param is null");
        }
        return UrlConstants.CALLBACK_URL + "appid=" + appid + "&idfa=" + idfa + "&sign=zhuoyin&remark=" + remark;

    }

    public static String getToken(BaseInfo info, String remark) throws AdopenException {
        String lineString = "ca_n=longdiios#ca_s=app_tg#callback="
                + getcallbackWithRemarkNoEncode(info.getChannel(), info.getIdfa(), remark) + "#idfa=" + info.getIdfa()
                + "#ip=" + info.getIp() + "#line=1";
        return SHA.digestHex((MD5.digestHex(lineString) + "@7ee8c16b7a7af8cedf8e95975a2a8869"));
    }

    public String getNowSign(String idfa, String backUrl) throws Exception {
        String encodeUrl = encode(NOW_URL);
        String encodeParams = encode("appid=2293&idfa=" + idfa + "&multipleurl=" + backUrl + "&os=ios&registerurl=" + backUrl + "&source=junbo5");
        String digestHex = hmacsha256(encodeUrl + "&" + encodeParams);
        return BASE64.encodeToString(digestHex.getBytes());
    }

    private static String hmacsha256(String data) throws Exception {
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(NOW_APP_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256Hmac.init(secretKey);
        byte[] array = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();

    }
}
