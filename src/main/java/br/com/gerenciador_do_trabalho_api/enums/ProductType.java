package br.com.gerenciador_do_trabalho_api.enums;

public enum ProductType {

    FRANGO("Frango"),
    BOVINO("Bovino"),
    SUINO("Suino"),
    CONGELADO("Congelado"),
    VACUO("Vacuo");

    private String productType;

    private ProductType(String productType){
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

}
