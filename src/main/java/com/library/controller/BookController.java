package com.library.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.model.Book;
import com.library.service.BookService;


@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/book/list")
	public String viewBookList(Model model) {
		model.addAttribute("booksList", bookService.getAllBooks());
		return "book";
	}
	
	 @GetMapping("/newBookForm")
	 public String newBookForm(Model model) {
		 Book book = new Book();
		 model.addAttribute("book", book);
	     return "new_book";
	 }
	 
	 @PostMapping("/saveBook")
	 public String saveBook(@ModelAttribute("book") Book book) {
		 bookService.saveBook(book);
	     return "redirect:/book/list";
	 }
	 
	 @GetMapping("/updateBook/{id}")
	    public String updateBook(@PathVariable(value = "id") long id, Model model) {
		 Book book = bookService.getBookById(id);
	        model.addAttribute("book", book);
	        return "update_book";
	    }
	 
	 @GetMapping("/deleteBook/{id}")
	 public String deletePublisher(@PathVariable (value = "id") long id) {
		 bookService.deleteBookById(id);
		 return "redirect:/book/list";
	 }
	 
	 @GetMapping("/search")
	 public String findBookByName(Model model, @Param("keyword") String keyword){
		 model.addAttribute("booksList", bookService.findBookByName(keyword));
		return "book";
	 }
}
