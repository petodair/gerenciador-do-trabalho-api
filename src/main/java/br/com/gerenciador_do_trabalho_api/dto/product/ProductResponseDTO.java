package br.com.gerenciador_do_trabalho_api.dto.product;

import java.util.Date;

import br.com.gerenciador_do_trabalho_api.enums.ProductType;

public record ProductResponseDTO(
    Long ID,
    String name,
    String code,
    Date manufacturing,
    Date validity,
    double amount,
    ProductType type,
    double price
) {

}
