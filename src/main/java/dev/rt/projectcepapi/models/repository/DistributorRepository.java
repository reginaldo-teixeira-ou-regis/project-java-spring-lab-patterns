package dev.rt.projectcepapi.models.repository;

import dev.rt.projectcepapi.models.DistributorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends CrudRepository<DistributorModel, Long> {

}
