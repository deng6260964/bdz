package com.bdz.auth.web.user.controller;

import com.bdz.auth.module.user.entity.AuthUser;
import com.bdz.auth.module.user.entity.AuthUserQueryModel;
import com.bdz.auth.module.user.service.UserService;
import com.bdz.core.basecrud.controller.BaseController;
import com.bdz.core.beans.ResultBean;
import com.bdz.core.util.MD5Util;
import com.bdz.core.util.SpringContextUtils;
import com.bdz.generator.CodeGenerator;
import com.bdz.generator.dto.TemplateDTO;
import com.bdz.generator.utils.GenerateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 * 用户controller
 *
 * @author bdz
 * @date 2018/4/18 15:43
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<AuthUser, AuthUserQueryModel> {

  @Autowired private UserService myService;

  private static final String prefix = "user/";
  private static final String htmlName = "user";

  @Autowired private DataSourceProperties dataSourceProperties;

  public UserController() {
    super(prefix, htmlName);
  }

  @RequestMapping(
    value = "/add",
    method = {RequestMethod.POST}
  )
  @ResponseBody
  public ResultBean<AuthUser> add(AuthUser user) {
    user.setPassword(MD5Util.encrypt(user.getPassword()));
    return new ResultBean<AuthUser>(myService.add(user));
  }

  @RequestMapping(
    value = "/list",
    method = {RequestMethod.GET}
  )
  @ResponseBody
  public ResultBean<List<AuthUser>> list(HttpServletRequest request) {
    String pageNum = request.getParameter("page");
    String pageSize = request.getParameter("limit");
    Page page = myService.getAll(Integer.valueOf(pageNum) - 1, Integer.valueOf(pageSize));
    return new ResultBean<List<AuthUser>>(page);
  }

  @RequestMapping(
    value = "/test",
    method = {RequestMethod.GET}
  )
  @ResponseBody
  public void test() {
    DataSource dataSource = (DataSource) SpringContextUtils.getBean("dataSource");
    try {
      TemplateDTO templateDTO = new TemplateDTO();
      templateDTO.setAuthor("bdz");
      templateDTO.setTableName("auth_role");
      templateDTO.setCurrentDate("2018/06/12");
      templateDTO.setDiskPath("E://");
      CodeGenerator.generate(dataSource.getConnection(),templateDTO);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
