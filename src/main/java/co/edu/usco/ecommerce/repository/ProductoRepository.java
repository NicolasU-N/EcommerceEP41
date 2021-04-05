package co.edu.usco.ecommerce.repository;

import co.edu.usco.ecommerce.domain.Producto;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Producto entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {
}
