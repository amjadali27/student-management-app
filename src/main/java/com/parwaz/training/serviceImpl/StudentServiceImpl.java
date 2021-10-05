package com.parwaz.training.serviceImpl;

import com.parwaz.training.model.Student;
import com.parwaz.training.repository.StudentRepository;
import com.parwaz.training.response.GenericResponse;
import com.parwaz.training.service.StudentService;
import com.parwaz.training.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService, Constants {

    Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentRepository repository;

    @Override
    public ResponseEntity<GenericResponse> addStudent(Student student) {
        log.info("Add Student Call processing...");
        return ResponseEntity.ok().body(new GenericResponse(SUCCESS_MESSAGE,SUCCESS_CODE,repository.save(student)));
    }

    @Override
    public ResponseEntity<GenericResponse> updateStudent(Student student) {
        log.info("Update Student Call processing...");
        return ResponseEntity.ok().body(new GenericResponse(SUCCESS_MESSAGE,SUCCESS_CODE,repository.save(student)));
    }

    @Override
    public ResponseEntity<GenericResponse> getAllStudents() {
        log.info("Get All Student Call processing...");
        return ResponseEntity.ok().body(new GenericResponse(SUCCESS_MESSAGE,SUCCESS_CODE,repository.findAll()));
    }

    @Override
    public ResponseEntity<GenericResponse> deleteStudent(Integer studentId) {
        log.info("Delete Student Call processing...");
        Student s = repository.findAll().stream().filter(student -> student.getId()==studentId).findFirst().get();
        repository.delete(s);
        return ResponseEntity.ok().body(new GenericResponse(SUCCESS_MESSAGE,SUCCESS_CODE,"Student Record Deleted Successfully"));
    }

    @Override
    public ResponseEntity<GenericResponse> findStudent(Integer studentId) {
        log.info("Find Student Call processing...");
        Student s = repository.findAll().stream().filter(student -> student.getId()==studentId).findFirst().get();
        return ResponseEntity.ok().body(new GenericResponse(SUCCESS_MESSAGE,SUCCESS_CODE,s));
    }
}
