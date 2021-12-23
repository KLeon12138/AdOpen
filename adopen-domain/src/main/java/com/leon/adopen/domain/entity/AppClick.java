package com.leon.adopen.domain.entity;

import com.leon.adopen.domain.entity.base.BaseIntIdEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author leon
 * @date 2021-12-15 10:55
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "app_click")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppClick extends BaseIntIdEntity {
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

    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '日限量'")
    private Integer limitDay;

    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '点击量'")
    private Integer clickCount;

    @Column(columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否超限额'")
    private Boolean isOverTop;

    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '实际结算数据'")
    private Integer actual;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '点击日期'")
    private String clickDate;
}
