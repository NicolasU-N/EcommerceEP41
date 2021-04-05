package co.edu.usco.ecommerce.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link co.edu.usco.ecommerce.domain.AudProducto} entity.
 */
public class AudProductoDTO implements Serializable {

    private String id;

    @NotNull
    private String tipo;

    @NotNull
    private Instant fecha;

    private ProductoDTO producto;

    public AudProductoDTO(@NotNull String tipo, @NotNull Instant fecha, ProductoDTO producto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.producto = producto;
    }

    public AudProductoDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AudProductoDTO)) {
            return false;
        }

        return id != null && id.equals(((AudProductoDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "AudProductoDTO [fecha=" + fecha + ", id=" + id + ", producto=" + producto + ", tipo=" + tipo + "]";
    }

}
