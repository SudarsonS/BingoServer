package com.studyproject.tuberlin.bingoapp.helpers;

import java.util.List;

import com.studyproject.tuberlin.bingoapp.entity.Game;
import com.studyproject.tuberlin.bingoapp.entity.MainGameChat;

/**
 * This class contains information about Game and GameChats
 * @author sudarson
 *
 */
public class GameInfo {
	private Game game;
	private List<MainGameChat> mainGameChatList;
	
	public GameInfo(){
		super();
	}

	public GameInfo(Game game, List<MainGameChat> mainGameChatList) {
		super();
		this.game = game;
		this.mainGameChatList = mainGameChatList;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<MainGameChat> getMainGameChatList() {
		return mainGameChatList;
	}

	public void setMainGameChatList(List<MainGameChat> mainGameChatList) {
		this.mainGameChatList = mainGameChatList;
	}

	@Override
	public String toString() {
		return "GameInfo [game=" + game + ", mainGameChatList=" + mainGameChatList + "]";
	}
}
