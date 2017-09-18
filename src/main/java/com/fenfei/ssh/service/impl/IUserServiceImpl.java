package com.fenfei.ssh.service.impl;

import com.fenfei.ssh.dao.IUserDAO;
import com.fenfei.ssh.pojos.system.Role;
import com.fenfei.ssh.pojos.User;
import com.fenfei.ssh.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shefenfei on 2017/7/31.
 */
@Service
public class IUserServiceImpl implements IUserService {

    private Logger logger = Logger.getLogger(IUserServiceImpl.class);

    @Resource
    private IUserDAO userDAO;

    @Override
    @Cacheable(value = "user", key = "#root.methodName")
    public User getUser(String uId) {
        User user1 = userDAO.getUser(uId);
        logger.info("从数据库读取..." + user1);
        return user1;
    }


    @Override
    @CachePut(value = "user", key = "#root.methodName")
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @CacheEvict(value = "user", key = "deleteUser", allEntries = true)
    public long deleteUser(int uid) {
        long count = userDAO.deleteUser(uid);
        return count;
    }

    @Override
    public Set<Role> findAllRoles(String username) {
        Set<Role> roleSet = new HashSet<>();
        Role role = null;
        for (int i = 0; i < 3; i++) {
            role = new Role();
            role.setRoleName("role"+ i);
            roleSet.add(role);
        }
        return roleSet;
    }

    @Override
    public User findUserByName(String username) {
        User user = null;
        if (username.equals("shefenfei")) {
            user = new User();
            user.setUsername("shefenfei");
            user.setPassword("123456");
            user.setId("1");
        }
        return user;
    }

    @Override
    public List<User> findAllUser() {
        return userDAO.getAllUsers();
    }
}
