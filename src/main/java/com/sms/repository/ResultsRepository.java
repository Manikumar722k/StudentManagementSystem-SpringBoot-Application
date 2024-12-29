package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Results;

public interface ResultsRepository extends JpaRepository<Results, Long> {

}
