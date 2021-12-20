package com.leon.adopen.domain.entity;

import com.leon.adopen.domain.entity.base.BaseIntIdEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author leon
 * @date 2021-12-13 16:48
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "app_callback_log")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppCallbackLog extends BaseIntIdEntity {
    @Column(columnDefinition = "varchar(50) DEFAULT '0' COMMENT '广告App编号'")
    private String adAppId;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '用户唯一标识'")
    private String idfa;

    @Column(columnDefinition = "varchar(500) DEFAULT '' COMMENT '回调地址'")
    private String callback;

    @Column(columnDefinition = "varchar(100) DEFAULT '' COMMENT '回调结果'")
    private String result;

    @Column(columnDefinition = "tinyint(3) DEFAULT '1' COMMENT '状态'")
    private Byte status;
}
