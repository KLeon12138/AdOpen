package com.leon.adopen.common.utils;

import org.springframework.lang.Nullable;

/**
 * @author leon
 * @date 2021-12-15 17:05
 */
public class StringUtils {
    public static boolean isEmpty(@Nullable Object str) {
        return (str == null || "".equals(str));
    }
}
