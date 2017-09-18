package com.fenfei.ssh.pojos.system;

import java.io.Serializable;

/**
 * Created by shefenfei on 2017/8/25.
 * 角色 - 权限 实体
 */
public class RolePerms implements Serializable{
    private int roleId;     //FK
    private int permsId;    //FK

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermsId() {
        return permsId;
    }

    public void setPermsId(int permsId) {
        this.permsId = permsId;
    }
}
