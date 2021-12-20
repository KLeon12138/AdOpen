package com.leon.adopen.domain.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author leon
 * @date 2021-12-14 02:06
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<ID> {
    @Column(
            insertable = false,
            updatable = false,
            columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'"
    )
    private Date insertTime;
    @Column(
            insertable = false,
            updatable = false,
            columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'"
    )
    private Date updateTime;
    @Transient
    private List<String> likeField;

    public BaseEntity() {
    }

    public <T> Example<T> toExample(T t) {
        if (this.likeField == null) {
            return Example.of(t);
        } else {
            ExampleMatcher exampleMatcher = ExampleMatcher.matching();

            String field;
            for(Iterator var3 = this.likeField.iterator(); var3.hasNext(); exampleMatcher = exampleMatcher.withMatcher(field, ExampleMatcher.GenericPropertyMatchers.contains())) {
                field = (String)var3.next();
            }

            return Example.of(t, exampleMatcher);
        }
    }
}
