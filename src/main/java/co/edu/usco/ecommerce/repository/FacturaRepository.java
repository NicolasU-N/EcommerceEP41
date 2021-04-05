package co.edu.usco.ecommerce.repository;

import co.edu.usco.ecommerce.domain.Factura;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Factura entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FacturaRepository extends MongoRepository<Factura, String> {
}
