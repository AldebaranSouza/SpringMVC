package br.com.casadocodigo.loja.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Aldebaran
 *
 */
@Entity
@Table(name = "PRODUTO")
public class Produto {
	private Long id;
	@NotEmpty(message = "Campo obrigatório")
	private String titulo;
	@NotEmpty(message = "Campo obrigatório")
	private String descricao;
	@NotNull(message = "Campo paginas é obrigatório")
	private Integer paginas;
	private List<Preco> precos;
	private LocalDate dataLancamento;
	private String caminhoSumario;

	@Id
	@Column(name = "ID_PRODUTO", unique = true, nullable = false, precision = 10, scale = 0)
	@SequenceGenerator(name = "SEQUENCE_PRODUTO", sequenceName = "SQ_PRODUTO")
	@GeneratedValue(generator = "SEQUENCE_PRODUTO")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "TITULO", length = 50)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "DESCRICAO", length = 500)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "PAGINAS", precision = 6, scale = 0)
	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	
	@ElementCollection
	//@JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

	@Column(name = "DATA_LANCAMENTO")
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	@Column(name = "CAMINHO_SUMARIO")
	public String getCaminhoSumario() {
		return caminhoSumario;
	}

	public void setCaminhoSumario(String caminhoSumario) {
		this.caminhoSumario = caminhoSumario;
	}

	@Override
	public String toString() {
		return "Produto [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
