package com.capgemini.greetingsapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.greetingsapp.model.Greeting;
import com.capgemini.greetingsapp.model.User;
import com.capgemini.greetingsapp.service.IGreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {
	
	@Autowired 
	private IGreetingService greetingService;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	
	@RequestMapping(value = {"query"}, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value= "fName") String fName, @RequestParam(value = "lName") String lName ) {
		return "Hello " + fName + " " + lName + "!";
	}
	@GetMapping("/param/{name}")
	public String sayHelloParam(@PathVariable String name) {
		return "Hello "+name+" !";
	}
	
	@GetMapping(value = { "", "/", "/home" })
	public Greeting greeting(@RequestParam(value = "fName", defaultValue = "World") String fName,
			@RequestParam(value = "lName",defaultValue = "World") String lName) {
		User user = new User();
		user.setFirstName(fName);
		user.setLastName(lName);
		return greetingService.addGreeting(user);
	}
	
	@GetMapping("/get/{gId}")
	public Greeting getMessage(@PathVariable("gId") Long greetingId) {
		return greetingService.getGreetingById(greetingId);
	}
	
	@GetMapping("/getAll")
	public List<Greeting> getAllMessage(){
		return greetingService.getAllGreeting();
	}
	
	@RequestMapping("/update/{gId}")
	public Greeting updateGreeting(@PathVariable("gId") long gId,@RequestBody User user) {
		return greetingService.updateGreeting(gId, user);
	}
	
	@DeleteMapping("/delete/{gId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("gId") Long gId){
		greetingService.deleteMessage(gId);
		return new ResponseEntity<String>("Deleted the message with id : "+gId, HttpStatus.OK);
	}
}
