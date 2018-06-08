package com.bdz.core.basecrud.controller;


import com.bdz.core.basecrud.entity.BaseModel;
import com.bdz.core.basecrud.service.BaseService;
import com.bdz.core.beans.ResultBean;
import com.bdz.core.util.MD5Util;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bdz
 * @date 2018/4/18 15:30
 */
public class BaseController<M extends BaseModel, QM extends BaseModel>{

  private BaseService baseService;

  private String prefix = "";
  private String htmlName = "";

  public void setBaseService(BaseService baseService) {
    this.baseService = baseService;
  }
  public BaseController(String prefix,String htmlName){
    this.prefix = prefix;
    this.htmlName = htmlName;
  }
  @RequestMapping(value="/toList", method = { RequestMethod.GET })
  public String toList(){
    return prefix+htmlName+"list";
  }
  @RequestMapping(value="/toAdd", method = { RequestMethod.GET })
  public String toAdd(){
    return prefix+htmlName+"add";
  }

}
