package com.leon.adopen.domain.entity;
import com.leon.adopen.domain.entity.base.BaseIntIdEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author leon
 * @date 2021-11-25 11:52
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "app")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class App extends BaseIntIdEntity {
    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '产品编码'")
    private String appCode;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '产品名称'")
    private String appName;

    @Column(columnDefinition = "tinyint(4) DEFAULT '1' COMMENT '产品平台(1:ios;2:android;3:小程序:4:双端)'")
    private Byte platform;

    @Column(columnDefinition = "tinyint(4) DEFAULT '1' COMMENT '产品类型(1:cpa;2:cps)'")
    private Byte type;

    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '上游id'")
    private Integer spId;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '上游名称'")
    private String spName;

    @Column(columnDefinition = "decimal(10,2) DEFAULT '0.00' COMMENT '单价'")
    private BigDecimal price;

    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '日限'")
    private Integer limitDay;

    @Column(columnDefinition = "tinyint(4) DEFAULT '1' COMMENT '链接类型(1:对接;2:短链)'")
    private Byte urlType;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '预览链接'")
    private String previewUrl;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '上线链接'")
    private String onlineUrl;

    @Column(columnDefinition = "tinyint(4) DEFAULT '1' COMMENT '返数格式(1:后台截图;2:表格截图)'")
    private Byte backFormat;

    @Column(columnDefinition = "tinyint(4) DEFAULT '3' COMMENT '帐期(1:日结;2:周结;3:月结;4:N+1;5:N+2)'")
    private Byte book;

    @Column(columnDefinition = "varchar(50) DEFAULT '无要求' COMMENT '考核要求'")
    private String demand;

    @Column(columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否移除(0:未移除;1:已移除)'")
    private Boolean isRemove;

    @Column(columnDefinition = "varchar(255) DEFAULT '' COMMENT '备注'")
    private String remark;
}
