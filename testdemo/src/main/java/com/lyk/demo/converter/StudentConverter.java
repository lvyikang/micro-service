package com.lyk.demo.converter;

import com.lyk.demo.dataDo.StudentDO;
import com.lyk.demo.vo.res.StudentResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentConverter {
    //接口中声明了一个成员变量INSTANCE，母的是让客户端可以访问 Mapper 接口的实现。
     StudentConverter INSTANCE = Mappers.getMapper(StudentConverter.class);


    StudentResVO doToResVO(StudentDO studentDO);
}
