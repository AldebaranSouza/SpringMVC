package br.com.casadocodigo.loja.models.conversors;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Timestamp> {

	@Override
  public Timestamp convertToDatabaseColumn(LocalDate locDate) {
  	return (locDate == null ? null : Timestamp.valueOf(locDate.atStartOfDay()));
  }

  @Override
  public LocalDate convertToEntityAttribute(Timestamp timestamp) {
  	return (timestamp == null ? null : timestamp.toLocalDateTime().toLocalDate());
  }
	
//	@Override
//    public Date convertToDatabaseColumn(LocalDate locDate) {
//    	return (locDate == null ? null : Date.valueOf(locDate));
//    }
//
//    @Override
//    public LocalDate convertToEntityAttribute(Date sqlDate) {
//    	return (sqlDate == null ? null : sqlDate.toLocalDate());
//    }

}
