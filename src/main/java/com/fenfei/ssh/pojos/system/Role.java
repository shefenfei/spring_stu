package com.fenfei.ssh.pojos.system;

import java.io.Serializable;

/**
 * Created by shefenfei on 2017/8/13.
 * 角色实体
 */
public class Role implements Serializable {

    private int id;

    private String roleId;

    private String roleName;

    private String roleDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
