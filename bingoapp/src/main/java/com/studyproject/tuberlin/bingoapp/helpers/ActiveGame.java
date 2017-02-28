package com.studyproject.tuberlin.bingoapp.helpers;

import com.studyproject.tuberlin.bingoapp.entity.Game;

public class ActiveGame {
	private Game game;
	private int numberOfPlayers;
	
	public ActiveGame() {
		super();
	}

	public ActiveGame(Game game, int numberOfPlayers) {
		super();
		this.game = game;
		this.numberOfPlayers = numberOfPlayers;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	@Override
	public String toString() {
		return "ActiveGame [game=" + game + ", numberOfPlayers=" + numberOfPlayers + "]";
	}
}
