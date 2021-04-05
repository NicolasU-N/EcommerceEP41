package co.edu.usco.ecommerce.service.impl;

import co.edu.usco.ecommerce.service.AudProductoService;
import co.edu.usco.ecommerce.domain.AudProducto;
import co.edu.usco.ecommerce.repository.AudProductoRepository;
import co.edu.usco.ecommerce.service.dto.AudProductoDTO;
import co.edu.usco.ecommerce.service.mapper.AudProductoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AudProducto}.
 */
@Service
public class AudProductoServiceImpl implements AudProductoService {

    private final Logger log = LoggerFactory.getLogger(AudProductoServiceImpl.class);

    private final AudProductoRepository audProductoRepository;

    private final AudProductoMapper audProductoMapper;

    public AudProductoServiceImpl(AudProductoRepository audProductoRepository, AudProductoMapper audProductoMapper) {
        this.audProductoRepository = audProductoRepository;
        this.audProductoMapper = audProductoMapper;
    }

    @Override
    public AudProductoDTO save(AudProductoDTO audProductoDTO) {
        log.debug("Request to save AudProducto : {}", audProductoDTO);
        AudProducto audProducto = audProductoMapper.toEntity(audProductoDTO);
        audProducto = audProductoRepository.save(audProducto);
        return audProductoMapper.toDto(audProducto);
    }

    @Override
    public Page<AudProductoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AudProductos");
        return audProductoRepository.findAll(pageable)
            .map(audProductoMapper::toDto);
    }


    @Override
    public Optional<AudProductoDTO> findOne(String id) {
        log.debug("Request to get AudProducto : {}", id);
        return audProductoRepository.findById(id)
            .map(audProductoMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete AudProducto : {}", id);
        audProductoRepository.deleteById(id);
    }
}
