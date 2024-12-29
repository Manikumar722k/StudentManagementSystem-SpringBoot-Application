package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sms.entity.Results;
import com.sms.service.ResultsService;

import jakarta.validation.Valid;


@Controller
public class ResultsController {
	
	@Autowired
	private ResultsService resultsService;
	
	
	@GetMapping(value = "/addResult")
	public String addResult(Model model)
	{
		model.addAttribute(new Results());
		return "add_Result_View";
	}

	@PostMapping("saveResults")
	public String saveResults(@Valid Results results,BindingResult bindingResult,Model  model) {
		if(bindingResult.hasErrors())
		{
			return "add_Result_View";
		}
		resultsService.saveResults(results);
		return "redirect:/viewResults ";
	}
	
	@GetMapping(value = "/viewResults")
	public String viewResults(Model model)
	{
		model.addAttribute("results", resultsService.getResults());
		return "results_view";
	}
	
	@GetMapping(value = "/editResults/{id}")
	public String editResults(@PathVariable("id") Long id,Model model)
	{
		Results results=resultsService.getResultsById(id);
		model.addAttribute(results);
		return "update_results_view";
	}
	
	@PostMapping(value = "/updateResults")
	public String updateResults(@Valid Results results,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors())
		{
			return "update_results_view";
		}
		resultsService.updateResults(results);
		return "redirect:/viewResults";
	}
	
	@GetMapping(value = "/deleteResult/{id}")
	public String deleteResult(@PathVariable("id") Long id)
	{
		resultsService.deleteResults(id);
		return "redirect:/viewResults";
	}
}
