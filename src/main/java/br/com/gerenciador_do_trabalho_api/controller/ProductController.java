package br.com.gerenciador_do_trabalho_api.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador_do_trabalho_api.dto.ApiResponse;
import br.com.gerenciador_do_trabalho_api.dto.product.ProductRegistrationDTO;
import br.com.gerenciador_do_trabalho_api.dto.product.ProductResponseDTO;
import br.com.gerenciador_do_trabalho_api.service.product.ProductService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ApiResponse<Void> createProduct(@RequestBody @Validated ProductRegistrationDTO product){
        return this.productService.createProduct(product);
    }

    @GetMapping
    public ApiResponse<List<ProductResponseDTO>> findAllProducts(){
        return this.productService.findAllProducts();
    }

    @GetMapping("/findCode")
    public ApiResponse<List<ProductResponseDTO>> findAllProductsByCode(@RequestParam String code){
        return this.productService.findAllProductsByCode(code);
    }

    @GetMapping("/findName/{name}")
    public ApiResponse<List<ProductResponseDTO>> findAllProductsByName(@PathVariable String name){
        return this.productService.findAllProductsByName(name);
    }

}
