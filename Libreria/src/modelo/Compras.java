package modelo;

import java.util.Date;
import java.util.List;

public class Compras {
	
	private int numero;
	private Date fecha;
	private Cliente cliente;
	private DetalleCompra detalleCompra;
		
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public DetalleCompra getDetalleCompra() {
		return detalleCompra;
	}
	public void setDetalleCompra(DetalleCompra detalleCompra) {
		this.detalleCompra = detalleCompra;
	}
	
	

}
