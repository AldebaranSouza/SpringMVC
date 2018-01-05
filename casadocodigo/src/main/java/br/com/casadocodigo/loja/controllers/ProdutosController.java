package br.com.casadocodigo.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private FileSaver fileSaver;
	
//	@InitBinder
//	public void initBinder (WebDataBinder dataBinder){
//		dataBinder.addValidators(new ProdutoValidation());
//	}
	
	@Autowired
	ProdutoDAO produtoDAO;
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public ModelAndView form(Produto produto){
		ModelAndView view = new ModelAndView("produtos/form");
		view.addObject("tipos", TipoPreco.values());
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView cadastrar(MultipartFile file, @Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		System.out.println(file.getOriginalFilename());
		
		if (bindingResult.hasErrors()) {
			return form(produto);
		}
		
		if (!file.getOriginalFilename().isEmpty()) {
			String arquivo = this.fileSaver.writeFile("arquivos", file);
			produto.setCaminhoSumario(arquivo);
		}
		
		this.produtoDAO.gravar(produto);
		redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso!!");

		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView view = new ModelAndView("produtos/lista");
		view.addObject("produtos", this.produtoDAO.findAll());
		return view;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("produtos/detalhe");
		Produto produto = this.produtoDAO.findOne(id);
		view.addObject("produto", produto);
		return view;
	}
	
	
}
