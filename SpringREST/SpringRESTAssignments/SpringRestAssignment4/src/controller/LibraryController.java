package controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Book;

@RestController
@RequestMapping("/book")
public class LibraryController{
	
	Map<Integer, Book> bk = new HashMap<Integer,Book>();
	public LibraryController(){
		bk.put(1,new Book(1,"DevOps",2012));
		bk.put(2,new Book(2,"Angular",2020));
		bk.put(3,new Book(3,"Linux",2001));
		bk.put(4,new Book(4,"C",1989));
	}
	
	@RequestMapping("")
	public String getBookDetails() {
		String book = "";
		for (Map.Entry<Integer, Book> e : bk.entrySet()) 
            book+=e.getValue().toString()+"\n";
		return book;
	}
	
	@RequestMapping("/{id}")
	public String getBookDetails(@PathVariable int id) {
		Book book = bk.get(id);
		return book.toString();
	}
	
}
