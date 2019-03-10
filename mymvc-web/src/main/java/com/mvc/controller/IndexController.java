package com.mvc.controller;

import com.alan.ui.Model;
import com.alan.utils.MyUtils;
import com.alan.web.bind.annotation.Controller;
import com.alan.web.bind.annotation.PathVariable;
import com.alan.web.bind.annotation.RequestMapping;
import com.alan.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * author: alan.peng
 * description:
 * date: create in 15:03 2018/9/2
 * modified By：
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public void index(){

    }

    @ResponseBody
    @RequestMapping("/send")
    public Object send(){
        Map<String, Object> result = MyUtils.newHashMap();
        result.put("status", 200);
        result.put("message", "SUCCESS");
        return result;
    }

    @RequestMapping("/{test}")
    public void test(Model model, @PathVariable("name") String name) {
        model.addAttribute("name", name);
    }
}
