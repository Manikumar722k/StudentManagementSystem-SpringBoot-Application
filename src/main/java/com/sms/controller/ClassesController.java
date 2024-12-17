package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.sms.entity.Classes;
import com.sms.service.ClassesService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ClassesController {

	@Autowired
	private ClassesService classesService;
	
	@GetMapping("/getAllClasses")
	public String getAllClasses(Model model) {
		model.addAttribute("classes", classesService.getAllClasses());
		return "classes_view";
	}
	
	@GetMapping("/addClasses")
	public String addClasses(Model model) {
		model.addAttribute(new Classes());
		return "add_classes";
	}
	
	@PostMapping("/saveClasses")
	public String saveClasses(@Valid  Classes classes,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			return "add_classes";
		}
		classesService.saveClass(classes);
		return "redirect:/getAllClasses";
	}
	
	@GetMapping("/deleteClasses/{id}")
	public String deleteClasses(@PathVariable("id") Long id)
	{
		classesService.deleteClass(id);
		return "redirect:/getAllClasses";
	}
	
	@GetMapping("/editClasses/{id}")
	public String editClasses(@PathVariable("id") Long id ,Model model)
	{
		Classes classes=classesService.getClassesById(id);
		model.addAttribute(classes);
		return "update_classes";
	}
	
	@PostMapping("/updateClasses")
	public String updateClasses(@Valid Classes classes,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "update_classes";
		}
		classesService.updateClass(classes);
		return "redirect:/getAllClasses";
	}
}
