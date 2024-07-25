package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.service.ItemdeLeilaoService;

@RestController
@RequestMapping("/itemdeleilao")
public class ItemLeilaoController {

	@Autowired
	private ItemdeLeilaoService itemdeLeilaoService;

	@PostMapping
	public ItemDeLeilao create(@RequestBody ItemDeLeilao item) {
		return itemdeLeilaoService.novo(item);
	}

	@GetMapping
	public List<ItemDeLeilao> read() {
		return itemdeLeilaoService.buscarTodos();
	}
	

}
