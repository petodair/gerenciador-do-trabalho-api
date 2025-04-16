package br.com.gerenciador_do_trabalho_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.gerenciador_do_trabalho_api.dto.product.ProductRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.product.ProductResponseDTO;
import br.com.gerenciador_do_trabalho_api.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "ID", ignore = true)
    Product toProduct(ProductRegistrationDTO product);
    
    ProductResponseDTO toProductResponseDTO(Product product);

}
