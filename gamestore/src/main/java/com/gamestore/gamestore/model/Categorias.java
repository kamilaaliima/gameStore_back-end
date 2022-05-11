package com.gamestore.gamestore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gamestore.gamestore.controller.UsuarioController;

	@Entity
	@Table(name = "tb_categorias")
	public class Categorias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3, max = 255)
	private String categoriaGames;
	
	@OneToMany(mappedBy = "categorias", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categorias")
	private List<Games> produtos;
	
	@ManyToOne
	@JsonIgnoreProperties("categorias")
	private Games games;

	
	@ManyToOne
	@JsonIgnoreProperties("categorias")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoriaGames() {
		return categoriaGames;
	}

	public void setCategoriaGames(String categoriaGames) {
		this.categoriaGames = categoriaGames;
	}

	public List<Games> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Games> produtos) {
		this.produtos = produtos;
	}

	public Games getGames() {
		return games;
	}

	public void setGames(Games games) {
		this.games = games;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	
	

}
