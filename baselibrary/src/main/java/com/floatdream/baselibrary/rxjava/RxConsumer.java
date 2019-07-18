package com.floatdream.baselibrary.rxjava;

import android.util.Log;


import com.floatdream.baselibrary.bean.BaseBean;
import com.floatdream.baselibrary.constant.Constant;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


/**
 * @Describe: 统一订阅封装
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/3/19
 */


public abstract class RxConsumer<T> implements Consumer<BaseBean<T>> {
    @Override
    public void accept(@NonNull BaseBean<T> baseBean) throws Exception {
        //正常
        Log.e("---", "accept: " + baseBean.serialNo + baseBean.sign);
        if (baseBean.code == Constant.RESPONSE_OK) {
            _accept(baseBean.data);
        }
//        //token失效
//        else if(baseBean.status == Constant.RESPONSE_TOKEN_INVALID) {
//
//        }
        else {
            _handleMsg(baseBean.code, baseBean.msg);
        }
    }

    public abstract void _accept(T t);

    public abstract void _handleMsg(int status, String msg);
}
