package co.edu.usco.ecommerce.service;

import co.edu.usco.ecommerce.service.dto.FacturaDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link co.edu.usco.ecommerce.domain.Factura}.
 */
public interface FacturaService {

    /**
     * Save a factura.
     *
     * @param facturaDTO the entity to save.
     * @return the persisted entity.
     */
    FacturaDTO save(FacturaDTO facturaDTO, String userId);

    /**
     * Get all the facturas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<FacturaDTO> findAll(Pageable pageable);

    /**
     * Get the "id" factura.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FacturaDTO> findOne(String id);

    /**
     * Delete the "id" factura.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
