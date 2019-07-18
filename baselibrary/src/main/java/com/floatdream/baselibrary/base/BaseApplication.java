package com.floatdream.baselibrary.base;

import android.app.Application;
import android.support.multidex.MultiDex;

/**
 * @Describe: //TODO
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2019/7/18
 */

public class BaseApplication extends Application {

    /**
     * Application
     */
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initMultiDex();
    }

    private void initMultiDex() {

        MultiDex.install(this);
    }

    public static BaseApplication getContext() {
        return instance;
    }
}
