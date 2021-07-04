package creating.apirest.digital.innovation.CreateApiRest.repository;

import creating.apirest.digital.innovation.CreateApiRest.entidades.CadastroPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadRepository extends JpaRepository<CadastroPessoa, Long> {
}
