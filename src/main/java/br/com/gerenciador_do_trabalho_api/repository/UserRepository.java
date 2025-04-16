package br.com.gerenciador_do_trabalho_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador_do_trabalho_api.entity.User;

public interface UserRepository extends JpaRepository<Long, User> {

}
