package com.lyk.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyk.demo.dataDo.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface StudentMapper extends BaseMapper<StudentDO> {

    @Select("select * from student")
    List<StudentDO> selectAllStudents();
}
