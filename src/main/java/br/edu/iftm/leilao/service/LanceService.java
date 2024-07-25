package br.edu.iftm.leilao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.repository.LanceRepository;

@Service
public class LanceService {
	@Autowired
	private LanceRepository lanceRepository;

	public Lance novo(Lance lance) {
		return lanceRepository.save(lance);
	}
}
