package com.tehtava.kirjakauppa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tehtava.kirjakauppa.bean.Book;

@Controller
public class BookstoreController {
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String Books(Model model) {
		
		model.addAttribute("friend", new Book());
		return "/index";
	}
	
}
