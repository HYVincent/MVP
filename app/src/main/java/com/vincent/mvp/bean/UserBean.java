package com.vincent.mvp.bean;

import java.io.Serializable;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 11:44
 *
 * @version 1.0
 */

public class UserBean implements Serializable {

    public String username;

    public String password;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
