package com.itherma.springbootquickstart.service;

import com.itherma.springbootquickstart.controller.StudentController;
import com.itherma.springbootquickstart.converter.StudentConverter;
import com.itherma.springbootquickstart.dao.Student;
import com.itherma.springbootquickstart.dao.StudentRepository;
import com.itherma.springbootquickstart.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired//实现注入 注入studentRepository 我们才可以去使用
    private StudentRepository studentRepository;
    @Override
    public StudentDto getStudentById(long id) {
//        //findById 父接口提供的方法
//        return studentRepository.findById(id).orElseThrow(RuntimeException::new);//如果不存在则抛出异常！
          Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
//          做个convert 转换
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDto studentDto) {
        List<Student> studentList = studentRepository.findByEmail(studentDto.getEmail());
//        判断
        if(!CollectionUtils.isEmpty(studentList)){
            throw new IllegalStateException("email:" + studentDto.getEmail() + "has been taken");
        }
        return null;

    }
}
