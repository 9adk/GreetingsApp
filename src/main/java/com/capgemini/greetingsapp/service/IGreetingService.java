package com.capgemini.greetingsapp.service;

import java.util.List;

import com.capgemini.greetingsapp.model.Greeting;
import com.capgemini.greetingsapp.model.User;
public interface IGreetingService {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	List<Greeting> getAllGreeting();
	Greeting updateGreeting(long id, User user);
	void deleteMessage(Long gId);
}
