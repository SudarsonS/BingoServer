package com.studyproject.tuberlin.bingoapp.helpers;

import java.util.List;

import com.studyproject.tuberlin.bingoapp.entity.GamePlayer;
import com.studyproject.tuberlin.bingoapp.entity.LobbyChat;

public class Lobby {

	private List<GamePlayer> gamePlayer;
	private String gameStatus;
	private List<LobbyChat> lobbyChat;

	public Lobby(){

	}

	public Lobby(List<GamePlayer> gamePlayer, String gameStatus, List<LobbyChat> lobbyChat) {
		super();
		this.gamePlayer = gamePlayer;
		this.gameStatus = gameStatus;
		this.lobbyChat = lobbyChat;
	}

	public List<GamePlayer> getGamePlayer() {
		return gamePlayer;
	}

	public void setGamePlayer(List<GamePlayer> gamePlayer) {
		this.gamePlayer = gamePlayer;
	}

	public String getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	public List<LobbyChat> getLobbyChat() {
		return lobbyChat;
	}

	public void setLobbyChat(List<LobbyChat> lobbyChat) {
		this.lobbyChat = lobbyChat;
	}

	@Override
	public String toString() {
		return "Lobby [gamePlayer=" + gamePlayer + ", gameStatus=" + gameStatus + ", lobbyChat=" + lobbyChat + "]";
	}
}
