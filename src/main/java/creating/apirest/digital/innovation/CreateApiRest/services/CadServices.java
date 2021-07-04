package creating.apirest.digital.innovation.CreateApiRest.services;


import creating.apirest.digital.innovation.CreateApiRest.dto.mapper.CadMapper;
import creating.apirest.digital.innovation.CreateApiRest.dto.request.PessoaDTO;
import creating.apirest.digital.innovation.CreateApiRest.dto.response.MessageResponseDTO;
import creating.apirest.digital.innovation.CreateApiRest.entidades.CadastroPessoa;
import creating.apirest.digital.innovation.CreateApiRest.excepition.CadNotFoundException;
import creating.apirest.digital.innovation.CreateApiRest.repository.CadRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CadServices {

    private final CadRepository cadRepository;

    private final CadMapper cadMapper;

    private MessageResponseDTO createMessageResponse(String s, Long id2){
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }

    public MessageResponseDTO create(PessoaDTO pessoaDTO) {
        CadastroPessoa cadastroPessoa = cadMapper.toModel(pessoaDTO);
        CadastroPessoa savedCadastro = cadRepository.save(cadastroPessoa);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfuly with ID", savedCadastro.getId());
        return messageResponse;
    }

    public PessoaDTO findById(Long id) throws CadNotFoundException {
        CadastroPessoa cadastroPessoa = cadRepository.findById(id)
                .orElseThrow(() -> new CadNotFoundException(id));
        return cadMapper.toDTO(cadastroPessoa);
    }

    public List<PessoaDTO> listAll() {
        List<CadastroPessoa> cadastroPessoas = cadRepository.findAll();
        return cadastroPessoas.stream()
                .map(cadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PessoaDTO pessoaDTO) throws  CadNotFoundException {
        cadRepository.findById(id)
                .orElseThrow(() -> new CadNotFoundException(id));
        CadastroPessoa updatePessoa = cadMapper.toModel(pessoaDTO);
        CadastroPessoa savedCadastro = cadRepository.save(updatePessoa);

        MessageResponseDTO messageResponse = createMessageResponse("Cadastro atualizado com sucesso", savedCadastro.getId());

        return messageResponse;
    }

    public void delete(Long id) throws CadNotFoundException{
        cadRepository.findById(id)
                .orElseThrow(() -> new CadNotFoundException(id));
        cadRepository.deleteById(id);
    }

}
