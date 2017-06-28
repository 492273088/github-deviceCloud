package com.gxl.dcloud.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//检查数组是否包含某个值的方法
public class ArrayUtil {

    /**
     * 使用List
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useList(String[] arr,String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }

    /**
     * 使用Set
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useSet(String[] arr,String targetValue){
        Set<String> set=new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    /**
     * 使用循环判断
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useLoop(String[] arr,String targetValue){
        for(String s:arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }

    /**
     * 查找有序数组中是否包含某个值的用法
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useArraysBinarySearch(String[] arr,String targetValue){
        int a=Arrays.binarySearch(arr, targetValue);
        if(a>0)
            return true;
        else
            return false;
    }

    /**
     * 使用ArrayUtils
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useArrayUtils(String[] arr,String targetValue){
        return ArrayUtils.contains(arr,targetValue);
    }

}
