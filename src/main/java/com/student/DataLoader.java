package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StudentRepository repo;

    @Override
    public void run(String... args) throws Exception {

        Student s = new Student();
        s.setName("Yash");
        s.setRollNo("17");
        s.setCourse("BCA");
        s.setMarks(85);

        repo.save(s);

        System.out.println("✅ Sample Student Inserted!");
    }
}