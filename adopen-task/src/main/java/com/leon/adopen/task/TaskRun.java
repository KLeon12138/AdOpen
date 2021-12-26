package com.leon.adopen.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author leon
 * @date 2021-12-26 02:13
 */
@SpringBootApplication(scanBasePackages = {"com.leon.adopen.task", "com.leon.adopen.common", "com.leon.adopen.domain"})
@EnableScheduling
@EnableCaching
@ComponentScan(basePackages = "com.leon.*.*")
@ServletComponentScan(basePackages = "com.leon.*.*")
@EntityScan(basePackages = "com.leon.adopen.domain.entity")
@EnableAsync
@DependsOn("springContextConfig")
public class TaskRun {
    public static void main(String[] args) {
        SpringApplication.run(TaskRun.class, args);
    }
}
