package com.gxl.dcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by XiaoLei Guo on 2017/6/23.
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{


    public String index(ModelAndView modelAndView, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){


        return "";
    }

}
