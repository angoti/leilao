package br.edu.iftm.leilao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	public Participante novo(Participante participante) {
		return participanteRepository.save(participante);
	}
}
