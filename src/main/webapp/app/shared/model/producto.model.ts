export interface IProducto {
  id?: string;
  nombre?: string;
  precio?: number;
  iva?: number;
  cantidadInventario?: number;
  cantidadVentas?: number;
  imagen?: string;
  descripcion?: string;
}

export class Producto implements IProducto {
  constructor(
    public id?: string,
    public nombre?: string,
    public precio?: number,
    public iva?: number,
    public cantidadInventario?: number,
    public cantidadVentas?: number,
    public imagen?: string,
    public descripcion?: string
  ) {}
}
