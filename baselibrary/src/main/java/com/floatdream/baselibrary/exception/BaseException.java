package com.floatdream.baselibrary.exception;

/**
 * @Describe: 异常基类
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/3/19
 */


public class BaseException extends RuntimeException {
    public BaseException(String msg) {
        super(msg);
    }
}
