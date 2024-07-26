package br.edu.iftm.leilao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "id" })
@EqualsAndHashCode(of = { "participante", "valor" })
@Entity
public class Lance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valor;

	@OneToOne // um lance é feito por um participante
	private Participante participante;

	public Lance(Double valor, Participante participante) {
		super();
		this.valor = valor;
		this.participante = participante;
	}

}
