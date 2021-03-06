package com.muz.muzotherdemo.application;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import java.util.ArrayList;
import java.util.List;


/**
 * 应用
 */
public class MyApplication extends Application {
    /**
     * MyApplication实例
     */
    public static MyApplication instance;
    /**
     * Activity集合，用于彻底退出应用
     */
    private List<Activity> activities;
//    /**
//     */
//    private User user;
//    /**

//     */
//    private List<Shop> shops;
//    /**
//     * 当前
//     */
//    private Shop currShop;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化实例
        instance = this;
        // 创建Activity集合
        activities = new ArrayList<>();
        // 初始化未知异常处理
//        initCrashHandler();
        // 初始化NoHttp
//        initNoHttp();
        // EventBus启用加速模式
        //EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
        // 初始化网络状态观察者
//        initNetStateObserver();
        //二维码
//        ZXingLibrary.initDisplayOpinion(this);


//        JPushInterface.init(this);     		// 初始化 JPush


    }

//    /**
//     * 初始化未知异常处理
//     */
//    private void initCrashHandler() {
//        // 创建未知异常处理类
//        CrashHandler crashHandler = new CrashHandler(this);
//        //通知android框架，出了异常，并且没加catch,android框架调crashHandler
//        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
//    }

//    /**
//     * 初始化网络状态观察者
//     */
//    private void initNetStateObserver() {
//        // 注册网络状态广播接收器
//        NetworkStateReceiver.registerNetworkStateReceiver(this);
//        // 注册网络连接状态观察者
//        NetworkStateReceiver.registerObserver(new NetworkStateReceiver.NetworkChangeObserver() {
//            @Override
//            public void onConnect(NetworkUtils.netType networkType) {
//                // 网络已连接
//                EventBusUtils.postEvent(Consts.DataEventType.NET_CONNECTION_ACCESS);
//            }
//
//            @Override
//            public void onDisConnect() {
//                // 网络未连接
//                EventBusUtils.postEvent(Consts.DataEventType.NET_CONNECTION_BREAK);
//            }
//        });
//    }

//    /**
//     * 初始化NoHttp
//     */
//    private void initNoHttp() {
//        // 初始化及配置
//        NoHttp.initialize(this, new NoHttp.Config()
//                .setConnectTimeout(15 * 1000) // 全局连接超时时间，单位毫秒
//                .setReadTimeout(15 * 1000) // 全局服务器响应超时时间，单位毫秒
//                .setCacheStore(
//                        new DBCacheStore(this) // 配置缓存到数据库
//                                .setEnable(true))  // true启用缓存，fasle禁用缓存
//                .setCookieStore(
//                        new DBCookieStore(this)
//                                .setEnable(false)) // true启用自动维护Cookie，fasle禁用自动维护Cookie
//        );
//
//        // 调试模式
//        Logger.setTag("muz");
//        Logger.setDebug(true);
//    }

    /**
     * 结束进程
     */
    public void finishActivity() {
        // 关闭Activity
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        //结束进程
        Process.killProcess(Process.myPid());
    }
    /**
     * log in again
     */
    public void logInAgain() {
        // 关闭Activity
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
    }
    /**
     * 向Activity集合中添加元素
     *
     * @param activity activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 从Activity集合中移除元素
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 获取MyApplication实例
     *
     * @return MyApplication实例
     */
    public static MyApplication getInstance() {
        return instance;
    }




}
