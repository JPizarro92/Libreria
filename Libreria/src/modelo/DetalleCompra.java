package modelo;

public class DetalleCompra {

	
	private int numeroDetalle;
	private Libro libro;
	private int cantidad;
	private double precioTotal;
	
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int getNumeroDetalle() {
		return numeroDetalle;
	}
	public void setNumeroDetalle(int numeroDetalle) {
		this.numeroDetalle = numeroDetalle;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "DetalleCompra [numeroDetalle=" + numeroDetalle + ", libro=" + libro + ", cantidad=" + cantidad
				+ ", precioTotal=" + precioTotal + "]";
	}
	
	
	
}
