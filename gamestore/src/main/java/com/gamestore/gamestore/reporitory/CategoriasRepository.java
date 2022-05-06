package com.gamestore.gamestore.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.gamestore.gamestore.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	public List<Categorias> findAllByCategoriaGamesContainingIgnoreCase (@Param("categoriaGames")String categoriaGames);

}
 
