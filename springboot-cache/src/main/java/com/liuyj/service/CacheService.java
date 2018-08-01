package com.liuyj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuyuanju1
 * @date 2018/8/1
 * @description: cache 缓存相关操作service
 */
@Service
public class CacheService {
    @Autowired
    private CacheManager cacheManager;

    /**
     * 返回所有缓存 name集合
     * @return
     */
    public Collection<String> listAll(){
        return cacheManager.getCacheNames();
    }

    public Map<String,Cache> listAllDetail(){
        Map<String,Cache> cacheMap = cacheManager.getCacheNames().stream()
                .collect(Collectors.toMap(name -> name,name ->cacheManager.getCache(name)));
        return cacheMap;
    }

    /**
     * 删除所有缓存
     */
    public void deleteAll(){
        cacheManager.getCacheNames().forEach(
                cacheName -> cacheManager.getCache(cacheName).clear()
        );
    }

    public void deleteByName(String name){
        if(cacheManager.getCacheNames().contains(name)){
            cacheManager.getCache(name).clear();
        }
    }

    public void deleteByNameAndKey(String name,String key){
        if(cacheManager.getCacheNames().contains(name)){
            cacheManager.getCache(name).evict(key);
        }
    }
}
