package com.yogie.controller;

import com.yogie.mq.RedPacktProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: prac-mq
 * @Date: 2019/12/17 21:37
 * @Author: Chenyogie
 * @Description:
 */
@RestController
public class IndexController {

    @Autowired
    private RedPacktProvider redPacktProvider;

    @RequestMapping("/test")
    public ModelAndView hello(){
        //model用来绑定数据
        //model.addAttribute("hello","chenyogie!!!");
        //通过视图模型器来返回指定的视图
        return new ModelAndView("index");
    }
}
