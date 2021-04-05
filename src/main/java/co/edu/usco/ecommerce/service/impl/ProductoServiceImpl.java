package co.edu.usco.ecommerce.service.impl;

import co.edu.usco.ecommerce.service.AudProductoService;
import co.edu.usco.ecommerce.service.ProductoService;
import co.edu.usco.ecommerce.domain.Producto;
import co.edu.usco.ecommerce.repository.ProductoRepository;
import co.edu.usco.ecommerce.service.dto.AudProductoDTO;
import co.edu.usco.ecommerce.service.dto.ProductoDTO;
import co.edu.usco.ecommerce.service.mapper.ProductoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Producto}.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    private final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    @Autowired
    private AudProductoService audProductoService;

    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        log.debug("Request to save Producto : {}", productoDTO);

        Producto producto = productoMapper.toEntity(productoDTO);
        producto = productoRepository.save(producto);
        productoDTO = productoMapper.toDto(producto);
        audProductoService.save(
                new AudProductoDTO(productoDTO.getId() == null ? "INSERT" : "UPDATE", Instant.now(), productoDTO));
        return productoDTO;
    }

    @Override
    public Page<ProductoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Productos");
        return productoRepository.findAll(pageable).map(productoMapper::toDto);
    }

    @Override
    public Optional<ProductoDTO> findOne(String id) {
        log.debug("Request to get Producto : {}", id);
        return productoRepository.findById(id).map(productoMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Producto : {}", id);
        Optional<ProductoDTO> productoDTO = findOne(id);
        productoRepository.deleteById(id);
        if (productoDTO.isPresent()) {
            audProductoService.save(new AudProductoDTO("DELETE", Instant.now(), productoDTO.get()));
        }
    }
}
