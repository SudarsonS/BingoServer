package com.studyproject.tuberlin.bingoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studyproject.tuberlin.bingoapp.entity.MainGameChat;

@Repository
public interface MainGameChatRepository extends CrudRepository<MainGameChat, Long>{

	@Modifying
	@Transactional
	@Query("Delete from main_game_chat")
	public int deleteMainGameChatData();
	
	@Query("select mc from main_game_chat mc where mc.gameId = :gameId ")
	List<MainGameChat> getDetailsForSpecificGame(@Param("gameId") String gameId);
}
