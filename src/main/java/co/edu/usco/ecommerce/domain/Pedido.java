package co.edu.usco.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Pedido.
 */
@Document(collection = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("producto")
    private Producto producto;

    @NotNull
    @Field("cantidad")
    private Long cantidad;

    // @DBRef
    @Field("factura")
    @JsonIgnoreProperties(value = "pedidos", allowSetters = true)
    private Factura factura;

    public Pedido(String id, @NotNull Producto producto, @NotNull Long cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Pedido(@NotNull Producto producto, @NotNull Long cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Pedido() {
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public Pedido producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public Pedido cantidad(Long cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public Pedido factura(Factura factura) {
        this.factura = factura;
        return this;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pedido)) {
            return false;
        }
        return id != null && id.equals(((Pedido) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Pedido{" + "id=" + getId() + ", producto='" + getProducto() + "'" + ", cantidad=" + getCantidad() + "}";
    }

}
