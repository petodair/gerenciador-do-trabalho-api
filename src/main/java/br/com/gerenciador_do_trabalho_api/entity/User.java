package br.com.gerenciador_do_trabalho_api.entity;

import java.util.List;

import br.com.gerenciador_do_trabalho_api.enums.Authority;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
@Entity
@Table(name = "user")
public class User {

    /**
     * Identificado único do usuário
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long ID;

    /**
     * Nome do usuário, não pode ser nulo e possui um limite máximo de 50
     * caracteres.
     */
    @Column(unique = true, nullable = false, length = 50)
    private String username;

    /**
     * Senha do usuário, não pode ser nula e tem um limite de 20 caracteres.
     */
    @Column(nullable = false, length = 20)
    private String password;

    /**
     * Lista de produtos adicionados pelo usuário.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    /**
     * Autoridade do usuário no sistema
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

}
