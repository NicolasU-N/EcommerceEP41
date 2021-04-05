package co.edu.usco.ecommerce.service.impl;

import co.edu.usco.ecommerce.service.PedidoService;
import co.edu.usco.ecommerce.domain.Pedido;
import co.edu.usco.ecommerce.repository.PedidoRepository;
import co.edu.usco.ecommerce.service.dto.PedidoDTO;
import co.edu.usco.ecommerce.service.mapper.PedidoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Pedido}.
 */
@Service
public class PedidoServiceImpl implements PedidoService {

    private final Logger log = LoggerFactory.getLogger(PedidoServiceImpl.class);

    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public PedidoDTO save(PedidoDTO pedidoDTO) {
        log.debug("Request to save Pedido : {}", pedidoDTO);
        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        pedido = pedidoRepository.save(pedido);
        return pedidoMapper.toDto(pedido);
    }

    @Override
    public Page<PedidoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Pedidos");
        return pedidoRepository.findAll(pageable)
            .map(pedidoMapper::toDto);
    }


    @Override
    public Optional<PedidoDTO> findOne(String id) {
        log.debug("Request to get Pedido : {}", id);
        return pedidoRepository.findById(id)
            .map(pedidoMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Pedido : {}", id);
        pedidoRepository.deleteById(id);
    }
}
