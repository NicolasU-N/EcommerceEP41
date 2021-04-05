package co.edu.usco.ecommerce.service;

import co.edu.usco.ecommerce.service.dto.AudProductoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link co.edu.usco.ecommerce.domain.AudProducto}.
 */
public interface AudProductoService {

    /**
     * Save a audProducto.
     *
     * @param audProductoDTO the entity to save.
     * @return the persisted entity.
     */
    AudProductoDTO save(AudProductoDTO audProductoDTO);

    /**
     * Get all the audProductos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AudProductoDTO> findAll(Pageable pageable);


    /**
     * Get the "id" audProducto.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AudProductoDTO> findOne(String id);

    /**
     * Delete the "id" audProducto.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
