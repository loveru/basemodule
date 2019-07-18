package com.floatdream.baselibrary.util;

import android.widget.Toast;

import com.floatdream.baselibrary.base.BaseApplication;

/**
 * @Describe: //TODO
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/11/2
 */
public class ToastUtil {

    private static Toast toast;

    /**
     * 显示Toast消息
     * @param msg   消息
     */
    public static void show(String msg) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 显示Toast消息
     * @param resId   消息资源id
     */
    public static void show(int resId) {
        show(BaseApplication.getContext().getString(resId));
    }

}
