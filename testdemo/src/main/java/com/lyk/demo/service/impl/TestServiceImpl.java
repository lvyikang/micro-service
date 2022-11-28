package com.lyk.demo.service.impl;

import com.lyk.demo.component.StudentComponent;
import com.lyk.demo.converter.StudentConverter;
import com.lyk.demo.dataDo.StudentDO;
import com.lyk.demo.service.TestService;
import com.lyk.demo.vo.req.StudentReqVO;
import com.lyk.demo.vo.res.StudentResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private StudentComponent studentComponent;


    @Override
    public List<StudentResVO> queryAllStudents() {
        List<StudentDO> studentDOList = studentComponent.queryAllStudents();
        List<StudentResVO> studentResVOS = new ArrayList<>();
        for (StudentDO studentDO : studentDOList) {
            StudentResVO studentResVO = StudentConverter.INSTANCE.doToResVO(studentDO);
            studentResVOS.add(studentResVO);
        }
        return studentResVOS;
    }

    @Override
    public List<StudentResVO> queryByClasses(StudentReqVO studentReqVO) {
        List<StudentDO> studentDOList = studentComponent.queryByClasses(studentReqVO);
        List<StudentResVO> studentResVOS = new ArrayList<>();
        for (StudentDO studentDO : studentDOList) {
            StudentResVO studentResVO = StudentConverter.INSTANCE.doToResVO(studentDO);
            studentResVOS.add(studentResVO);
        }
        return studentResVOS;
    }
}
