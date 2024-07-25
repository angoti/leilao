package br.edu.iftm.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;

@Service
public class ItemdeLeilaoService {
	
	@Autowired
	private ItemDeLeilaoRepository itemDeLeilaoRepository;
	
	public ItemDeLeilao novo(ItemDeLeilao item) {
		return itemDeLeilaoRepository.save(item);
	}

	public ItemDeLeilao buscarPorId(Long id) {
		return itemDeLeilaoRepository.findById(id).get();
	}
	
	public void deletarPorId(Long id) {
		itemDeLeilaoRepository.deleteById(id);
	}
	
	public ItemDeLeilao atualizar(ItemDeLeilao item, Long id) {
		item.setId(id);
		return itemDeLeilaoRepository.save(item);
	}
	
	public List<ItemDeLeilao> buscarTodos() {
		List<ItemDeLeilao> itens = new ArrayList<ItemDeLeilao>();
		itemDeLeilaoRepository.findAll().forEach(item->itens.add(item));
		return itens;
	}
	
}
