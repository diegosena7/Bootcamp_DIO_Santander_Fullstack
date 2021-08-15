package one.digitalinnovation.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe responsável por criar a exceção usada para informar o usuário quando não
 * localizar o objeto pelo id informado.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(Long id) {
        super("Person not found with ID " + id);
    }
}
