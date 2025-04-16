package br.com.gerenciador_do_trabalho_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.gerenciador_do_trabalho_api.dto.user.UserRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.user.UserResponseDTO;
import br.com.gerenciador_do_trabalho_api.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "ID", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "authority", ignore = true)
    User toUser(UserRegistrationDTO userRegistrationDTO);

    UserResponseDTO toUserResponseDTO(User user);

}
