package com.floatdream.baselibrary.constant;

/**
 * @Describe: 常量类
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/3/19
 */


public class Constant {


    /**
     * 网络请求异常code
     */
    public static class ExceptionCode {
        /**
         * 网络异常
         */
        public static final int NETWORK_EXCEPTION = 0x10001;

        /**
         * 服务器异常
         */
        public static final int SERVER_EXCEPTION = 0x10002;

        /**
         * 其他异常
         */
        public static final int OTHER_EXCEPTION = 0x10003;
    }

    /**
     * Http请求消息体返回正确status
     */
    public static final int RESPONSE_OK = 200;

    /**
     * Http请求消息体提示错误信息
     */
    public static final int RESPONSE_SHOW_MSG = 1;

    /**
     * Http请求消息体Token失效status
     */
    public static final int RESPONSE_TOKEN_INVALID = 401;


    /**
     * 按钮去抖动时间间隔2s
     */
    public static final int BUTTON_THROTTLE_TIME = 1;

    /**
     * 输入框去抖动时间间隔1s
     */
    public static final int EDITTEXT_THROTTLE_TIME = 1;

    /**
     * 请求验证码倒计时时间
     */
    public static final int COUNTDOWN_TIME = 60;

}
