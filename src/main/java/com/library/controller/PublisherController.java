package com.library.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.model.Publisher;
import com.library.service.PublisherService;

@Controller
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping("/publisher/list")
	public String viewPublisherList(Model model) {
		model.addAttribute("publishersList", publisherService.getAllPublishers());
		return "publisher";
	}
	
	 @GetMapping("/newPublisherForm")
	 public String newPublisherForm(Model model) {
		 Publisher publisher = new Publisher();
		 model.addAttribute("publisher", publisher);
	     return "new_publisher";
	 }
	 
	 @PostMapping("/savePublisher")
	 public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
	     publisherService.savePublisher(publisher);
	     return "redirect:/publisher/list";
	 }
	 
	 @GetMapping("/updatePublisher/{id}")
	    public String updatePublisher(@PathVariable(value = "id") long id, Model model) {
	        Publisher publisher = publisherService.getPublisherById(id);
	        model.addAttribute("publisher", publisher);
	        return "update_publisher";
	    }
	 
	 @GetMapping("/deletePublisher/{id}")
	 public String deletePublisher(@PathVariable (value = "id") long id) {
		 publisherService.deletePublisherById(id);
		 return "redirect:/publisher/list";
	 }

}
