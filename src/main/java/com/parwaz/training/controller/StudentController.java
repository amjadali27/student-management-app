package com.parwaz.training.controller;

import com.parwaz.training.model.Student;
import com.parwaz.training.response.GenericResponse;
import com.parwaz.training.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {

    Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<GenericResponse> addStudent(@RequestBody Student student) {
        log.info("Add Student call initiated from controller...");
        ResponseEntity<GenericResponse> response = service.addStudent(student);
        log.info("Add Student call completed");
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<GenericResponse> updateStudent(@RequestBody Student student) {
        log.info("Update Student call initiated from controller...");
        ResponseEntity<GenericResponse> response = service.updateStudent(student);
        log.info("Update Student call completed");
        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<GenericResponse> deleteStudent(@RequestParam(name = "id") Integer studentId){
        log.info("Delete Student call initiated from controller...");
        ResponseEntity<GenericResponse> response =  service.deleteStudent(studentId);
        log.info("Delete Student call completed");
        return response;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<GenericResponse> getAllStudents(){
        log.info("Get All Students call initiated from controller...");
        ResponseEntity<GenericResponse> response =  service.getAllStudents();
        log.info("Get All Students call completed");
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GenericResponse> getStudent(@PathVariable(name = "id") Integer studentId){
        log.info("Find Student call initiated from controller...");
        ResponseEntity<GenericResponse> response =  service.findStudent(studentId);
        log.info("Find Student call completed");
        return response;
    }
}
