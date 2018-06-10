package com.example.qiudeli.livedemo.entity;

import android.arch.lifecycle.LiveData;

/**
 * Created by qiudeli on 2018/6/10.
 * LiveData包装实体类
 */

public class UserInfo extends LiveData<String> {
    private static UserInfo sInstance;

    private String value;

    private UserInfo() {
    }

    public static UserInfo getInstance() {
        if (sInstance == null) {
            sInstance = new UserInfo();
        }
        return sInstance;
    }

    public void setContent(String value) {
        setValue(value);
    }


}
