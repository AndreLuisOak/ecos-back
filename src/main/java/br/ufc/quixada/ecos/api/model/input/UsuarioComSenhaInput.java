package br.ufc.quixada.ecos.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioComSenhaInput extends UsuarioInput {

	@NotBlank
	private String senha;
}
