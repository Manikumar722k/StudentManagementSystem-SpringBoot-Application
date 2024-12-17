package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sms.service.ClassesService;
import com.sms.service.NoticeService;
import com.sms.service.StudentService;

@Controller
public class DashBoardController {

	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassesService classesService;
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/dashBoard")
	public String dashBoardStuCount(Model model)
	{
		model.addAttribute("stuDashBoard", studentService.studentCount());
		model.addAttribute("classDashBoard", classesService.classCount());
		model.addAttribute("noticeDashBoard", noticeService.noticeCount());
		return "dashBoard_view";
	}
	
	
}
