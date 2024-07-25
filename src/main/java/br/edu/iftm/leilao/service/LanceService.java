package br.edu.iftm.leilao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.repository.LanceRepository;

@Service
public class LanceService {
	@Autowired
	private LanceRepository lanceRepository;

	@Autowired
	private ParticipanteService participanteService;

	public Lance novo(Lance lance) {
		return lanceRepository.save(lance);
	}

	public Lance save(Lance lance) {
		System.out.println("--------------------------------");
		System.out.println(lance);
		Participante participante = participanteService.buscarPorId(lance.getParticipante().getId());
		lance.setParticipante(participante);
		System.out.println(lance);
		return lanceRepository.save(lance);
	}
}
