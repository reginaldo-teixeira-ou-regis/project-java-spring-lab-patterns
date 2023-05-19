package dev.rt.projectcepapi.models.repository;

import dev.rt.projectcepapi.models.AddressModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressModel, String> {

}
