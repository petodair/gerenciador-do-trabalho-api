package br.com.gerenciador_do_trabalho_api.service.product;

import java.util.List;

import br.com.gerenciador_do_trabalho_api.dto.ApiResponse;
import br.com.gerenciador_do_trabalho_api.dto.product.ProductRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.product.ProductResponseDTO;

public interface IProductService {

    public ApiResponse<Void> createProduct(ProductRegistrationDTO product);
    public ApiResponse<List<ProductResponseDTO>> findAllProductsByCode(String code);
    public ApiResponse<List<ProductResponseDTO>> findAllProductsByName(String name);
    public ApiResponse<List<ProductResponseDTO>> findAllProducts();

}
