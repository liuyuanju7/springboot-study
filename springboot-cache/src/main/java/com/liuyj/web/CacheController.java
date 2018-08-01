package com.liuyj.web;

import com.liuyj.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

/**
 * @author liuyuanju1
 * @date 2018/8/1
 * @description:
 */
@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private CacheService cacheService;

    @GetMapping("/list")
    public Collection<String> getAllCacheNames(){
        return cacheService.listAll();
    }

    @GetMapping("/list/detail")
    public Map<String,Cache> getAllCacheDetail(){
        return cacheService.listAllDetail();
    }
}
