package com.codemaidtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codemaidtech.dto.TicketInfo;
import com.codemaidtech.service.TicketService;

@Controller
@RequestMapping("/booking")
public class TicketController {
	
	@Autowired
	private TicketService service;

	@GetMapping("/")
	public String homePage() {
		return "home";
	}
//	@GetMapping("/")
//	public String homePage() {
//	    return "redirect:/booking/book";
//	}
	
	@GetMapping("/book")
	public String bookPage(Model model) {
		model.addAttribute("ticket", new TicketInfo());
		model.addAttribute("cities", service.getAllCitys());
//		System.out.println("data fetched from db");
		return "book";
	}
	
	@PostMapping("/save")
	public String userTiket(@ModelAttribute("ticket") TicketInfo info, Model model) {
		
		service.saveUser(info);
		
		String msg = "hi" + info.getFname() + "your ticket is book from" + info.getFromCity() + "to" + info.getToCity() + "sucessfully";
		
		model.addAttribute("msg", msg);
		
		return "sccess";
	}
}
