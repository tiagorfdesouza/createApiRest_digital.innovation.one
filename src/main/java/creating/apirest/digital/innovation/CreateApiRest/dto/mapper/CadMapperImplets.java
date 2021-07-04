package creating.apirest.digital.innovation.CreateApiRest.dto.mapper;


import creating.apirest.digital.innovation.CreateApiRest.dto.request.PessoaDTO;
import creating.apirest.digital.innovation.CreateApiRest.dto.request.PhoneDTO;
import creating.apirest.digital.innovation.CreateApiRest.entidades.CadastroPessoa;
import creating.apirest.digital.innovation.CreateApiRest.entidades.CadastroPhones;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-06-30T21:41:46-0300",
        comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class CadMapperImplets implements CadMapper {

    @Override
    public CadastroPessoa toModel(PessoaDTO dto) {
        if (dto == null) {
            return null;
        }

        CadastroPessoa cadastroPessoa = new CadastroPessoa();

        if (dto.getBirthday() != null) {
            cadastroPessoa.setBirthday(LocalDate.parse(dto.getBirthday(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

        cadastroPessoa.setId(dto.getId());
        cadastroPessoa.setNome(dto.getNome());
        cadastroPessoa.setSobreNome(dto.getSobreNome());
        cadastroPessoa.setCpf(dto.getCpf());
        cadastroPessoa.setPhone(phoneDTOListToPhoneList(dto.getPhones()));

        return cadastroPessoa;
    }

    @Override
    public PessoaDTO toDTO(CadastroPessoa dto) {
        if (dto == null) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId(dto.getId());
        pessoaDTO.setNome(dto.getNome());
        pessoaDTO.setSobreNome(dto.getSobreNome());
        pessoaDTO.setCpf(dto.getCpf());
        if (dto.getBirthday() != null) {
            pessoaDTO.setBirthday(DateTimeFormatter.ISO_LOCAL_DATE.format(dto.getBirthday()));
        }
        pessoaDTO.setPhones(phoneListToPhoneDTOList(dto.getPhone()));

        return pessoaDTO;
    }

    protected CadastroPhones phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        CadastroPhones cadastroPhones = new CadastroPhones();

        cadastroPhones.setId( phoneDTO.getId() );
        cadastroPhones.setType( phoneDTO.getType() );
        cadastroPhones.setNumber( phoneDTO.getNumber() );

        return cadastroPhones;
    }

    protected List<CadastroPhones> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CadastroPhones> list1 = new ArrayList<CadastroPhones>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(CadastroPhones cadastroPhones) {
        if ( cadastroPhones == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( cadastroPhones.getId() );
        phoneDTO.setType( cadastroPhones.getType() );
        phoneDTO.setNumber( cadastroPhones.getNumber() );

        return phoneDTO;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<CadastroPhones> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( CadastroPhones cadastroPhones : list ) {
            list1.add( phoneToPhoneDTO( cadastroPhones ) );
        }

        return list1;
    }
}