package com.gxl.dcloud.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by XiaoLei Guo on 2017/6/30.
 */
public class ThreadPoolUtil {

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

    public static void execute(Runnable runnable){
        fixedThreadPool.execute(runnable);
    }

}
