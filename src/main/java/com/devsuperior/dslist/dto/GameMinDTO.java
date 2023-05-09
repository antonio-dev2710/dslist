package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

public class GameMinDTO {

//DTO=é um padrão de software voltado para a transferência de dados entre 
//as camadas de uma aplicação. Ele consiste 
//basicamente no entendimento de como as informações trafegam dentro de um sistema.
	private Long id;
	private String title;
	private Integer year;
	private String genre;
	private String imgUrl;
	private String shortDescription;
	public GameMinDTO() {
		super();
	}
	
	//CONTRTUTOR DA ENTIDADE GERANDO A PARTIR DOS DADOS DO GAME
	public GameMinDTO(Game entity) {
		this.id= entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.genre =entity.getGenre() ;
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	

}
