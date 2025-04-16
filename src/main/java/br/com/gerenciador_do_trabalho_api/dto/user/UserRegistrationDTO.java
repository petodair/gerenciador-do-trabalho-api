package br.com.gerenciador_do_trabalho_api.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRegistrationDTO(
    @NotNull(message = "O nome de usuário não deve ser nulo")
    @NotBlank(message = "O nome de usuário não deve estar vazio")
    @Size(min = 1, max = 50, message = "O nome de usuário deve conter entre 1 e 50 caracteres")
    String username,

    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha não pode estar vazia")
    @Size(min = 4, message = "A senha deve ter ao menos 4 caracteres")
    String password
) {

}
