package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public class GameMinDTO {

//DTO=é um padrão de software voltado para a transferência de dados entre 
//as camadas de uma aplicação. Ele consiste 
//basicamente no entendimento de como as informações trafegam dentro de um sistema.
	//costomiza o formato da API
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
		
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection projection) {
		this.id=  projection.getId();
		this.title =  projection.getTitle();
		this.year =  projection.getYear();

		this.imgUrl = projection.getImgUrl();
		this.shortDescription =  projection.getShortDescription();
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
