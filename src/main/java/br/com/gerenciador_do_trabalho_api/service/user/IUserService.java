package br.com.gerenciador_do_trabalho_api.service.user;

import java.util.List;

import br.com.gerenciador_do_trabalho_api.dto.ApiResponse;
import br.com.gerenciador_do_trabalho_api.dto.user.UserRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.user.UserResponseDTO;

public interface IUserService {

    public ApiResponse<Void> createUser(UserRegistrationDTO user);
    public ApiResponse<UserResponseDTO> getUserById(Long id);
    public ApiResponse<List<UserResponseDTO>> findAllUsers();
}
