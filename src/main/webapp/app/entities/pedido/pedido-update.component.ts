import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IPedido, Pedido } from 'app/shared/model/pedido.model';
import { PedidoService } from './pedido.service';
import { IFactura } from 'app/shared/model/factura.model';
import { FacturaService } from 'app/entities/factura/factura.service';

@Component({
  selector: 'jhi-pedido-update',
  templateUrl: './pedido-update.component.html',
})
export class PedidoUpdateComponent implements OnInit {
  isSaving = false;
  facturas: IFactura[] = [];

  editForm = this.fb.group({
    id: [],
    productoId: [null, [Validators.required]],
    cantidad: [null, [Validators.required]],
  });

  constructor(
    protected pedidoService: PedidoService,
    protected facturaService: FacturaService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ pedido }) => {
      this.updateForm(pedido);

      this.facturaService.query().subscribe((res: HttpResponse<IFactura[]>) => (this.facturas = res.body || []));
    });
  }

  updateForm(pedido: IPedido): void {
    this.editForm.patchValue({
      id: pedido.id,
      productoId: pedido.producto!.id,
      cantidad: pedido.cantidad,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const pedido = this.createFromForm();
    if (pedido.id !== undefined) {
      this.subscribeToSaveResponse(this.pedidoService.update(pedido));
    } else {
      this.subscribeToSaveResponse(this.pedidoService.create(pedido));
    }
  }

  private createFromForm(): IPedido {
    return {
      ...new Pedido(),
      id: this.editForm.get(['id'])!.value,
      producto: this.editForm.get(['productoId'])!.value,
      cantidad: this.editForm.get(['cantidad'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPedido>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IFactura): any {
    return item.id;
  }
}
