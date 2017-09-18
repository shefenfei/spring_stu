package com.fenfei.ssh.pojos.system;

import java.io.Serializable;

/**
 * Created by shefenfei on 2017/8/15.
 * 菜单
 */
public class Menu implements Serializable {

    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
