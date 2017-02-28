package com.studyproject.tuberlin.bingoapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studyproject.tuberlin.bingoapp.entity.MainGameChat;
import com.studyproject.tuberlin.bingoapp.repository.MainGameChatRepository;

/**
 * This class is the service class for the MainGameChatRepository
 * @author sudarson
 *
 */
@Service
public class MainGameChatService {
	@Inject
	MainGameChatRepository mainGameChatRepository;
	
	public MainGameChat saveMainGameChat(MainGameChat mainGameChat){
		long millis = System.currentTimeMillis();
		mainGameChat.setTime(millis+"");
		return mainGameChatRepository.save(mainGameChat);
	}
	
	public int deleteMainGameChatData(){
		return mainGameChatRepository.deleteMainGameChatData();
	}
	
	public List<MainGameChat> getDetailsForSpecificGame(String gameId){
		return mainGameChatRepository.getDetailsForSpecificGame(gameId);
	}
}
