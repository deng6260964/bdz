package ${package_name}.service.impl;

import ${package_name}.dao.${table_name}Dao;
import ${package_name}.entity.${table_name};
import ${package_name}.service.${table_name}Service;
import com.bdz.core.basecrud.service.impl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 描述：${table_annotation}控制层实现
 * @author ${author}
 * @date ${date}
 */
@Service
public class${table_name}ServiceImpl extends BaseServiceImpl implements ${table_name}Service {
  private ${table_name}Dao ${table_name?uncap_first}DAO;
  @Autowired
  public void set${table_name}DAO(${table_name}Dao ${table_name?uncap_first}DAO){
    this.${table_name?uncap_first}DAO = ${table_name?uncap_first}DAO;
    super.setMyDao(${table_name?uncap_first}DAO);
  }
}
