package com.bdz.core.beans;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author bdz
 * @date 2018/5/22 15:41
 */
@Data
public class ResultBean<T> implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final int NO_LOGIN = -1;

  public static final int SUCCESS = 0;

  public static final int FAIL = 1;

  public static final int NO_PERMISSION = 2;

  private int code = SUCCESS;
  private String msg = "success";
  private int count=0;
  private T data;

  public ResultBean() {
    super();
  }

  public ResultBean(T data) {
    super();
    this.data = data;
  }
  public ResultBean(T data,int count) {
    super();
    this.data = data;
    this.count = count;
  }
  public ResultBean(Page<T> page) {
    super();
    this.data = (T) page.getContent();
    this.count = Integer.valueOf(page.getTotalElements()+"");
  }

  public ResultBean(Throwable e) {
    super();
    this.msg = e.toString();
    this.code = FAIL;
  }
}
