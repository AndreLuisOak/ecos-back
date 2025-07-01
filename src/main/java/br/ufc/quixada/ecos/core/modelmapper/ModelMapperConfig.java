package br.ufc.quixada.ecos.core.modelmapper;

import br.ufc.quixada.ecos.api.model.ModeloModel;
import br.ufc.quixada.ecos.domain.model.Modelo;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();

		modelMapper.typeMap(Modelo.class, ModeloModel.class)
			.addMappings(mapper -> mapper.map(Modelo::getUsuario, ModeloModel::setCriador));

		modelMapper.addConverter(converterLocalDateToString());

		return modelMapper;
	}

	private AbstractConverter<LocalDate, String> converterLocalDateToString() {
		return new AbstractConverter<>() {
			@Override
			protected String convert(LocalDate source) {
				return source != null
					? LocalDateTime.of(source, LocalTime.MIN).format(DateTimeFormatter.ISO_DATE_TIME)
					: null;
			}
		};
	}
}

