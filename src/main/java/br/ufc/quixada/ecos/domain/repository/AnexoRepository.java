package br.ufc.quixada.ecos.domain.repository;

import br.ufc.quixada.ecos.domain.model.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {
	Optional<Anexo> findByCodigo(UUID codigo);
}
