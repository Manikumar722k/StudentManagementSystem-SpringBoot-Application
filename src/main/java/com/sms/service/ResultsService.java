package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Results;
import com.sms.repository.ResultsRepository;



@Service
public class ResultsService {

	@Autowired
	private ResultsRepository resultsRepository;
	
	public Results saveResults(Results results)
	{
		return resultsRepository.save(results);
	}
	
	public List<Results> getResults()
	
	{
	return resultsRepository.findAll();	
	}
	
	public Results updateResults(Results results)
	{
		return resultsRepository.save(results);
	}
	
	public Results getResultsById(Long regNumber)
	{
		return resultsRepository.findById(regNumber).get();
	}
	
	public void deleteResults(Long id)
	{
		resultsRepository.deleteById(id);
	}
}
