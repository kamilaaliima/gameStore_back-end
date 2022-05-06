package com.gamestore.gamestore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamestore.gamestore.model.Games;
import com.gamestore.gamestore.reporitory.CategoriasRepository;
import com.gamestore.gamestore.reporitory.GamesRepository;

@RestController
@RequestMapping("/games")
@CrossOrigin("*")
public class GamesController {
	
	@Autowired
	private GamesRepository repository;
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping
	public ResponseEntity<List<Games>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Games> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")	
	public ResponseEntity<List<Games>> getByName (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		
	}
	
	
	@PostMapping
	public ResponseEntity<Games> post(@Valid @RequestBody Games games) {
		if (categoriasRepository.existsById(games.getCategorias().getId()))
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(games));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

				
	@PutMapping
	public ResponseEntity<Games> put(@Valid @RequestBody Games games) {
		if (categoriasRepository.existsById(games.getId())) {
			if (categoriasRepository.existsById(games.getCategorias().getId()))
				return ResponseEntity.status(HttpStatus.OK).body(repository.save(games));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
