package co.edu.usco.ecommerce.service.mapper;

import co.edu.usco.ecommerce.domain.*;
import co.edu.usco.ecommerce.service.dto.FacturaDTO;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapper for the entity {@link Factura} and its DTO {@link FacturaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FacturaMapper extends EntityMapper<FacturaDTO, Factura> {

    Logger log = LoggerFactory.getLogger(FacturaMapper.class);

    default Factura fromId(String id) {
        if (id == null) {
            return null;
        }
        Factura factura = new Factura();
        factura.setId(id);
        return factura;
    }

    default Set<FacturaDTO> toSetFacturaDto(Set<Factura> facturas) {
        log.debug("IMPRIMIENDO FACTURAS MAPPER: {}", facturas);
        if (facturas == null) {
            return new HashSet<>();
        }
        return facturas.stream().map(this::toDto).collect(Collectors.toSet());
    }

    default Set<Factura> toSetFactura(Set<FacturaDTO> facturas) {
        if (facturas == null) {
            return new HashSet<>();
        }
        return facturas.stream().map(this::toEntity).collect(Collectors.toSet());
    }
}
