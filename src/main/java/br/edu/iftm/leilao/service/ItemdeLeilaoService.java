package br.edu.iftm.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;

public class ItemdeLeilaoService {

	@Autowired
	private ItemDeLeilaoRepository repo;

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public ItemDeLeilao busca(Long id) {
		return repo.findById(id).get();
	}

	public ItemDeLeilao atualiza(Long id, ItemDeLeilao item) {
		item.setId(id);
		return repo.save(item);
	}

	public ItemDeLeilao salva(ItemDeLeilao item) {
		return repo.save(item);
	}

	public List<ItemDeLeilao> itens() {
		List<ItemDeLeilao> lista = new ArrayList<ItemDeLeilao>();
		repo.findAll().forEach(i -> lista.add(i));
		return lista;
	}

}


