package co.edu.usco.ecommerce.web.rest;

import co.edu.usco.ecommerce.service.FacturaService;
import co.edu.usco.ecommerce.web.rest.errors.BadRequestAlertException;
import co.edu.usco.ecommerce.service.dto.FacturaDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link co.edu.usco.ecommerce.domain.Factura}.
 */
@RestController
@RequestMapping("/api")
public class FacturaResource {

    private final Logger log = LoggerFactory.getLogger(FacturaResource.class);

    private static final String ENTITY_NAME = "factura";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FacturaService facturaService;

    public FacturaResource(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    /**
     * {@code POST  /facturas} : Create a new factura.
     *
     * @param facturaDTO the facturaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new facturaDTO, or with status {@code 400 (Bad Request)} if
     *         the factura has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/facturas/{userId}")
    public ResponseEntity<FacturaDTO> createFactura(@PathVariable("userId") String userId,
            @Valid @RequestBody FacturaDTO facturaDTO) throws URISyntaxException {
        log.debug("REST request to save Factura : {}", facturaDTO);
        if (facturaDTO.getId() != null) {
            throw new BadRequestAlertException("A new factura cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FacturaDTO result = facturaService.save(facturaDTO, userId);
        return ResponseEntity.created(new URI("/api/facturas/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
                .body(result);
    }

    /**
     * {@code GET  /facturas} : get all the facturas.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of facturas in body.
     */
    @GetMapping("/facturas")
    public ResponseEntity<List<FacturaDTO>> getAllFacturas(Pageable pageable) {
        log.debug("REST request to get a page of Facturas");
        Page<FacturaDTO> page = facturaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /facturas/:id} : get the "id" factura.
     *
     * @param id the id of the facturaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the facturaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/facturas/{id}")
    public ResponseEntity<FacturaDTO> getFactura(@PathVariable String id) {
        log.debug("REST request to get Factura : {}", id);
        Optional<FacturaDTO> facturaDTO = facturaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(facturaDTO);
    }

    /**
     * {@code DELETE  /facturas/:id} : delete the "id" factura.
     *
     * @param id the id of the facturaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/facturas/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable String id) {
        log.debug("REST request to delete Factura : {}", id);
        facturaService.delete(id);
        return ResponseEntity.noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
