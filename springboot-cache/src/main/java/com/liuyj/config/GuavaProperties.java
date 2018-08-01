package com.liuyj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liuyuanju1
 * @date 2018/8/1
 * @description: 缓存配置参数
 */
@Data
@ConfigurationProperties(prefix = "guava.cache.config")
public class GuavaProperties {
    private long maximumSize;
    private long maximumWeight;
    private long expireAfterWriteDuration;
    private long expireAfterAccessDuration;
    private long refreshDuration;
    private int initialCapacity;
    private int concurrencyLevel;
}
