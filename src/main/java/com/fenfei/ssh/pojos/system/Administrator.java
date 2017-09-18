package com.fenfei.ssh.pojos.system;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shefenfei on 2017/8/16.
 * 管理员 bean
 */
public class Administrator implements Serializable {

    private String id;
    private String adminName;
    private String adminPass;
    private List<Role> roles;
    private List<Permission> permissions;
    private String roleName;
    private String roleDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getRoleDesc() {
        return "管理员";
    }

    public String getRoleName() {
        roles.parallelStream().forEach(s -> {
            roleDesc = s.getRoleDescription();
            roleName = roleName == null ? "" : roleName;
            roleName += s.getRoleName() + ",";
            if (roleName.endsWith(",")) {
                roleName = roleName.substring(0 , roleName.length()-1);
            }
        });
        return roleName;
    }
}
