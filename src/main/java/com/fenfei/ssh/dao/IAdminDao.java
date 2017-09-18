package com.fenfei.ssh.dao;

import com.fenfei.ssh.pojos.system.AdminRole;
import com.fenfei.ssh.pojos.system.Administrator;
import com.fenfei.ssh.pojos.system.Permission;
import com.fenfei.ssh.pojos.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by shefenfei on 2017/8/17.
 */
public interface IAdminDao {

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    Administrator login(@Param("username")String username ,
                        @Param("password")String password);

    /**
     * 获取管理员对应的角色
     * @param adminId 管理员id
     * @return
     */
    Set<Role> getRoleById(@Param("adminId") String adminId);


    /**
     * 根据id获取管理员信息
     * @param adminId
     * @return
     */
    Administrator getAdminById(@Param("adminId") int adminId);


    /**
     * 获取管理员对应的权限
     * @param adminId 管理员id
     * @return
     */
    Set<String> getPermsById(@Param("adminId") String adminId);


    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Administrator getAdminByName(@Param("username") String username);


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
    List<Permission> getAllPerms();


    /**
     * 添加新管理员
     * @param administrator
     * @return
     */
    int addNewAdmin(Administrator administrator);


    /**
     * 添加管理员的角色
     * @param adminRoles
     * @return
     */
    int addAdminRoles(List<AdminRole> adminRoles);


    int addAdminPerms();


    int addAdminRoles1(Map<String , Object> map);



    List<Administrator> getAdminInIds(List<Integer> ids);

}


