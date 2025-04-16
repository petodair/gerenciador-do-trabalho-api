package br.com.gerenciador_do_trabalho_api.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.gerenciador_do_trabalho_api.dto.ApiResponse;
import br.com.gerenciador_do_trabalho_api.dto.user.UserRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.user.UserResponseDTO;
import br.com.gerenciador_do_trabalho_api.entity.User;
import br.com.gerenciador_do_trabalho_api.exceptions.UserNotExistsException;
import br.com.gerenciador_do_trabalho_api.exceptions.UsernameAlreadyExistsException;
import br.com.gerenciador_do_trabalho_api.mapper.UserMapper;
import br.com.gerenciador_do_trabalho_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public ApiResponse<Void> createUser(UserRegistrationDTO user) {
        if(this.userRepository.findByUsername(user.username()) != null){
            throw new UsernameAlreadyExistsException("Esse nome de usuário já está em uso");
        }

        this.userRepository.save(mapper.toUser(user));

        return new ApiResponse<Void>(
            ApiResponse.ResponseStatusType.SUCCESS, 
            HttpStatus.CREATED,
             null,
             "Usuário criado com sucesso");
    }

    @Override
    public ApiResponse<UserResponseDTO> getUserById(Long id) {
       
        User user = this.userRepository.getReferenceById(id);

        if(user != null){
            throw new UserNotExistsException("Usuário não encontrado");
        }

        return new ApiResponse<UserResponseDTO>(
            ApiResponse.ResponseStatusType.SUCCESS,
            HttpStatus.OK,
            mapper.toUserResponseDTO(user),
            "Usuário retornado com sucesso");
    }

    @Override
    public ApiResponse<List<UserResponseDTO>> findAllUsers() {
        /**
         * Mapeando a lista de usuarios
         */
        List<UserResponseDTO> users = this.userRepository.findAll().stream().map(mapper::toUserResponseDTO)
        .collect(Collectors.toList());

        return new ApiResponse<List<UserResponseDTO>>(
            ApiResponse.ResponseStatusType.SUCCESS,
             HttpStatus.OK,
             users,
              "Usuários do sistema retornados com sucesso!");

    }

}
