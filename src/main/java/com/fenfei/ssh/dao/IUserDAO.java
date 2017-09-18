package com.fenfei.ssh.dao;

import com.fenfei.ssh.pojos.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by shefenfei on 2017/8/8.
 */
public interface IUserDAO {

    User getUser(@Param("uid") String uid);

    void updateUser(@Param("user") User user);

    void addUser(User user);

    long deleteUser(int uid);

    List<User> getAllUsers();

}
