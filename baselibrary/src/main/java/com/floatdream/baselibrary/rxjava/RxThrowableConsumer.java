package com.floatdream.baselibrary.rxjava;


import com.floatdream.baselibrary.R;
import com.floatdream.baselibrary.base.BaseApplication;
import com.floatdream.baselibrary.constant.Constant;
import com.floatdream.baselibrary.exception.ServerException;
import com.floatdream.baselibrary.util.LogUtil;
import com.floatdream.baselibrary.util.NetWorkUtil;
import com.floatdream.baselibrary.util.ToastUtil;

import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @Describe: 统一异常封装
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/3/19
 */


public class RxThrowableConsumer implements Consumer<Throwable> {
    @Override
    public void accept(@NonNull Throwable throwable) throws Exception {
        throwable.printStackTrace();
        //网络
        if (!NetWorkUtil.isNetConnected(BaseApplication.getContext())) {
            _accept(Constant.ExceptionCode.NETWORK_EXCEPTION, BaseApplication.getContext().getString(R.string.common_no_net));
        }
        //服务器
        else if (throwable instanceof ServerException) {
//            _accept(Constant.ExceptionCode.SERVER_EXCEPTION, throwable.getMessage());
            _accept(Constant.ExceptionCode.SERVER_EXCEPTION, BaseApplication.getContext().getString(R.string.common_socket_closed));
        }
        //服务器超时
        else if (throwable instanceof SocketTimeoutException) {
//            _accept(Constant.ExceptionCode.SERVER_EXCEPTION, throwable.getMessage());
            _accept(Constant.ExceptionCode.SERVER_EXCEPTION, BaseApplication.getContext().getString(R.string.common_socket_timeout));
        } else if (throwable instanceof NoRouteToHostException) {
            _accept(Constant.ExceptionCode.SERVER_EXCEPTION, BaseApplication.getContext().getString(R.string.common_socket_no_host));
        }
        //其它
        else {
            _accept(Constant.ExceptionCode.OTHER_EXCEPTION, BaseApplication.getContext().getString(R.string.common_other_error));
        }
    }

    public void _accept(int errorCode, String errorMsg) {
        LogUtil.e(errorMsg);
        ToastUtil.show(errorMsg);
    }

}

