package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student getStudentById(Long id)
	{
		return studentRepository.findById(id).get();
	}
	
	public Student updateStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Long id)
	{
		studentRepository.deleteById(id);
	}
	
	public Long  studentCount()
	{
		return studentRepository.count();
		 
	}
}
