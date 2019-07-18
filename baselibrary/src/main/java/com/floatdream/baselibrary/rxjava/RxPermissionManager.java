package com.floatdream.baselibrary.rxjava;

import android.Manifest;

import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * @Describe: //TODO
 * @Author: huangjc
 * @Email: 252431193@qq.com
 * @Date: 2018/11/2
 */

public class RxPermissionManager {


    /**
     * 定位权限请求
     *
     * @param rxPermissions
     * @param consumer
     */
    public static void requestLocationPermissions(RxPermissions rxPermissions, RxPermissionConsumer consumer) {

        rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(consumer);
    }

    /**
     * 请求照相机相册权限
     *
     * @param rxPermissions
     * @param consumer
     */
    public static void requestCameraAlbumPermissions(RxPermissions rxPermissions, RxPermissionConsumer consumer) {
        rxPermissions.request(Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(consumer);
    }

    /**
     * 请求SD卡读写权限
     *
     * @param rxPermissions
     * @param consumer
     */
    public static void requestStoragePermissions(RxPermissions rxPermissions, RxPermissionConsumer consumer) {
        rxPermissions.request(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(consumer);
    }
}
