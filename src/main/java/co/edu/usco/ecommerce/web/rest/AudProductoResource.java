package co.edu.usco.ecommerce.web.rest;

import co.edu.usco.ecommerce.service.AudProductoService;
import co.edu.usco.ecommerce.web.rest.errors.BadRequestAlertException;
import co.edu.usco.ecommerce.service.dto.AudProductoDTO;

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
 * REST controller for managing {@link co.edu.usco.ecommerce.domain.AudProducto}.
 */
@RestController
@RequestMapping("/api")
public class AudProductoResource {

    private final Logger log = LoggerFactory.getLogger(AudProductoResource.class);

    private static final String ENTITY_NAME = "audProducto";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AudProductoService audProductoService;

    public AudProductoResource(AudProductoService audProductoService) {
        this.audProductoService = audProductoService;
    }

    /**
     * {@code POST  /aud-productos} : Create a new audProducto.
     *
     * @param audProductoDTO the audProductoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new audProductoDTO, or with status {@code 400 (Bad Request)} if the audProducto has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/aud-productos")
    public ResponseEntity<AudProductoDTO> createAudProducto(@Valid @RequestBody AudProductoDTO audProductoDTO) throws URISyntaxException {
        log.debug("REST request to save AudProducto : {}", audProductoDTO);
        if (audProductoDTO.getId() != null) {
            throw new BadRequestAlertException("A new audProducto cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AudProductoDTO result = audProductoService.save(audProductoDTO);
        return ResponseEntity.created(new URI("/api/aud-productos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /aud-productos} : Updates an existing audProducto.
     *
     * @param audProductoDTO the audProductoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated audProductoDTO,
     * or with status {@code 400 (Bad Request)} if the audProductoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the audProductoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/aud-productos")
    public ResponseEntity<AudProductoDTO> updateAudProducto(@Valid @RequestBody AudProductoDTO audProductoDTO) throws URISyntaxException {
        log.debug("REST request to update AudProducto : {}", audProductoDTO);
        if (audProductoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AudProductoDTO result = audProductoService.save(audProductoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, audProductoDTO.getId()))
            .body(result);
    }

    /**
     * {@code GET  /aud-productos} : get all the audProductos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of audProductos in body.
     */
    @GetMapping("/aud-productos")
    public ResponseEntity<List<AudProductoDTO>> getAllAudProductos(Pageable pageable) {
        log.debug("REST request to get a page of AudProductos");
        Page<AudProductoDTO> page = audProductoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /aud-productos/:id} : get the "id" audProducto.
     *
     * @param id the id of the audProductoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the audProductoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/aud-productos/{id}")
    public ResponseEntity<AudProductoDTO> getAudProducto(@PathVariable String id) {
        log.debug("REST request to get AudProducto : {}", id);
        Optional<AudProductoDTO> audProductoDTO = audProductoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(audProductoDTO);
    }

    /**
     * {@code DELETE  /aud-productos/:id} : delete the "id" audProducto.
     *
     * @param id the id of the audProductoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/aud-productos/{id}")
    public ResponseEntity<Void> deleteAudProducto(@PathVariable String id) {
        log.debug("REST request to delete AudProducto : {}", id);
        audProductoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
