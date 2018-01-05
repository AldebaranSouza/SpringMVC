package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoValidation implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Produto.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "paginas", "field.required");
//		Produto produto = (Produto) target;
//        if(produto.getPaginas() <= 0){
//            errors.rejectValue("paginas", "field.required");
//        }
	}
}