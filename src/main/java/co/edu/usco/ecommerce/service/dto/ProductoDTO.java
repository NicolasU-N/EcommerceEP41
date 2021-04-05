package co.edu.usco.ecommerce.service.dto;

import javax.validation.constraints.*;

import co.edu.usco.ecommerce.domain.Producto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link co.edu.usco.ecommerce.domain.Producto} entity.
 */
public class ProductoDTO implements Serializable {

    private String id;

    @NotNull
    private String nombre;

    @NotNull
    private BigDecimal precio;

    @NotNull
    private Double iva;

    @NotNull
    private Long cantidadInventario;

    @NotNull
    private Long cantidadVentas;

    private String imagen;

    private String descripcion;

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();

        this.precio = producto.getPrecio();

        this.iva = producto.getIva();

        this.cantidadInventario = producto.getCantidadInventario();

        this.cantidadVentas = producto.getCantidadVentas();

        this.imagen = producto.getImagen();

        this.descripcion = producto.getDescripcion();
    }

    public ProductoDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Long getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(Long cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public Long getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(Long cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductoDTO)) {
            return false;
        }

        return id != null && id.equals(((ProductoDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductoDTO{" + "id=" + getId() + ", nombre='" + getNombre() + "'" + ", precio=" + getPrecio()
                + ", iva=" + getIva() + ", cantidadInventario=" + getCantidadInventario() + ", cantidadVentas="
                + getCantidadVentas() + ", imagen='" + getImagen() + "'" + ", descripcion='" + getDescripcion() + "'"
                + "}";
    }
}
