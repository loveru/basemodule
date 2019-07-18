package com.floatdream.baselibrary.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.floatdream.baselibrary.R;
import com.floatdream.baselibrary.constant.Constant;
import com.floatdream.baselibrary.util.ToastUtil;
import com.gyf.barlibrary.ImmersionBar;


import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Describe: activity基类
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/3/19
 */


public abstract class BaseActivity<V extends IBaseView, P extends IBasePresenter<V>> extends AppCompatActivity {

    /**
     * 当前类实例
     */
    public static BaseActivity instance;

    /**
     * Presenter
     */
    private P presenter;

    /**
     * ButterKnife解绑
     */
    private Unbinder unbinder;

    /**
     * 沉浸式状态栏
     */
    private ImmersionBar immersionBar;

    public static final String EXIT_ACTION = "action.exit";
    private ExitReceiver exitReceiver = new ExitReceiver();

    /**
     * pos
     */


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(getLayoutId());

        instance = this;

        //是否全屏
        if (applyFullScreen()) {
            setFullScreenModel();
        }
        //是否设置沉浸式状态栏
        else if (applyImmersionBar()) {
            setImmersionBar(getStatusBarColor());
        }
        unbinder = ButterKnife.bind(this);

        presenter = initPresenter();
        if (presenter != null) {
            presenter.setContext(this);
            presenter.attachView((V) this);
        }

        init(savedInstanceState);
        initToolbar(savedInstanceState);
        initViews(savedInstanceState);
        initListener();
        initData();

        IntentFilter filter = new IntentFilter();
        filter.addAction(EXIT_ACTION);
        registerReceiver(exitReceiver, filter);

    }

    @Override
    protected void onDestroy() {

        unbinder.unbind();
        unregisterReceiver(exitReceiver);
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 获取当前类实例
     *
     * @return
     */
    public static BaseActivity getInstance() {
        return instance;
    }


    /**
     * 是否设置沉浸式状态栏
     *
     * @return
     */
    protected boolean applyImmersionBar() {
        return true;
    }

    /**
     * 是否设置全屏显示
     *
     * @return
     */
    protected boolean applyFullScreen() {
        return false;
    }

    /**
     * 系统StatusBar颜色
     *
     * @return
     */
    protected int getStatusBarColor() {
        return R.color.colorPrimary;
    }

    /**
     * 设置系统statusBar颜色
     *
     * @param statusBarColor 状态栏颜色
     */
    protected void setImmersionBar(int statusBarColor) {
        immersionBar = ImmersionBar.with(this);
        immersionBar.statusBarColor(statusBarColor)
                .keyboardEnable(true)
                .fitsSystemWindows(true)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    /**
     * 全屏App内容填充状态栏
     */
    protected void setFullScreenModel() {
        immersionBar = ImmersionBar.with(this);
        immersionBar.keyboardEnable(true)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    /**
     * 布局layout id
     *
     * @return layout id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化Presenter
     *
     * @return P
     */
    protected abstract P initPresenter();

    /**
     * 初始化
     */
    protected void init(Bundle savedInstanceState) {
    }

    /**
     * 初始化toolBar
     */
    protected void initToolbar(Bundle savedInstanceState) {
    }

    /**
     * 初始化view
     */
    protected void initViews(Bundle savedInstanceState) {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 设置监听器
     */
    protected void initListener() {
    }


    /**
     * 获取Presenter
     *
     * @return P
     */
    protected P getPresenter() {
        return presenter;
    }

    /**
     * 显示进度条
     * notice：基类中实现IBaseView的回调
     */
    public void showProgress() {

    }

    /**
     * 隐藏进度条
     * notice：基类中实现IBaseView的回调
     */
    public void hideProgress() {

    }

    /**
     * 处理消息
     * notice：基类中实现IBaseView的回调
     *
     * @param status
     * @param msg
     */
    public void handleMsg(int status, String msg) {
        ToastUtil.show(msg);
        //token失效,跳转到登录
        if (status == Constant.RESPONSE_TOKEN_INVALID) {

        }
    }


    class ExitReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            BaseActivity.this.finish();
        }
    }


}

