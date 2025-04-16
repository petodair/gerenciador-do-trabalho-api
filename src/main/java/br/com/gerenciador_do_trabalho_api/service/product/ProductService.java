package br.com.gerenciador_do_trabalho_api.service.product;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.gerenciador_do_trabalho_api.dto.ApiResponse;
import br.com.gerenciador_do_trabalho_api.dto.product.ProductRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.product.ProductResponseDTO;
import br.com.gerenciador_do_trabalho_api.mapper.ProductMapper;
import br.com.gerenciador_do_trabalho_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public ApiResponse<Void> createProduct(ProductRegistrationDTO product) {
        
        this.productRepository.save(mapper.toProduct(product));

        return new ApiResponse<Void>(
            ApiResponse.ResponseStatusType.SUCCESS,
             HttpStatus.CREATED,
            null,
            "Produto registrado com sucesso!");
    }

    @Override
    public ApiResponse<List<ProductResponseDTO>> findAllProductsByCode(String code) {
        List<ProductResponseDTO> users = this.productRepository.findByCodeContainingIgnoreCase(code).stream()
        .map(mapper::toProductResponseDTO)
        .toList();

        return new ApiResponse<List<ProductResponseDTO>>(
            ApiResponse.ResponseStatusType.SUCCESS,
            HttpStatus.OK,
            users,
            "Produtos do sistema retornados com sucesso!");
    }

    @Override
    public ApiResponse<List<ProductResponseDTO>> findAllProductsByName(String name) {
        List<ProductResponseDTO> users = this.productRepository.findByNameContainingIgnoreCase(name).stream()
        .map(mapper::toProductResponseDTO)
        .toList();

        return new ApiResponse<List<ProductResponseDTO>>(
            ApiResponse.ResponseStatusType.SUCCESS,
            HttpStatus.OK,
            users,
            "Produtos do sistema retornados com sucesso!");
    }

    @Override
    public ApiResponse<List<ProductResponseDTO>> findAllProducts() {
        List<ProductResponseDTO> users = this.productRepository.findAll().stream()
        .map(mapper::toProductResponseDTO)
        .toList();

        return new ApiResponse<List<ProductResponseDTO>>(
            ApiResponse.ResponseStatusType.SUCCESS,
            HttpStatus.OK,
            users,
            "Produtos do sistema retornados com sucesso!");
    }

}
