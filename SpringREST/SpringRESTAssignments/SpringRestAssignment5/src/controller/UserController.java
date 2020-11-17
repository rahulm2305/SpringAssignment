package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	List<User> lt = new ArrayList<User>();
	UserController(){
		lt.add(new User("Rahul",22));
		lt.add(new User("Snehal",21));
		lt.add(new User("Pranay",24));
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ResponseEntity<String> validateData(@RequestBody String name){
		boolean b = false;
		for(User t : lt) {
			if(t.getName().equals(name)) {
				b=true;
				break;
			}
		}
		System.out.println(b ? "Valid User" : "Invalid User");
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
