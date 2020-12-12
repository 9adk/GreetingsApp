package com.capgemini.greetingsapp.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.greetingsapp.model.Greeting;
import com.capgemini.greetingsapp.model.User;
import com.capgemini.greetingsapp.repository.GreetingsRepository;

@Service
public class GreetingsService implements IGreetingService {
	private static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private GreetingsRepository greetingRepository;

	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}

	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}
	
	@Override
	public List<Greeting> getAllGreeting(){
		return greetingRepository.findAll();
	}
	
	@Override
	public Greeting updateGreeting(long id, User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
		return greetingRepository.save(new Greeting(id, message));
	}

	@Override
	public void deleteMessage(Long gId) {
		greetingRepository.deleteById(gId);
	}
}
