package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Cliente;
import modelo.Compras;
import modelo.DetalleCompra;

public class ControladorCompras {
	
	
	List<Compras>listaCompras;
	
	public ControladorCompras() {
		listaCompras = new ArrayList<Compras>();
	}
	
	public void agregarCompra(int numero, Date fecha, Cliente cliente, DetalleCompra detalleCompra) {
		
		Compras compra= new Compras();
		
		compra.setNumero(numero);
		compra.setFecha(fecha);
		compra.setCliente(cliente);
		compra.setDetalleCompra(detalleCompra);
		
		listaCompras.add(compra);
		
	}
	
	public double libroFisico ( double precio) {
		
		double valorC= (precio*0.02);
		double valorT = valorC+precio+20;
		return valorT;
	}
	
	public double libroVirtual (double precio) {
		
		double valorC= (precio*0.02);
		double valorT = valorC+precio;
		return valorT;
	}
	
	public String listarCompras(String cedula) {
		String cadena = "";
		for (int i = 0; i < listaCompras.size(); i++) {
			String auxCedula = listaCompras.get(i).getCliente().getCedula();
			if(auxCedula!=cedula) {
				cadena = cadena
						+"************************************************"
						+ "\n Compra N: " +  listaCompras.get(i).getNumero()
						+ "\n ------------------------------------------------"
						+ "\n Cliente: " + listaCompras.get(i).getCliente().getNombre() + "" + listaCompras.get(i).getCliente().getApellido() 
						+ "\n Cedula: " + listaCompras.get(i).getCliente().getCedula()
						+ "\n E-mail: " + listaCompras.get(i).getCliente().getEmail()
						+ "\n Telefono: " + listaCompras.get(i).getCliente().getTelefono()
						+ "\n Detalle compra: \n"
						+ "\t Titulo: " + listaCompras.get(i).getDetalleCompra().getLibro().getTitulo()
						+ "\n \t Autor: " +  listaCompras.get(i).getDetalleCompra().getLibro().getAutor()
						+ "\n \t Edicion: " +  listaCompras.get(i).getDetalleCompra().getLibro().getEdicion()
						+ "\n \t Costo: " +  listaCompras.get(i).getDetalleCompra().getLibro().getPrecio()
						+ "\n ------------------------------------------------"
						+ "\n \t Total: " +  listaCompras.get(i).getDetalleCompra().getPrecioTotal();
			}
		}
		return cadena;
	}
	
	public int sizeCompras() {
		return listaCompras.size();
	}
	
}
