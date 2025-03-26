package gestionDeProductos.controller;

import gestionDeProductos.model.Product;
import gestionDeProductos.view.ProductView;

public class ProductController {
    private Product product;
    private ProductView view;

    public ProductController(Product product, ProductView view) {
        this.product = product;
        this.view = view;
    }

    public void updatePrice(Product product, double newPrice){
        product.setPrice(newPrice);
    }

    public void updateView(){
        view.displayProduct(product);
    }
}
