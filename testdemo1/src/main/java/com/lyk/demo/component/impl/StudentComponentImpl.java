package com.lyk.demo.component.impl;

import com.lyk.demo.component.StudentComponent;
import com.lyk.demo.dataDo.StudentDO;
import com.lyk.demo.mapper.StudentMapper;
import com.lyk.demo.vo.req.StudentReqVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class StudentComponentImpl implements StudentComponent {

    @Autowired
    private StudentMapper studentMapper;


    /**
     * 查询学生表所有数据
     *
     * @return
     */
    @Override
    public List<StudentDO> queryAllStudents() {
        List<StudentDO> studentDOList = studentMapper.selectAllStudents();
        log.info("学生表【student】查询条数：{}", studentDOList.size());
        return studentDOList;
    }

    @Override
    public List<StudentDO> queryByClasses(StudentReqVO studentReqVO) {
//        Wrapper studentDOWrapper = new Wrapper<>();
//        List<StudentDO> studentDOList = studentMapper.selectList();
        Map<String, Object> columnMap = new HashMap<>();
        if (StringUtils.isNotEmpty(studentReqVO.getClasses())) {
            columnMap.put("classes", studentReqVO.getClasses());
        }
        if (StringUtils.isNotEmpty(studentReqVO.getGender())) {
            columnMap.put("gender", studentReqVO.getGender());
        }
        if (StringUtils.isNotEmpty(studentReqVO.getName())) {
            columnMap.put("name", studentReqVO.getName());
        }
        if (null != studentReqVO.getAge()) {
            columnMap.put("age", studentReqVO.getAge());
        }
        List<StudentDO> studentDOS = studentMapper.selectByMap(columnMap);
        return studentDOS;
    }
}
