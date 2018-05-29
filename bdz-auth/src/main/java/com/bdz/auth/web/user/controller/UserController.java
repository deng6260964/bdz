package com.bdz.auth.web.user.controller;

import com.bdz.auth.user.entity.AuthUser;
import com.bdz.auth.user.service.UserService;
import com.bdz.core.beans.ResultBean;
import com.bdz.core.util.MD5Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户controller
 * @author bdz
 * @date 2018/4/18 15:43
 */
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService myService;

  @RequestMapping(value="/add", method = { RequestMethod.POST})
  @ResponseBody
  public ResultBean<AuthUser> add(AuthUser user){
    user.setPassword(MD5Util.encrypt(user.getPassword()));
    return new ResultBean<AuthUser>(myService.add(user));
  }
  @RequestMapping(value="/toList", method = { RequestMethod.GET })
  public String toList(){
    return "user/userlist";
  }
  @RequestMapping(value="/toAdd", method = { RequestMethod.GET })
  public String toAdd(){
    return "user/useradd";
  }

  @RequestMapping(value="/list", method = { RequestMethod.GET })
  @ResponseBody
  public ResultBean<List<AuthUser>> list(HttpServletRequest request){
    String pageNum = request.getParameter("page");
    String pageSize = request.getParameter("limit");
    Page page = myService.getAll(Integer.valueOf(pageNum)-1,Integer.valueOf(pageSize));
    return new ResultBean<List<AuthUser>>(page.getContent(),Integer.valueOf(page.getTotalElements()+""));
  }
}
