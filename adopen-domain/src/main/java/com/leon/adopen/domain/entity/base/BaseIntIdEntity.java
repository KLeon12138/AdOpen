package com.leon.adopen.domain.entity.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author leon
 * @date 2021-12-14 02:05
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class BaseIntIdEntity extends BaseEntity<Integer>{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
}
