package com.fenfei.ssh.pojos;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * Created by shefenfei on 2017/7/25.
 */
public class User implements Serializable{

    private String id;
    private String username;
    private String password;
    private String phone;
    private String major;
    private String sex;

    @JsonView(WithoutPasswordView.class)
    public String getUsername() {
        return username;
    }

    @JsonView(WithPasswordView.class)
    public String getPassword() {
        return password;
    }

    @JsonView(WithoutPasswordView.class)
    public String getSex() {
        return sex;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", major='" + major + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public interface WithoutPasswordView{}

    public interface WithPasswordView extends WithoutPasswordView {}
}
