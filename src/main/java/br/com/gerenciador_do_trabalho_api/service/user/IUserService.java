package br.com.gerenciador_do_trabalho_api.service.user;

import br.com.gerenciador_do_trabalho_api.dto.ApiResponse;
import br.com.gerenciador_do_trabalho_api.dto.user.UserRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.user.UserResponseDTO;
import br.com.gerenciador_do_trabalho_api.entity.User;

public interface IUserService {

    public ApiResponse<Void> createUser(UserRegistrationDTO user);
    public ApiResponse<UserResponseDTO> getUser(User user);
}
