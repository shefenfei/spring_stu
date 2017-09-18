package com.fenfei.ssh.service;

import com.fenfei.ssh.pojos.system.Administrator;
import com.fenfei.ssh.pojos.system.Permission;
import com.fenfei.ssh.pojos.system.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by shefenfei on 2017/8/16.
 * 管理员的服务
 */
public interface IAdministratorService {

    /**
     * 管理员登录
     */
    Administrator login(String username , String password);

    /**
     * 获取管理员的所有角色
     * @param adminName 管理员用户名
     * @return
     */
    Administrator getAdminRoleAndPerms(String adminName);


    /**
     * 获取所有的管理员
     * @return
     */
    List<Administrator> getAllAdmin();


    /**
     * 获取所有的roles
     * @return
     */
    List<Role> getAllRoles();


    /**
     * 获取所有的权限信息
     * @return
     */
    List<Permission> getAllPerms() ;

    /**
     * 添加新的管理员
     * @param admin
     * @return
     */
    Map<String,Object> addNewAdmin(Administrator admin,List<Integer> roleIds);
}
