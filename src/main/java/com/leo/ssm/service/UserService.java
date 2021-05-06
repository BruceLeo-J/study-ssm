package com.leo.ssm.service;

import com.leo.ssm.pojo.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(int id);
}
