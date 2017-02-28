package com.studyproject.tuberlin.bingoapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studyproject.tuberlin.bingoapp.entity.LobbyChat;
import com.studyproject.tuberlin.bingoapp.repository.LobbyChatRepository;

/**
 * This class is the service class for the LobbyChatRepository
 * @author sudarson
 *
 */
@Service
public class LobbyChatService {
	@Inject
    LobbyChatRepository lobbyChatRepository;
	
	public LobbyChat saveLobbyChat(LobbyChat lobbyChat){
		long millis = System.currentTimeMillis();
		lobbyChat.setTime(millis+"");
		return lobbyChatRepository.save(lobbyChat);
	}
	
	public int deleteLobbyChatData(){
		return lobbyChatRepository.deleteLobbyChatData();
	}
	
	public List<LobbyChat> getDetailsForSpecificGame(String gameId){
		return lobbyChatRepository.getDetailsForSpecificGame(gameId);
	}
}
