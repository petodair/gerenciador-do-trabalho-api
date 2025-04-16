package br.com.gerenciador_do_trabalho_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador_do_trabalho_api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByCodeContainingIgnoreCase(String code);
}
