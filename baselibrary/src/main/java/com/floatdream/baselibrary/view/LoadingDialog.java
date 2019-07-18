package com.floatdream.baselibrary.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.floatdream.baselibrary.R;


/**
 * @Describe: //TODO
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/11/2
 */
public class LoadingDialog {
    /**
     * 对话框
     */
    private static Dialog loadingDialog;


    public static void show(Context context) {


        if (loadingDialog != null) {
            release();
        }

//        if (loadingDialog == null) {
//            createLoadingDialog(context);
//        }
        createLoadingDialog(context);
        loadingDialog.show();
    }

    private static void createLoadingDialog(Context context) {
        loadingDialog = new Dialog(context, R.style.AppTheme_ConfirmDialog);
        View loadView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        loadingDialog.setContentView(loadView);
        loadingDialog.setCanceledOnTouchOutside(false);
    }

    public static void close() {

        if (loadingDialog != null) {
            loadingDialog.dismiss();
            //loadingDialog = null;
        }

    }

    public static void release() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

}
