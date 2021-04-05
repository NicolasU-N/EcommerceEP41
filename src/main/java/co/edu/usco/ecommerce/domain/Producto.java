package co.edu.usco.ecommerce.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A Producto.
 */
@Document(collection = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("nombre")
    private String nombre;

    @NotNull
    @Field("precio")
    private BigDecimal precio;

    @NotNull
    @Field("iva")
    private Double iva;

    @NotNull
    @Field("cantidad_inventario")
    private Long cantidadInventario;

    @NotNull
    @Field("cantidad_ventas")
    private Long cantidadVentas;

    @Field("imagen")
    private String imagen;

    @Field("descripcion")
    private String descripcion;

    public Producto(@NotNull String nombre, @NotNull BigDecimal precio, @NotNull Double iva,
            @NotNull Long cantidadInventario, @NotNull Long cantidadVentas) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
        this.cantidadInventario = cantidadInventario;
        this.cantidadVentas = cantidadVentas;
    }

    public Producto() {
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public Producto precio(BigDecimal precio) {
        this.precio = precio;
        return this;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Double getIva() {
        return iva;
    }

    public Producto iva(Double iva) {
        this.iva = iva;
        return this;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Long getCantidadInventario() {
        return cantidadInventario;
    }

    public Producto cantidadInventario(Long cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
        return this;
    }

    public void setCantidadInventario(Long cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public Long getCantidadVentas() {
        return cantidadVentas;
    }

    public Producto cantidadVentas(Long cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
        return this;
    }

    public void setCantidadVentas(Long cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public String getImagen() {
        return imagen;
    }

    public Producto imagen(String imagen) {
        this.imagen = imagen;
        return this;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Producto descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Producto)) {
            return false;
        }
        return id != null && id.equals(((Producto) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Producto{" + "id=" + getId() + ", nombre='" + getNombre() + "'" + ", precio=" + getPrecio() + ", iva="
                + getIva() + ", cantidadInventario=" + getCantidadInventario() + ", cantidadVentas="
                + getCantidadVentas() + ", imagen='" + getImagen() + "'" + ", descripcion='" + getDescripcion() + "'"
                + "}";
    }

}
