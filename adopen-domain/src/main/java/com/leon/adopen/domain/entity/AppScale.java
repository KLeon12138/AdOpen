package com.leon.adopen.domain.entity;

import com.leon.adopen.domain.entity.base.BaseIntIdEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author leon
 * @date 2021-12-13 16:42
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "app_scale")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppScale extends BaseIntIdEntity {
    @Column(columnDefinition = "int(11) DEFAULT '0' COMMENT '广告App编号'")
    private Integer adAppId;

    @Column(columnDefinition = "int(11) DEFAULT 0 COMMENT '扣量数'")
    private Integer scaleNum;

    @Column(columnDefinition = "int(11) DEFAULT 0 COMMENT '总回调数'")
    private Integer totalNum;

    @Column(columnDefinition = "decimal(10,2) DEFAULT '0.00' COMMENT '扣量比例'")
    private BigDecimal scaleRate;

    @Column(columnDefinition = "tinyint(3) DEFAULT 1 COMMENT '状态'")
    private Byte status;
}
