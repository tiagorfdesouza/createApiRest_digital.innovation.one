package creating.apirest.digital.innovation.CreateApiRest.controller;


import creating.apirest.digital.innovation.CreateApiRest.dto.request.PessoaDTO;
import creating.apirest.digital.innovation.CreateApiRest.dto.response.MessageResponseDTO;
import creating.apirest.digital.innovation.CreateApiRest.excepition.CadNotFoundException;
import creating.apirest.digital.innovation.CreateApiRest.services.CadServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/default/register")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CadController {

    private final CadServices cadServices;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return  cadServices.create(pessoaDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaDTO findyById(@PathVariable Long id) throws CadNotFoundException {
        return cadServices.findById(id);
    }

    @GetMapping
    public List<PessoaDTO> listAll() { return  cadServices.listAll();}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws CadNotFoundException {
        return cadServices.update(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws CadNotFoundException{
        cadServices.delete(id);
    }

}
