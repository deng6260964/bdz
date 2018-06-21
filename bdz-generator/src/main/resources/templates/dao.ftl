package ${package_name}.dao;

import ${package_name}.entity.${table_name};
import com.bdz.core.basecrud.dao.BaseDao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 描述：${table_annotation}DAO层
 * @author ${author}
 * @date ${date}
 */
@Repository
public interface ${table_name}Dao<M extends ${table_name}, String extends Serializable>
  extends BaseDao<M, String>, UserCustomDao<${table_name}, String> {
  }