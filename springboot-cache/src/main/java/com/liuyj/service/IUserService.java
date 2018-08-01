package com.liuyj.service;

import com.liuyj.bean.User;

/**
 * @author liuyuanju1
 * @date 2018/8/1
 * @description:
 */
public interface IUserService {
    User addUser(User user);

    User addAdmin(User user);

    User findUser(String id);

    void deleteUser(String id);

    void deleteAllUser();
}
