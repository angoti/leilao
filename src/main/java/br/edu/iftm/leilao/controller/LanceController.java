package br.edu.iftm.leilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.service.LanceService;

@RestController
@RequestMapping("/lance")
public class LanceController {
	@Autowired
	private LanceService lanceService;

}
