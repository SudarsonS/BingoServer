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

import com.studyproject.tuberlin.bingoapp.entity.LobbyChat;
import com.studyproject.tuberlin.bingoapp.service.LobbyChatService;

/**
 * This class is a controller for LobbyChat entity (Table)
 * @author sudarson
 *
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LobbyChatController {

	LobbyChatService lobbyChatService;
	
	@Autowired
	public LobbyChatController(LobbyChatService lobbyChatService) {
		this.lobbyChatService = lobbyChatService;
	}
	
	@RequestMapping(value = "/bingodb/lobby_chat/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<LobbyChat> gameCreation(@RequestBody LobbyChat lobbyChat){
		  LobbyChat p = lobbyChatService.saveLobbyChat(lobbyChat);
		  return new ResponseEntity<LobbyChat> (p, HttpStatus.OK);
	}
}
