package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Notice;
import com.sms.repository.NoticeRepository;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	//Read
	public List<Notice> getAllNotices()
	{
		return noticeRepository.findAll();
	}
	
	//create
	public Notice saveNotice(Notice notice)
	{
		return noticeRepository.save(notice);
	}
	
	//getOne
	public Notice getNoticeById(Long id)
	{
		return noticeRepository.findById(id).get();
	}
	
	//update
	public Notice updateNotice(Notice notice)
	{
		return noticeRepository.save(notice);
	}
	
	//delete
	public void deleteNotice(Long id)
	{
		noticeRepository.deleteById(id);
	}
	
	public Long noticeCount()
	{
		return noticeRepository.count();
	}
}
