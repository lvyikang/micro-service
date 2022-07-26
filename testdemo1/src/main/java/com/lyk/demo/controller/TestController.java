package com.lyk.demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lyk.demo.service.TestService;
import com.lyk.demo.vo.req.StudentReqVO;
import com.lyk.demo.vo.res.StudentResVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

@Slf4j
@RestController
@Api(value = "搭建服务测试Controller", tags = "测试Controller")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "test/testController", method = {RequestMethod.POST})
    public String testController() {
        log.info("testcontroller==============");
        return "微服务测试成功！";
    }

    @ApiOperation(value = "测试查数据库")
    @RequestMapping(value = "test/testQuery", method = {RequestMethod.POST})
    public List<StudentResVO> testQuery() {
        log.info("测试查询数据库开始==========");
        List<StudentResVO> studentResVOList = testService.queryAllStudents();
        log.info("查询数据库数据结束：{}", JSON.toJSONString(studentResVOList));
        return studentResVOList;
    }

    @ApiOperation(value = "测试根据条件查询")
    @ApiOperationSupport(ignoreParameters = {"name", "age"})//接口文档忽略展示字段
    @PostMapping(value = "test/testQueryByClasses")
    public List<StudentResVO> testQueryByClasses(StudentReqVO studentReqVO) {
        log.info("测试根据条件查询请求参数:{}",JSON.toJSONString(studentReqVO));
        List<StudentResVO> studentResVOList = testService.queryByClasses(studentReqVO);
        log.info("测试根据条件查询响应参数：{}", JSON.toJSONString(studentResVOList));
        return studentResVOList;
    }

    public static void main(String[] args) throws Exception {
        //https://blog.csdn.net/yyt593891927/article/details/110202102?spm=1001.2101.3001.6650.13&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-13-110202102-blog-124841874.pc_relevant_sortByAnswer&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-13-110202102-blog-124841874.pc_relevant_sortByAnswer&utm_relevant_index=20
        String content ="6789";
        String password = "123456";
        // 使用密钥生成器
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        String base64key = Base64.encodeBase64String(enCodeFormat);
        System.out.println(base64key);
        OutPut(enCodeFormat);//密钥

        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        byte[] byteContent = content.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(byteContent);
        String str = Base64.encodeBase64String(result);
        System.out.println("密文："+str);
    }

    public static void OutPut(byte[] content) {
        for (int i=0; i<content.length; i++) {
            System.out.print(content[i] + ", ");
        }
        System.out.print("\n");
    }




}
