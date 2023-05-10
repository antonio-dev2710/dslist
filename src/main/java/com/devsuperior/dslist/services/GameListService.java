package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	// camada resposavel por criar a logica de negocio
	// busca no banco de dados
	// ingetando uma instancia do repository no servico
	@Autowired
	GameListRepository gameListRepository;


	// service retorna DTO
	// criar uma lista equivalente tranformando td que game em gameMinDTO
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		var result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();

		return dto;
	}

}
