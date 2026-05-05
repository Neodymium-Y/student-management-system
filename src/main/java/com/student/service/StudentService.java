package com.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student save(Student s) {
        return repo.save(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
    public Student update(int id, Student s) {
        Student existing = repo.findById(id).orElseThrow();

        existing.setName(s.getName());
        existing.setRollNo(s.getRollNo());
        existing.setCourse(s.getCourse());
        existing.setMarks(s.getMarks());

        return repo.save(existing);
    }
    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }
    public List<Student> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }
    
}