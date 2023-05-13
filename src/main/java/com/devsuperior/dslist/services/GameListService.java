package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	// camada resposavel por criar a logica de negocio
	// busca no banco de dados
	// ingetando uma instancia do repository no servico
	@Autowired
	GameListRepository gameListRepository;

	@Autowired
	GameRepository gameRepository;

	// service retorna DTO
	// criar uma lista equivalente tranformando td que game em gameMinDTO
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		var result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();

		return dto;
	}
	@Transactional(readOnly = true)
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		// pesquisar os games da lsita, trouce pra nenoria do list os games
		List<GameMinProjection> list = gameRepository.searchByList(listId);

		// trocar os games de posição
		GameMinProjection obj = list.remove(sourceIndex);

		// inserir um obj na posicao na lista
		list.add(destinationIndex, obj);

		// pegar a faixa de origem e dentino
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex ;
		
		for(int i = min; i<=max; i++) {				//lista 2     posicao 9    é a posicao 1
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}

}
