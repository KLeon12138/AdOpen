package com.leon.adopen.domain.entity;

import com.leon.adopen.domain.entity.base.BaseIntIdEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * cp
 *
 * @author leon
 * @date 2021-12-13 18:40
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "cp")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cp extends BaseIntIdEntity {
    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT 'cp名称'")
    private String name;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '对接人姓名'")
    private String dockerName;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '对接人联系方式'")
    private String dockerPhone;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '对接人邮箱'")
    private String dockerEmail;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '对接人qq号'")
    private String dockerQq;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '对接人微信号'")
    private String dockerWx;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '对接人地址'")
    private String dockerAddr;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '公司主营业务'")
    private String businessMain;
}
