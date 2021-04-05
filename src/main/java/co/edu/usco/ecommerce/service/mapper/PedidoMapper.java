package co.edu.usco.ecommerce.service.mapper;

import co.edu.usco.ecommerce.domain.*;
import co.edu.usco.ecommerce.service.dto.PedidoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Pedido} and its DTO {@link PedidoDTO}.
 */
@Mapper(componentModel = "spring", uses = { FacturaMapper.class })
public interface PedidoMapper extends EntityMapper<PedidoDTO, Pedido> {

    PedidoDTO toDto(Pedido pedido);

    Pedido toEntity(PedidoDTO pedidoDTO);

    default Pedido fromId(String id) {
        if (id == null) {
            return null;
        }
        Pedido pedido = new Pedido();
        pedido.setId(id);
        return pedido;
    }
}
