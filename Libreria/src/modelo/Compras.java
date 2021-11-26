package modelo;

import java.util.Date;
import java.util.List;

public class Compras {
	
	private int numero;
	private Date fecha;
	private Cliente cliente;
	private List<DetalleCompra> detalles;
	
	
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
	public List<DetalleCompra> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleCompra> detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "Compras [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", detalles=" + detalles
				+ "]";
	}
	
	

}
