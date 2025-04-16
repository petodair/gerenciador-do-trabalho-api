package br.com.gerenciador_do_trabalho_api.dto.user;

import br.com.gerenciador_do_trabalho_api.enums.Authority;

public record UserResponseDTO(
    Long Id,
    String nome,
    Authority authority
) {

}
