package br.com.gerenciador_do_trabalho_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador_do_trabalho_api.dto.ApiResponse;
import br.com.gerenciador_do_trabalho_api.dto.user.UserRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.user.UserResponseDTO;
import br.com.gerenciador_do_trabalho_api.service.user.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Void> createUser(@RequestBody UserRegistrationDTO user){
        return this.userService.createUser(user);
    }

    @GetMapping
    public ApiResponse<List<UserResponseDTO>> findAllUsers(){
        return this.userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponseDTO> getUserById(@PathVariable("id")Long id){
        return this.userService.getUserById(id);
    }

}
