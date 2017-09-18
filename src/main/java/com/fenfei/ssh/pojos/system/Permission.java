package com.fenfei.ssh.pojos.system;

import java.io.Serializable;

/**
 * Created by shefenfei on 2017/8/16.
 * 权限实体
 */
public class Permission implements Serializable {

    /**
     * 主键
     */
    private int id;

    /**
     * 权限标识
     */
    private String permId;
    /**
     * 权限名
     */
    private String permName;
    /**
     * 权限描述
     */
    private String permDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermDescription() {
        return permDescription;
    }

    public void setPermDescription(String permDescription) {
        this.permDescription = permDescription;
    }
}
