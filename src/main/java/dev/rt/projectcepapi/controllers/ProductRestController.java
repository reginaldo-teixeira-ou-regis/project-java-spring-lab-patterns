package dev.rt.projectcepapi.controllers;

import dev.rt.projectcepapi.models.ProductModel;
import dev.rt.projectcepapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<ProductModel>> findAll() {

        return ResponseEntity.ok(productService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long id) {

        return ResponseEntity.ok(productService.findById(id));

    }

    @PostMapping
    public ResponseEntity<ProductModel> insert(@RequestBody ProductModel productModel) {
        productService.insert(productModel);
        return ResponseEntity.ok(productModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> update(
            @PathVariable Long id,
            @RequestBody ProductModel productModel) {
        productService.update(id, productModel);
        return ResponseEntity.ok(productModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
