package co.edu.usco.ecommerce.repository;

import co.edu.usco.ecommerce.domain.Pedido;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Pedido entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
