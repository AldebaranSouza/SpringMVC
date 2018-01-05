package br.com.casadocodigo.loja.models.conversors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author Aldebaran
 * 
 *         Classe reponsavel por fazer o parse de um campo Strinh para
 *         LocalDate, pega o dado do formulario e seta no Objeto.
 *
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

	private final DateTimeFormatter formatter;

	public StringToLocalDateConverter(String dateFormat) {
		this.formatter = DateTimeFormatter.ofPattern(dateFormat);
	}

	@Override
	public LocalDate convert(String source) {
		if (source == null || source.isEmpty()) {
			return null;
		}
		
		return LocalDate.parse(source, formatter);
	}
}