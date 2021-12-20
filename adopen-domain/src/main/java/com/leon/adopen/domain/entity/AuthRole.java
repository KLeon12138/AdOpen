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
@Table(name = "auth_role")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRole extends BaseIntIdEntity {
    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '角色名称'")
    private String rolename;

    @Column(columnDefinition = "int(11) DEFAULT 0 COMMENT '用户id'")
    private Integer userId;
}
