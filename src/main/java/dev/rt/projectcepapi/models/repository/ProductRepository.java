package dev.rt.projectcepapi.models.repository;

import dev.rt.projectcepapi.models.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {

}
