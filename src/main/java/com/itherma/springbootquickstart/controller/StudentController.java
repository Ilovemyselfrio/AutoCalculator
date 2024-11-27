package com.itherma.springbootquickstart.controller;

import com.itherma.springbootquickstart.Response;
import com.itherma.springbootquickstart.dao.Student;
import com.itherma.springbootquickstart.dto.StudentDto;
import com.itherma.springbootquickstart.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
public class StudentController {
    @Autowired//注入serivce层的代码
    private StudentService studentService;
    @GetMapping("/student/{id}")//路径 {id}是一个路径变量，用于匹配任何位于/student/之后的值，并将其作为参数传递给处理方法。
    public Response<StudentDto> getStudentById(@PathVariable long id) { //@PathVariable对应上面的路径变量id
        return Response.newSuccess(studentService.getStudentById(id));
    }
    @PostMapping("/student")//我们用StudentDto对象跟前端交互，前端传过来的Jeson 会被spring反序列化 到java这个对象studentDto里面来
//直接用java对象来处理前端发来的参数就可以了
    public Response<Long> addNewStudent(@RequestBody StudentDto studentDto){
//        这里一般会写一些校验，为了快速开发 故省略
//        写service对应的代码
        return Response.newSuccess(studentService.addNewStudent(studentDto));
    }
    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable long id) {
        studentService.deleteStudentByID(id);
    }
    @PutMapping("/student/{id}")
//    因为我们去更新email或者name，所以它肯定是非空 ，所以用requestPararm去传递参数，而不是json!
    public Response<StudentDto> updateStudentById(@PathVariable long id, @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String email) {
        return Response.newSuccess(studentService.updateStudentById(id,name,email));
    }

}
