package creating.apirest.digital.innovation.CreateApiRest.dto.mapper;


import creating.apirest.digital.innovation.CreateApiRest.dto.request.PessoaDTO;
import creating.apirest.digital.innovation.CreateApiRest.entidades.CadastroPessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CadMapper {

    @Mapping(target = "birthday", source = "birthday", dateFormat = "dd-MM-yyyy")
    CadastroPessoa toModel(PessoaDTO dto);
    PessoaDTO toDTO(CadastroPessoa dto);
}
