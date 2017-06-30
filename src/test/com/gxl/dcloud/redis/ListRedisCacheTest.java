package com.gxl.dcloud.redis;

import com.gxl.dcloud.mapper.LogInfoMapper;
import com.gxl.dcloud.pojo.LogEnty;
import junit.framework.TestCase;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by XiaoLei Guo on 2017/6/27.
 */
public class ListRedisCacheTest extends TestCase {
    LogInfoMapper logInfoMapper;
    ListRedisCache listRedisCache;

    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mvc.xml");
        logInfoMapper = (LogInfoMapper)ac.getBean("logInfoMapper");
        listRedisCache = (ListRedisCache)ac.getBean("listRedisCache");
    }

    public void testLpush() throws Exception {
        LogEnty logEnty = new LogEnty();
        logEnty.setCommite("测试");
        logEnty.setData(System.currentTimeMillis());
        logEnty.setIp("127.0.0.1");
        logEnty.setMethod("插入");
        logEnty.setModule("系统模块");
        logEnty.setResponseData(System.currentTimeMillis());
        logEnty.setUserId(103580);

        listRedisCache.lpush("listTest",logEnty.toString());
    }

    public void testExpire() throws Exception {
        listRedisCache.expire("listTest",60*1000);

    }

    public static void main(String arg[]){

        String filename = "DSC_3898-Edit-2.jpg";
        String str = getFileSuffixName(filename);
        System.out.println(str);
    }

    public static String getFileSuffixName(String file) {
        if(StringUtils.isBlank(file)){
            return null;
        }
        String prefix = file.substring(file.lastIndexOf(".") + 1).toLowerCase();
        String suffix = "";
        String[] imgArray = {"jpg", "bmp", "jepg", "png", "gif", "pic"};
        String[] zipArray = {"rar", "zip", "gz", "7z", "zpaq"};
        String[] excelArray = {"xlsx", "xls"};
        String[] wordArray = {"doc", "docx", "wps"};
        String[] txtArray ={"txt"};
        String[] pdfArray ={"pdf"};
        String[] pptArray ={"ppt"};

        if(useList(imgArray,prefix)){
            suffix = "midJpgIcon";
        }else if(useList(zipArray,prefix)){
            suffix = "midZipIcon";
        }else if(useList(excelArray,prefix)){
            suffix = "midExcelIcon";
        }else if(useList(wordArray,prefix)){
            suffix = "midWordIcon";
        }else if(useList(txtArray,prefix)){
            suffix = "midTxtIcon";
        }else if(useList(pdfArray,prefix)){
            suffix = "midPdfIcon";
        }else if(useList(pptArray,prefix)){
            suffix = "midPptIcon";
        }else{
            suffix = "midTxtIcon";
        }
        return suffix;
    }

    //使用List
    public static boolean useList(String[] arr,String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }
    //使用Set
    public static boolean useSet(String[] arr,String targetValue){
        Set<String> set=new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }
    //使用循环判断
    public static boolean useLoop(String[] arr,String targetValue){
        for(String s:arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }
    //查找有序数组中是否包含某个值的用法
    public static boolean useArraysBinarySearch(String[] arr,String targetValue){
        int a=Arrays.binarySearch(arr, targetValue);
        if(a>0)
            return true;
        else
            return false;
    }
    //使用ArrayUtils
    public static boolean useArrayUtils(String[] arr,String targetValue){
        return ArrayUtils.contains(arr,targetValue);
    }
}