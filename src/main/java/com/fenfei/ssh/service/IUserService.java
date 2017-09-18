package com.fenfei.ssh.service;

import com.fenfei.ssh.pojos.system.Role;
import com.fenfei.ssh.pojos.User;

import java.util.List;
import java.util.Set;

/**
 * Created by shefenfei on 2017/7/31.
 */
public interface IUserService {

    User getUser(String uId) ;

    void addUser(User user);

    long deleteUser(int uid);

    Set<Role> findAllRoles(String username);

    User findUserByName(String username);

    List<User> findAllUser();

}
