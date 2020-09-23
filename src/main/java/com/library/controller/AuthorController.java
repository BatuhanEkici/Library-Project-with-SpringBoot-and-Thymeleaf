package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.model.Author;
import com.library.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/author/list")
	public String viewAuthorList(Model model) {
		model.addAttribute("authorsList", authorService.getAllAuthors());
		return "author";
	}
	
	 @GetMapping("/newAuthorForm")
	 public String newAuthorForm(Model model) {
		 Author author = new Author();
		 model.addAttribute("author", author);
	     return "new_author";
	 }
	 
	 @PostMapping("/saveAuthor")
	 public String saveAuthor(@ModelAttribute("author") Author author) {
	     authorService.saveAuthor(author);
	     return "redirect:/author/list";
	 }
	 
	 @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
	        Author author = authorService.getAuthorById(id);
	        model.addAttribute("author", author);
	        return "update_author";
	    }
	 
	 @GetMapping("/deleteAuthor/{id}")
	 public String deleteAuthor(@PathVariable (value = "id") long id) {
		 authorService.deleteAuthorById(id);
		 return "redirect:/author/list";
	 }
	 
	 

}
