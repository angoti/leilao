package br.edu.iftm.leilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.service.ParticipanteService;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {
	@Autowired
	private ParticipanteService participanteService;

	@PostMapping
	public Participante create(Participante participante) {
		return participanteService.novo(participante);
	}
}
