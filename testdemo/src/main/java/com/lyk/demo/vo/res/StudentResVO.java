package com.lyk.demo.vo.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 学生信息前端响应类
 */
@Data
@ApiModel(value = "响应前端学生类",description = "响应前端学生信息")
public class StudentResVO {

    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;

    @ApiModelProperty(value = "班级", example = "九年1班")
    private String classes;

    @ApiModelProperty(value = "性别", example = "F")
    private String gender;

    @ApiModelProperty(value = "年龄", example = "28")
    private Integer age;

}
