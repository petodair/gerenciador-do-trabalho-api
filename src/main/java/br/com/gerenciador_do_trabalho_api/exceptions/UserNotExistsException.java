package br.com.gerenciador_do_trabalho_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotExistsException extends RuntimeException {
    public UserNotExistsException(String message){
        super(message);
    }
}
