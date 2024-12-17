package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sms.entity.Notice;
import com.sms.service.NoticeService;

import jakarta.validation.Valid;

@Controller
public class Noticeontroller {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/getAllNotices")
	public String getAllNotices(Model model)
	{
		model.addAttribute("notices", noticeService.getAllNotices());
		return "notices_view";
	}
	
	@PostMapping("/saveNotice")
	public String saveNotice(@Valid Notice notice,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "add_notice_view";
		}
		noticeService.saveNotice(notice);
		return "redirect:/getAllNotices";
	}
	
	@GetMapping("/addNotice")
	public String addNotice(Model model)
	{
		model.addAttribute(new Notice());
		return "add_notice_view";
	}
	
	@GetMapping("/editNotice/{id}")
	public String editNotice(@PathVariable("id") Long id,Model model)
	{
		Notice notice=noticeService.getNoticeById(id);
		model.addAttribute(notice);
		return "update_notice_view";
	}
	
	@PostMapping("/updateNotice")
	public String updateNotice(@Valid Notice notice,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "update_notice_view";
		}
		noticeService.saveNotice(notice);
		return "redirect:/getAllNotices";
	}
	
	@GetMapping("/deleteNotice/{id}")
	public String deleteNotice(@PathVariable("id") Long id)
	{
		noticeService.deleteNotice(id);
		return "redirect:/getAllNotices";
	}
}
