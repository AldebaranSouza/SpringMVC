package br.com.casadocodigo.loja.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "PRODUTO_PRECOS")
public class Preco {
	private Double preco;
	private TipoPreco tipoPreco;
	
	@Column(name = "PRECO")
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Column(name = "TIPO_PRECO")
	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}
	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}
}
