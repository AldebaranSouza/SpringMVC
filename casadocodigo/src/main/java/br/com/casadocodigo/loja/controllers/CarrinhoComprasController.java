package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private CarrinhoCompras carrinho;

	@RequestMapping("/add")
	public ModelAndView add(Long idProduto, TipoPreco tipoPreco){
		ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
		CarrinhoItem carrinhoItem = criaItem(idProduto, tipoPreco);
		this.carrinho.add(carrinhoItem);
		return modelAndView;
	}
	
	private CarrinhoItem criaItem(Long idProduto, TipoPreco tipoPreco){
		Produto produto = this.produtoDAO.findOne(idProduto);
		CarrinhoItem item = new CarrinhoItem(produto, tipoPreco);
		return item;
	}
}
