package com.studyproject.tuberlin.bingoapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.studyproject.tuberlin.bingoapp.entity.Game;
import com.studyproject.tuberlin.bingoapp.entity.GamePlayer;
import com.studyproject.tuberlin.bingoapp.entity.MainGameChat;
import com.studyproject.tuberlin.bingoapp.helpers.ActiveGame;
import com.studyproject.tuberlin.bingoapp.helpers.DatabaseStatus;
import com.studyproject.tuberlin.bingoapp.helpers.GameInfo;
import com.studyproject.tuberlin.bingoapp.service.GamePlayerService;
import com.studyproject.tuberlin.bingoapp.service.GameService;
import com.studyproject.tuberlin.bingoapp.service.MainGameChatService;

/**
 * This class is a controller for Game entity (Table)
 * @author sudarson
 *
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameController {

	GameService gameService;
	MainGameChatService mainGameChatService;
	GamePlayerService gamePlayerService;
	
	@Autowired
	   public GameController(GameService gameService, MainGameChatService mainGameChatService, GamePlayerService gamePlayerService) {
			this.gameService = gameService;
			this.mainGameChatService = mainGameChatService;
			this.gamePlayerService = gamePlayerService;
		}
	
	/*@RequestMapping(value = "/bingodb/dummy2/")
	public ResponseEntity<Game> get() {

	    Game game = new Game();
	    game.setCreatorId("12345");
	    return new ResponseEntity<Game>(game, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/bingodb/game/creation/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Game> gameCreation(@RequestBody Game game){
		  Game p = gameService.registerPlayer(game);
		  return new ResponseEntity<Game> (p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bingodb/gamelist_to_join/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<ActiveGame>> getInActiveGames(){
		  List<Game> g = gameService.getInActiveGames();
		  List<ActiveGame> activeGameList = new ArrayList<ActiveGame>();
		  ActiveGame activeGame = null;
		  for(Game game: g){
			 List<GamePlayer> gamePlayer = gamePlayerService.getPlayersInSpecificGame(game.getGameId());
			 activeGame = new ActiveGame();
			 if(gamePlayer != null){
				 activeGame.setGame(game);
				 activeGame.setNumberOfPlayers(gamePlayer.size());
			 }
			 activeGameList.add(activeGame);
		  }
		  return new ResponseEntity<List<ActiveGame>> (activeGameList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bingodb/game_status_to_active/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<DatabaseStatus> setGameStatusToActive(@RequestBody Game game){
		String gameId = game.getGameId();
		int result = gameService.updateStatusActive(gameId);
		DatabaseStatus status = new DatabaseStatus();
		if(result == 1){
			status.setMessage("Success");
		}else{
			status.setMessage("Error");
		}
		return new ResponseEntity<DatabaseStatus> (status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bingodb/saybingo/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Game> sayBingo(@RequestBody Game game){
		  String ifBingo = game.getIfBingo();
		  String gameId = game.getGameId();
		  String winner = game.getWinner();
		  Game storedGame = gameService.findGame(gameId);
		  String storedWinner = storedGame.getWinner();
		  if(storedWinner == null || storedWinner.length() == 0 || storedGame.getIfBingo().equalsIgnoreCase("false")){
			  gameService.updateForSayBingo(gameId, ifBingo, winner);
			  gameService.updateStatusCompleted(gameId);
		  }
		  Game p = gameService.findGame(gameId);
		  return new ResponseEntity<Game> (p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bingodb/ifbingo/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<GameInfo> ifBingo(@RequestBody Game game){
		  String newLongestMatch = game.getLongestMatch();
		  String gameId = game.getGameId();
		  Game p = gameService.findGame(gameId);
		  List<MainGameChat> mainGameChatList = mainGameChatService.getDetailsForSpecificGame(gameId);
		  GameInfo gameInfo = new GameInfo();
		  String oldLongestMatch = p.getLongestMatch();
		  boolean result = gameService.checkNewValueIsLongestMatch(newLongestMatch, oldLongestMatch);
		  if(result){
			  gameService.updateLongestMatch(gameId, newLongestMatch);
		  }
		  p = gameService.findGame(gameId);
		  gameInfo.setGame(p);
		  gameInfo.setMainGameChatList(mainGameChatList);
		  System.out.println("GameInfo >>>>>"+gameInfo);
		  return new ResponseEntity<GameInfo> (gameInfo, HttpStatus.OK);
	}
	
}
