package com.floatdream.basemodule;

import android.os.Bundle;

import com.floatdream.baselibrary.base.BaseActivity;
import com.floatdream.baselibrary.base.IBasePresenter;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);


    }
}
