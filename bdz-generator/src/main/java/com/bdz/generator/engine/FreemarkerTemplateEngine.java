package com.bdz.generator.engine;

import com.bdz.generator.utils.FreeMarkerTemplateUtils;

import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author bdz
 * @date 2018/6/1 11:43
 */
public class FreemarkerTemplateEngine {


  /**
   * 根据模板生成对应文件
   *
   * @param templateName
   * @param file
   * @param dataMap
   * @throws Exception
   */
  private void generateFileByTemplate(
      final String templateName, File file, Map<String, Object> dataMap) throws Exception {
    Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
    FileOutputStream fos = new FileOutputStream(file);
    Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
    template.process(dataMap, out);
  }
}
