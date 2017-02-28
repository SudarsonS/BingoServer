package com.studyproject.tuberlin.bingoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO Class for Lobby Chat Table
 * This class stores the Chat information in lobby
 * @author sudarson
 *
 */

@Entity(name = "lobby_chat")
@Table(name = "lobby_chat")
public class LobbyChat {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "gameid")
	private String gameId;
	
	@Column(name = "playerid")
	private String playerId;
	
	@Column(name = "player_name")
	private String playerName;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "time")
	private String time;

	public LobbyChat(Long id, String gameId, String playerId, String playerName, String message, String time) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.playerId = playerId;
		this.playerName = playerName;
		this.message = message;
		this.time = time;
	}

	public LobbyChat() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "LobbyChat [id=" + id + ", gameId=" + gameId + ", playerId=" + playerId + ", playerName=" + playerName
				+ ", message=" + message + ", time=" + time + "]";
	}
}
