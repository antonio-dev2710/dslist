package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	//camada resposavel por criar a logica de negocio
	//busca no banco de dados
	//ingetando uma instancia do repository no servico
	@Autowired
	GameRepository gameRepository;
	//service retorna DTO
	//criar uma lista equivalente tranformando td que game em gameMinDTO
	public List<GameMinDTO> findAll(){
		var result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x-> new GameMinDTO(x)).toList();
		
		return dto;
	}
	
	
	

}
