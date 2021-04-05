package co.edu.usco.ecommerce.service.mapper;

import co.edu.usco.ecommerce.domain.*;
import co.edu.usco.ecommerce.service.dto.AudProductoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AudProducto} and its DTO {@link AudProductoDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProductoMapper.class })
public interface AudProductoMapper extends EntityMapper<AudProductoDTO, AudProducto> {

    default AudProducto fromId(String id) {
        if (id == null) {
            return null;
        }
        AudProducto audProducto = new AudProducto();
        audProducto.setId(id);
        return audProducto;
    }
}
