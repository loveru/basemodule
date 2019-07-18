package com.floatdream.baselibrary.rxjava;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @Describe: //TODO
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/11/2
 */

public abstract class RxPermissionConsumer implements Consumer<Boolean> {

    @Override
    public void accept(@NonNull Boolean granted) throws Exception {
        if (granted) {
            success();
        } else {
            failure();
        }
    }

    public abstract void success();

    public abstract void failure();
}
