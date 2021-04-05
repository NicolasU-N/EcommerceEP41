package co.edu.usco.ecommerce.repository;

import co.edu.usco.ecommerce.domain.AudProducto;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the AudProducto entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AudProductoRepository extends MongoRepository<AudProducto, String> {
}
