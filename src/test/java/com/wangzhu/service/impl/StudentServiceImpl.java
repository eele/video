package com.wangzhu.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wangzhu.dataset.StudentDateSet;
import com.wangzhu.service.StudentService;
import com.wangzhu.vo.StudentListVo;
import com.wangzhu.vo.StudentVo;

@Component("studentService")
public class StudentServiceImpl implements StudentService {
    @SuppressWarnings("unused")
	@Autowired
    private StudentDateSet studentDateSet;

    /**
     * url:http://<host>:<port>/<appcontext>/services/studentService/status
     */
    @Override
    @GET
    @Path("/status")
    public String getStatus() {
        return "getStatus";
    }

    /**
     * url:http://<host>:<port>/<appcontext>/services/studentService/students/{
     * index}
     */
    @Override
    @GET
    @Path("/students/{index}")
    public StudentVo getStudentById(@PathParam("index") Integer id) {
        List<StudentVo> studentList = StudentDateSet.getList();
        StudentVo vo = null;
        if (studentList.size() > id) {
            vo = studentList.get(id - 1);
        }
        return vo;
    }

    /**
     * url:http://<host>:<port>/<appcontext>/services/studentService/students
     */
    @Override
    @GET
    @Path("/students")
    public StudentListVo getStudentList() {
        List<StudentVo> studentList = StudentDateSet.getList();
        StudentListVo listVo = new StudentListVo(studentList);
        return listVo;
    }

}