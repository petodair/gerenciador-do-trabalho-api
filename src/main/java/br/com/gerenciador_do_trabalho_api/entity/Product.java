package br.com.gerenciador_do_trabalho_api.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.gerenciador_do_trabalho_api.enums.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;

    @Column
    private String name;

    @Column(nullable = false)
    private String code;

    /**
     * Fabricação do produto
     */
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturing;

    /**
     * Validade do produto
     */
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validity;

    /**
     * Quantidade do produto
     */
    @Column(nullable = false)
    private double amount;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_produto_id")
    private User user;

}
