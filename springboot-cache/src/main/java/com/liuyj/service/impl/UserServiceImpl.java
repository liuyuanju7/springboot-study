package com.liuyj.service.impl;

import com.liuyj.bean.User;
import com.liuyj.service.IUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author liuyuanju1
 * @date 2018/8/1
 * @description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    @CachePut(value = "user",key = "#user.id") //将返回结果添加到缓存 val缓存名 key缓存key
    public User addUser(User user) {
        //dao.insertUser
        return user;
    }

    @Override //user age > 20 时 添加到 admin 缓存
    @CachePut(value = "admin",key = "#user.id",condition = "#user.age > 20")
    public User addAdmin(User user) {
        //dao.insertadmin
        return user;
    }

    @Override
    @Cacheable(value = "user",key = "#id") //先判断是否有缓存 如有则返回缓存中的值，若无则执行方法查询数据库
    public User findUser(String id) {
        User user = new User().setId("1").setName("liu").setAge(12).setSex("male");
        return user;
    }

    @Override
    @CacheEvict(value = "user", key = "#id") //执行该方法后 删除对应key的数据
    public void deleteUser(String id) {
        //delete user
    }

    @Override
    @CacheEvict(value = "user",allEntries = true) //执行该方法后 删除所有缓存数据
    public void deleteAllUser() {
        //delete all user
    }


}
