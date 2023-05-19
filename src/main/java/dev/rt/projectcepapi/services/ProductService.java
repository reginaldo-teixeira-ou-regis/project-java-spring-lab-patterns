package dev.rt.projectcepapi.services;

import dev.rt.projectcepapi.models.ProductModel;

public interface ProductService {

    Iterable<ProductModel> findAll();

    ProductModel findById(Long id);

    void insert(ProductModel productModel);

    void update(Long id, ProductModel productModel);

    void delete(Long id);
}
