package br.com.casadocodigo.loja.models.conversors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author Aldebaran
 * 
 *         Classe reponsavel por fazer o parse de um campo LocalDate para
 *         String, devolve para o formulário no padrão esperado.
 *
 */
public class LocalDateToStringConverter implements Converter<LocalDate, String> {

	private final DateTimeFormatter formatter;

	public LocalDateToStringConverter(String dateFormat) {
		this.formatter = DateTimeFormatter.ofPattern(dateFormat);
	}

	@Override
	public String convert(LocalDate source) {
		if (source == null) {
			return null;
		}

		return formatter.format(source);
	}
}