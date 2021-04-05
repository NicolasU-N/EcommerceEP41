package co.edu.usco.ecommerce.service.dto;

import javax.validation.constraints.*;

import co.edu.usco.ecommerce.domain.Pedido;

import java.io.Serializable;

/**
 * A DTO for the {@link co.edu.usco.ecommerce.domain.Pedido} entity.
 */
public class PedidoDTO implements Serializable {

    private String id;

    @NotNull
    private ProductoDTO producto;

    @NotNull
    private Long cantidad;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.cantidad = pedido.getCantidad();
        this.producto = new ProductoDTO(pedido.getProducto());
    }

    public PedidoDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoDTO)) {
            return false;
        }

        return id != null && id.equals(((PedidoDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedidoDTO{" + "id=" + getId() + ", producto='" + getProducto() + "'" + ", cantidad=" + getCantidad()
                + "}";
    }
}
