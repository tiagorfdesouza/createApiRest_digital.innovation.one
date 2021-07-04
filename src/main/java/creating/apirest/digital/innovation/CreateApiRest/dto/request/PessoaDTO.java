package creating.apirest.digital.innovation.CreateApiRest.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PessoaDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 60)
    private String nome;

    @NotEmpty
    @Size(min = 2, max = 60)
    private String sobreNome;

    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private String birthday;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

}
