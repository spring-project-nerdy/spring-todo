package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
/*
@RequestMapping("main")
*/
public class MainController {

  @RequestMapping("/testJSP")
  public String test1() throws Exception{
    ModelAndView mav = new ModelAndView("testJSP");
    mav.addObject("name", "JSP");

    List<String> testList = new ArrayList<String>();
    testList.add("a");
    testList.add("b");
    testList.add("c");

    mav.addObject("list", testList);
    return "testJSP";
  }
}
