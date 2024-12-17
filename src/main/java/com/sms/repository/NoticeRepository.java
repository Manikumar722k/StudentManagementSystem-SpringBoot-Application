package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
