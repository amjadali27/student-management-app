package com.parwaz.training.service;

import com.parwaz.training.model.Student;
import com.parwaz.training.response.GenericResponse;
import org.springframework.http.ResponseEntity;



public interface StudentService {

    /**
     * This method will add new student object into the database
     * @param student
     * @return student reference with auto-generated ID if it gets inserted into the database successfully
     */
    public ResponseEntity<GenericResponse> addStudent(Student student);

    /**
     * This method will update Student record in database
     * @param student
     * @return It will return updated student reference if it gets updated successfully into the database
     */
    public ResponseEntity<GenericResponse> updateStudent(Student student);

    /**
     * This method will will fetch list of all students from database
     * @return It will return List of Student Reference from database
     */
    public ResponseEntity<GenericResponse> getAllStudents();

    /**
     * This method will deleted student record from database
     * @param studentId
     * @return It will return String message that the student deleted from database or not
     */
    public ResponseEntity<GenericResponse> deleteStudent(Integer studentId);

    /**
     * This method will find student for given StudentId
     * @param studentId
     * @return It will return the student Reference if it finds the student with given Id otherwise it will return null
     */
    public ResponseEntity<GenericResponse> findStudent(Integer studentId);
}
