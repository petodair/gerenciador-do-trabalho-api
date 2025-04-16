package br.com.gerenciador_do_trabalho_api.dto.product;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gerenciador_do_trabalho_api.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRegistrationDTO(

    String name,

    @NotBlank(message = "O código deve ser preenchido")
    @Size(min = 3, message = "O código deve conter pelo menos 3 dígitos")
    String code,

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    Date manufacturing,

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    Date validity,

    double amount,

    ProductType type,

    double price

) {

}
