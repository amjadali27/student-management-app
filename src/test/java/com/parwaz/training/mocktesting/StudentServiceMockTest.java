package com.parwaz.training.mocktesting;

import com.parwaz.training.model.Student;
import com.parwaz.training.repository.StudentRepository;
import com.parwaz.training.serviceImpl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentServiceMockTest {

    @InjectMocks
    StudentServiceImpl studentMockService;

    @Mock
    StudentRepository mockRepository;

    @Test
    public void getAllUsersTest1(){
        Mockito.when(mockRepository.findAll()).thenReturn(Stream.of
                (new Student(1,"Amjad",23,"F16SW27","")).collect(Collectors.toList()));
        List<Student> list = (List<Student>)studentMockService.getAllStudents().getBody().getResponse();
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void getAllUsersTest2(){
        Mockito.when(mockRepository.findAll()).thenReturn(Stream.of(
                                new Student(1,"Amjad",23,"F16SW27",""),
                                new Student(1,"Amjad",23,"F16SW27",""),
                                new Student(1,"Amjad",23,"F16SW27","")).collect(Collectors.toList()));
        List<Student> list = (List<Student>)studentMockService.getAllStudents().getBody().getResponse();
        Assert.assertEquals(3,list.size());
    }


    @Test
    public void addStudentTest(){
        Student s = new Student(1,"Amjad",23,"F16sw27","abc@gmail.com");
        Mockito.when(mockRepository.save(s)).thenReturn(s);
        Assert.assertEquals(s,studentMockService.addStudent(s).getBody().getResponse());
    }

    @Test
    public void updateStudentTest(){
        Student s = new Student(1,"Amjad",23,"F16sw27","abc@gmail.com");
        Mockito.when(mockRepository.save(s)).thenReturn(s);
        Assert.assertEquals(s,studentMockService.updateStudent(s).getBody().getResponse());
    }

    @Test
    public void deleteStudentTest(){
        Student s = new Student(1,"Amjad",23,"F16sw27","abc@gmail.com");
        Mockito.when(mockRepository.findAll()).thenReturn(Stream.of(s).collect(Collectors.toList()));
        Assert.assertEquals("Student Record Deleted Successfully",studentMockService.deleteStudent(1).getBody().getResponse());
    }

    @Test
    public void findStudentTest(){
        Student s = new Student(1,"Amjad",23,"F16sw27","abc@gmail.com");
        Mockito.when(mockRepository.findAll()).thenReturn(Stream.of(s).collect(Collectors.toList()));
        Assert.assertEquals(s,studentMockService.findStudent(1).getBody().getResponse());
    }

}
