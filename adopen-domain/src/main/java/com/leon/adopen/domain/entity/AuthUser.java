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
 * @date 2021-12-16 15:43
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "auth_user")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUser extends BaseIntIdEntity {
    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '用户名'")
    private String username;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '密码'")
    private String password;
}
