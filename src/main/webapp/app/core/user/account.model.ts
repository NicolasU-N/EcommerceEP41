import { IFactura } from 'app/shared/model/factura.model';
import { Moment } from 'moment';

export class Account {
  constructor(
    public id: string,
    public activated: boolean,
    public authorities: string[],
    public facturas: IFactura[],
    public email: string,
    public firstName: string,
    public langKey: string,
    public lastName: string,
    public login: string,
    public imageUrl: string
  ) // public createdBy: string,
  // public createdDate: Moment,
  // public lastModifiedBy: string,
  // public lastModifiedDate: Moment,
  // public direccion: string,
  // public numeroDocumento: string,
  // public password: string
  {}
}
