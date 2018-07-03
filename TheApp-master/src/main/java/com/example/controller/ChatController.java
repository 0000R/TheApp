package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Chat;
import com.example.models.ChatRepository;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins="http://localhost:4200")
public class ChatController {
	
	@Autowired
	ChatRepository chatRepository;
	
	@GetMapping()
	public List<Chat> getChat(){
		return chatRepository.findAll();
	}

	@PostMapping()
	public void createChat(@RequestBody Chat chat) {
		chatRepository.save(chat);
	}
	
	@PostMapping("/multiple")
	public void createChat(@RequestBody List<Chat> chat) {
		chatRepository.saveAll(chat);
	}
	


	

}

