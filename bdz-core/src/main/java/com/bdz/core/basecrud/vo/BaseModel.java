package com.bdz.core.basecrud.vo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * @author bdz
 * @date 2018/4/18 9:53
 */
@MappedSuperclass
@Data
public class BaseModel {
  @Id
  @GenericGenerator(name="seq_id", strategy="com.bdz.core.util.CustomizedIdGenerator")
  @GeneratedValue(generator="seq_id")
  private Long uuid;
  private String oper;
  @Column(name = "ope_date")
  private String opeDate;
  @Column(name = "del_flag")
  private String delFlag;

}
