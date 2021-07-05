package creating.apirest.digital.innovation.CreateApiRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CadNotFoundException extends Exception{

    public CadNotFoundException(Long id) { super(String.format("Person with %s not found!", id));}
}
