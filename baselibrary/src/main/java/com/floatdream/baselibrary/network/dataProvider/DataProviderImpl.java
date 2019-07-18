package com.floatdream.baselibrary.network.dataProvider;


import com.floatdream.baselibrary.bean.UserInfo;
import com.floatdream.baselibrary.network.api.NetWorkManager;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * @Describe: 业务层实现
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/3/19
 */


public class DataProviderImpl implements DataProvider {

    @Override
    public Flowable<UserInfo> login(String mobile, String password) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("username", mobile);
        map.put("password", password);
        map.put("mac", "123456");
        map.put("version", "1");
        map.put("softType", "1");
        return NetWorkManager.getInstance().getNetwork().login(map);
    }

}
