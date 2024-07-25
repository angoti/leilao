package br.edu.iftm.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;

@Service
public class ItemdeLeilaoService {

	@Autowired
	private ItemDeLeilaoRepository itemDeLeilaoRepository;

	@Autowired
	private ParticipanteService participanteService;

	@Autowired
	private LanceService lanceService;

	public ItemDeLeilao novo(ItemDeLeilao item) {
		return itemDeLeilaoRepository.save(item);
	}

	public ItemDeLeilao buscarPorId(Long id) {
		return itemDeLeilaoRepository.findById(id).get();
	}

	public void deletarPorId(Long id) {
		itemDeLeilaoRepository.deleteById(id);
	}

	public ItemDeLeilao atualiza(ItemDeLeilao item, Long id) {
		item.setId(id);
		return itemDeLeilaoRepository.save(item);
	}

	public List<ItemDeLeilao> buscarTodos() {
		List<ItemDeLeilao> itens = new ArrayList<ItemDeLeilao>();
		itemDeLeilaoRepository.findAll().forEach(item -> itens.add(item));
		return itens;
	}

	public Lance registraLance(Lance lance, Long id) {
		System.out.println("Lance: " + lance);
		System.out.println("ID: " + id);
		ItemDeLeilao item = itemDeLeilaoRepository.findById(id).get();
		if (item.isLeilaoAberto()) {
			Lance lancePersistido = new Lance(lance.getValor(),
					participanteService.buscarPorId(lance.getParticipante().getId()));
			System.out.println("Lance Persistido: " + lancePersistido);
			item.adicionarLance(lancePersistido);
			lanceService.save(lancePersistido);
			if (item.getLanceVencedor() == null) {
				item.setLanceVencedor(lancePersistido);
			} else {
				if (lancePersistido.getValor() > item.getLanceVencedor().getValor()) {
					item.setLanceVencedor(lancePersistido);
				}
			}
			itemDeLeilaoRepository.save(item);
			return lancePersistido;
		}
		return null;
	}

	public Lance atualiza(Long id) {
		ItemDeLeilao item = itemDeLeilaoRepository.findById(id).get();
		if (item.isLeilaoAberto()) {
			Lance lance = item.getLanceVencedor();
			item.setLeilaoAberto(false);
			itemDeLeilaoRepository.save(item);
			return lance;
		}
		return null;
	}

}
