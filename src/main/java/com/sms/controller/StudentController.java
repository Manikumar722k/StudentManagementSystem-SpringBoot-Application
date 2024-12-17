package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.entity.Student;
import com.sms.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = {"/","/home"})
	public String home()
	{
		
		return "redirect:/smsHome";
	}
	
	@GetMapping(value = {"/smsHome"})
	public String smsHome()
	{
		
		return "sms_home";
	}
	
	@GetMapping(value = {"/stuHome"})
	public String stuHome(Model model)
	{
		model.addAttribute("students", studentService.getAllStudents());
		return "stu_home";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model)
	{
		model.addAttribute(new Student());
		return "add_student_view";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid Student student,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "add_student_view";
		}
		studentService.saveStudent(student);
		return "redirect:/stuHome";
	}
	
	@GetMapping("/editStudent/{id}")
	public String editStudent(@PathVariable("id") Long id,Model model)
	{
		Student student=studentService.getStudentById(id);
		model.addAttribute(student);
		return "update_student_view";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@Valid Student student,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "update_student_view";
		}
		studentService.updateStudent(student);
		return "redirect:/stuHome";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") Long id)
	{
		studentService.deleteStudent(id);
		return "redirect:/stuHome";
	}
	
}
