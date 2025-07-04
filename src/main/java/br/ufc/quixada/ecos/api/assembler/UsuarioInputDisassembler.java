package br.ufc.quixada.ecos.api.assembler;

import br.ufc.quixada.ecos.api.model.input.UsuarioInput;
import br.ufc.quixada.ecos.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Usuario toDomainObject(UsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}
	
	public void copyToDomainObject(UsuarioInput usuarioInput, Usuario usuario) {
		
		modelMapper.map(usuarioInput, usuario);
	}
}
