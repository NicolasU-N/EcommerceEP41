package co.edu.usco.ecommerce.service.dto;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.*;

import co.edu.usco.ecommerce.domain.Factura;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link co.edu.usco.ecommerce.domain.Factura} entity.
 */
public class FacturaDTO implements Serializable {

    private String id;

    @NotNull
    private Instant fecha;

    @NotNull
    private BigDecimal total;

    @NotNull
    private Long estado;

    private Set<PedidoDTO> pedidos;

    public FacturaDTO(Factura factura) {
        this.id = factura.getId();
        this.fecha = factura.getFecha();
        this.total = factura.getTotal();
        this.estado = factura.getEstado();
        this.pedidos = factura.getPedidos().stream().map(PedidoDTO::new).collect(Collectors.toSet());
    }

    public FacturaDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Set<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FacturaDTO)) {
            return false;
        }

        return id != null && id.equals(((FacturaDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "FacturaDTO [estado=" + estado + ", fecha=" + fecha + ", id=" + id + ", pedidos=" + pedidos + ", total="
                + total + "]";
    }

}
