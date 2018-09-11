package com.mvc.controller;

import com.alan.ui.Model;
import com.alan.web.bind.annotation.Controller;
import com.alan.web.bind.annotation.PathVariable;
import com.alan.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/{test}")
    public void test(Model model, @PathVariable("name") String name) {
        model.addAttribute("name", name);
    }
}
