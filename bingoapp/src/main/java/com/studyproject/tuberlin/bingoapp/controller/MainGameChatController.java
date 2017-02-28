package com.studyproject.tuberlin.bingoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.studyproject.tuberlin.bingoapp.entity.MainGameChat;
import com.studyproject.tuberlin.bingoapp.service.MainGameChatService;

/**
 * This class is a controller for MainGameChat entity (Table)
 * @author sudarson
 *
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainGameChatController {
	
	MainGameChatService mainGameChatService;
	
	@Autowired
	public MainGameChatController(MainGameChatService mainGameChatService) {
		this.mainGameChatService = mainGameChatService;
	}
	
	@RequestMapping(value = "/bingodb/maingame_chat/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<MainGameChat> gameCreation(@RequestBody MainGameChat mainGameChat){
		  MainGameChat p = mainGameChatService.saveMainGameChat(mainGameChat);
		  return new ResponseEntity<MainGameChat> (p, HttpStatus.OK);
	}
}
