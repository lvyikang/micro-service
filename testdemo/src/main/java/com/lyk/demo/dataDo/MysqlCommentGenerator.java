package com.lyk.demo.dataDo;

import java.util.Properties;

/**
 * @Author: lyk
 * @Date: 2023/02/08/14:02
 * @Description:
 */
public class MysqlCommentGenerator implements CommentGenerator  {

        private Properties properties;

        public MySQLCommentGenerator() {
            properties = new Properties();
        }

        @Override
        public void addConfigurationProperties(Properties properties) {
            // 获取自定义的 properties
            this.properties.putAll(properties);
        }

        @Override
        public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
            String author = properties.getProperty("author");
            String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
            SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

            // 获取表注释
            String remarks = introspectedTable.getRemarks();

            topLevelClass.addJavaDocLine("/**");
            topLevelClass.addJavaDocLine(" * " + remarks);
            topLevelClass.addJavaDocLine(" *");
            topLevelClass.addJavaDocLine(" * @author " + author);
            topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
            topLevelClass.addJavaDocLine(" */");
        }

        @Override
        public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
            // 获取列注释
            String remarks = introspectedColumn.getRemarks();
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + remarks);
            field.addJavaDocLine(" */");
        }



}
