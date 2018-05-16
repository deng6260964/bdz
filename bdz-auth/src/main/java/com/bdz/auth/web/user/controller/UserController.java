package com.bdz.auth.web.user.controller;

import com.bdz.auth.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bdz
 * @date 2018/4/18 15:43
 */
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService myService;

  @RequestMapping(value="/test", method = { RequestMethod.GET })
  public String test(){
    myService.test("1","2");
    return "welcome";
  }
  @RequestMapping(value="/test2", method = { RequestMethod.GET })
  public String test2(){
    return "index";
  }
}
