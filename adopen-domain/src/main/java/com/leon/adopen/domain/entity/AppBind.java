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
 * @date 2021-12-15 10:21
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "app_bind")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppBind extends BaseIntIdEntity {
    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '产品id'")
    private Integer appId;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '产品编码'")
    private String appCode;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '产品名称'")
    private String appName;

    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '上游id'")
    private Integer spId;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '上游名称'")
    private String spName;

    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '渠道id'")
    private Integer cpId;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '渠道名称'")
    private String cpName;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '渠道码(一个产品下发一个渠道对应一个渠道码)'")
    private String channelCode;

    @Column(columnDefinition = "decimal(10,2) DEFAULT '0.00' COMMENT '下发单价'")
    private BigDecimal price;

    @Column(columnDefinition = "varchar(255) DEFAULT '' COMMENT '渠道上线链接'")
    private String onlineUrl;

    @Column(columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '上量状态(0:正常;1:停止)'")
    private Boolean isOnStatus;

    @Column(columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '删除状态(0:未删除;1:已删除);删除状态即该产品不再需要该渠道投放'")
    private Boolean isdel;
}
