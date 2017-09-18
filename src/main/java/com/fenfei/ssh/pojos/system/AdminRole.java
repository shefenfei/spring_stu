package com.fenfei.ssh.pojos.system;

/**
 * Created by shefenfei on 2017/8/25.
 * 管理员-角色实体
 */
public class AdminRole {
    private int adminId; // FK
    private int roleId;  // FK

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
