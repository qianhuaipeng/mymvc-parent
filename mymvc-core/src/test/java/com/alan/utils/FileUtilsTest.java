package com.alan.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 16:50 2018/8/2
 * modified By：
 */

public class FileUtilsTest {

    @Test
    public void findFiles(){
        List<File> files = FileUtils.findFiles(".class");
        System.out.println(JSONObject.toJSONString(files));
    }
}
