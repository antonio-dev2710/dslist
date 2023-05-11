package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

	// camada resposavel por criar a logica de negocio
	// busca no banco de dados
	// ingetando uma instancia do repository no servico
	@Autowired
	GameRepository gameRepository;

	// garante que os metodos fiquem transacionais esse argumento asegura que n ta
	// fznd
	// nenhuma operacao de escrita bloqueando o meu banco de dados
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}

	// service retorna DTO
	// criar uma lista equivalente tranformando td que game em gameMinDTO
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		var result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

		return dto;
	}
	
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

		return dto;
	}


}
