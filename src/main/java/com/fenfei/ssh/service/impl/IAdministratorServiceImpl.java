package com.fenfei.ssh.service.impl;

import com.fenfei.ssh.dao.IAdminDao;
import com.fenfei.ssh.pojos.system.AdminRole;
import com.fenfei.ssh.pojos.system.Administrator;
import com.fenfei.ssh.pojos.system.Permission;
import com.fenfei.ssh.pojos.system.Role;
import com.fenfei.ssh.service.IAdministratorService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by shefenfei on 2017/8/17.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class IAdministratorServiceImpl implements IAdministratorService {

    Logger logger = Logger.getLogger(IAdministratorServiceImpl.class);

    @Resource
    private IAdminDao adminDao;

    @Override
    public Administrator login(String username, String password) {
        return adminDao.login(username, password);
    }

    @Override
    public Administrator getAdminRoleAndPerms(String adminName) {
        String uid = getAdminByName(adminName).getId();
        Set<String> roleName = new HashSet<>();
        Set<String> perms = new HashSet<>();
        Administrator administrator = adminDao.getAdminById(Integer.valueOf(uid));
        administrator.getRoles().parallelStream().forEach(s -> {
            roleName.add(s.getRoleName());
        });
        administrator.getPermissions().parallelStream().forEach(s -> {
            perms.add(s.getPermName());
        });
        return administrator;
    }

    @Override
    public List<Administrator> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public List<Role> getAllRoles() {
        return adminDao.getAllRoles();
    }

    @Override
    public List<Permission> getAllPerms() {
        return adminDao.getAllPerms();
    }

    @Override
    public Map<String, Object> addNewAdmin(Administrator admin, List<Integer> roleIds) {
        adminDao.addNewAdmin(admin);
        int adminId = Integer.valueOf(admin.getId());

        List<AdminRole> adminRoles = new ArrayList<>();
        for (Integer id: roleIds) {
            AdminRole adminRole = new AdminRole();
            adminRole.setRoleId(id);
            adminRole.setAdminId(adminId);
            adminRoles.add(adminRole);
        }
        adminDao.addAdminRoles(adminRoles);
        return null;
    }

    private Administrator getAdminByName(String adminName) {
        return adminDao.getAdminByName(adminName);
    }

}
