package com.studyproject.tuberlin.bingoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studyproject.tuberlin.bingoapp.entity.LobbyChat;

@Repository
public interface LobbyChatRepository extends CrudRepository<LobbyChat, Long>{

	@Modifying
	@Transactional
	@Query("Delete from lobby_chat")
	public int deleteLobbyChatData();
	
	@Query("select lc from lobby_chat lc where lc.gameId = :gameId ")
	List<LobbyChat> getDetailsForSpecificGame(@Param("gameId") String gameId);
}
