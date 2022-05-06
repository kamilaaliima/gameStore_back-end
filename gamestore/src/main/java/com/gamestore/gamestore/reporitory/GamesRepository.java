package com.gamestore.gamestore.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.gamestore.gamestore.model.Games;

public interface GamesRepository extends JpaRepository<Games, Long> {
	public List<Games> findAllByNomeContainingIgnoreCase (@Param("nome")String nome);
	
	

}
