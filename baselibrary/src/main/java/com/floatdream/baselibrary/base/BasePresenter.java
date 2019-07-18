package com.floatdream.baselibrary.base;

import android.content.Context;


import com.floatdream.baselibrary.network.dataProvider.DataProvider;
import com.floatdream.baselibrary.network.dataProvider.DataProviderImpl;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @Describe: 基础presenter实现
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/3/19
 */


public class BasePresenter<V extends IBaseView>implements IBasePresenter<V> {
    /**
     * context
     */
    private Context context;

    /**
     * 回调接口
     */
    private V mvpView;

    /**
     * 数据提供类
     */
    private DataProvider dataProvider;

    /**
     * 统一管理类
     */
    private CompositeDisposable compositeDisposable;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        this.dataProvider = new DataProviderImpl();
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        mvpView = null;
        dataProvider = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

    @Override
    public void addTask(Disposable disposable) {
        if (compositeDisposable == null) {
            return;
        }
        if (disposable == null) {
            return;
        }
        compositeDisposable.add(disposable);
    }

    public V getMvpView() {
        return mvpView;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }
}
