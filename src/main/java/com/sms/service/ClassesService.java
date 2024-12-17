package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Classes;
import com.sms.repository.ClassesRepository;

@Service
public class ClassesService {

	@Autowired
	private ClassesRepository classesRepository;
	
	public List<Classes> getAllClasses()
	{
		return classesRepository.findAll();
	}
	
	public Classes saveClass(Classes classes)
	{
		return classesRepository.save(classes);
	}
	
	public Classes getClassesById(Long id)
	{
		return classesRepository.findById(id).get();
	}
	
	public Classes updateClass(Classes classes)
	{
		return classesRepository.save(classes);
	}
	public void deleteClass(Long id)
	{
		classesRepository.deleteById(id);
	}
	
	public Long classCount()
	{
		return classesRepository.count();
	}
}
