package co.edu.usco.ecommerce.service.impl;

import co.edu.usco.ecommerce.service.AudProductoService;
import co.edu.usco.ecommerce.service.FacturaService;
import co.edu.usco.ecommerce.service.ProductoService;
import co.edu.usco.ecommerce.service.UserService;
import co.edu.usco.ecommerce.domain.Factura;
import co.edu.usco.ecommerce.domain.Pedido;
import co.edu.usco.ecommerce.domain.Producto;
import co.edu.usco.ecommerce.domain.User;
import co.edu.usco.ecommerce.repository.FacturaRepository;
import co.edu.usco.ecommerce.service.dto.FacturaDTO;
import co.edu.usco.ecommerce.service.dto.PedidoDTO;
import co.edu.usco.ecommerce.service.dto.ProductoDTO;
import co.edu.usco.ecommerce.service.dto.UserDTO;
import co.edu.usco.ecommerce.service.mapper.FacturaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Service Implementation for managing {@link Factura}.
 */
@Service
public class FacturaServiceImpl implements FacturaService {

    private final Logger log = LoggerFactory.getLogger(FacturaServiceImpl.class);

    private final FacturaRepository facturaRepository;

    private final FacturaMapper facturaMapper;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UserService userService;

    public FacturaServiceImpl(FacturaRepository facturaRepository, FacturaMapper facturaMapper) {
        this.facturaRepository = facturaRepository;
        this.facturaMapper = facturaMapper;
    }

    @Override
    public FacturaDTO save(FacturaDTO facturaDTO, String userId) {
        log.debug("Request to save Factura : {}", facturaDTO);
        Factura factura = facturaMapper.toEntity(facturaDTO);
        factura = facturaRepository.save(factura);
        FacturaDTO facturaResult = facturaMapper.toDto(factura);

        // Agregando factura a usuario
        User user = userService.findByIdEntity(userId);
        log.debug("user : {}", user);
        Set<Factura> facturasUser = user.getFacturas();
        facturasUser.add(factura);
        user.setFacturas(facturasUser);
        userService.save(user);

        for (PedidoDTO pedido : facturaResult.getPedidos()) {
            ProductoDTO producto = pedido.getProducto();
            producto.setCantidadInventario(producto.getCantidadInventario() - pedido.getCantidad());
            producto.setCantidadVentas(producto.getCantidadVentas() + pedido.getCantidad());
            productoService.save(producto);
        }

        return facturaResult;
    }

    @Override
    public Page<FacturaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Facturas");
        return facturaRepository.findAll(pageable).map(facturaMapper::toDto);
    }

    @Override
    public Optional<FacturaDTO> findOne(String id) {
        log.debug("Request to get Factura : {}", id);
        return facturaRepository.findById(id).map(facturaMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Factura : {}", id);
        facturaRepository.deleteById(id);
    }
}
