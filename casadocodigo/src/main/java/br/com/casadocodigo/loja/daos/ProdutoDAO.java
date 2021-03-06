package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

@Repository
@Transactional
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void gravar(Produto produto){
		this.entityManager.persist(produto);
	}
	
	public List<Produto> findAll(){
		return this.entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
	}
	
	public Produto findOne(Long id) {
		//return this.entityManager.find(Produto.class, id);
		return this.entityManager.createQuery("select p from Produto p join fetch p.precos where p.id = :id", Produto.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
