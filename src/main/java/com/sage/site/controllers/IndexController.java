package com.sage.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
  @RequestMapping(name = "/index.html",method = RequestMethod.GET)
  public ModelAndView index(){
    return new ModelAndView("index");
  }
}
