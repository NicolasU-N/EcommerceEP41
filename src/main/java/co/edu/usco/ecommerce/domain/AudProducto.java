package co.edu.usco.ecommerce.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A AudProducto.
 */
@Document(collection = "aud_producto")
public class AudProducto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("tipo")
    private String tipo;

    @NotNull
    @Field("fecha")
    private Instant fecha;

    // @DBRef
    @Field("producto")
    private Producto producto;

    public AudProducto(@NotNull String tipo, @NotNull Instant fecha, Producto producto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.producto = producto;
    }

    public AudProducto() {
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public AudProducto tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Instant getFecha() {
        return fecha;
    }

    public AudProducto fecha(Instant fecha) {
        this.fecha = fecha;
        return this;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public AudProducto producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AudProducto)) {
            return false;
        }
        return id != null && id.equals(((AudProducto) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AudProducto{" + "id=" + getId() + ", tipo='" + getTipo() + "'" + ", fecha='" + getFecha() + "'" + "}";
    }
}
