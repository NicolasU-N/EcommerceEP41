package co.edu.usco.ecommerce.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import co.edu.usco.ecommerce.service.dto.FacturaDTO;

import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Factura.
 */
@Document(collection = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("fecha")
    private Instant fecha;

    @NotNull
    @Field("total")
    private BigDecimal total;

    @NotNull
    @Field("estado")
    private Long estado;

    // @DBRef
    @Field("pedidos")
    private Set<Pedido> pedidos = new HashSet<>();

    public Factura(@NotNull Instant fecha, @NotNull BigDecimal total, @NotNull Long estado, Set<Pedido> pedidos) {
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.pedidos = pedidos;
    }

    public Factura() {
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getFecha() {
        return fecha;
    }

    public Factura fecha(Instant fecha) {
        this.fecha = fecha;
        return this;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Factura total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getEstado() {
        return estado;
    }

    public Factura estado(Long estado) {
        this.estado = estado;
        return this;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public Factura pedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
        return this;
    }

    public Factura addPedidos(Pedido pedido) {
        this.pedidos.add(pedido);
        pedido.setFactura(this);
        return this;
    }

    public Factura removePedidos(Pedido pedido) {
        this.pedidos.remove(pedido);
        pedido.setFactura(null);
        return this;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Factura)) {
            return false;
        }
        return id != null && id.equals(((Factura) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Factura{" + "id=" + getId() + ", fecha='" + getFecha() + "'" + ", total=" + getTotal() + ", estado="
                + getEstado() + "}";
    }
}
