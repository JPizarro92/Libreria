package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Cliente;
import modelo.Compras;

public class ControladorCompras {
	
	
	List<Compras>listaCompras;
	
	public ControladorCompras() {
		listaCompras = new ArrayList<Compras>();
	}
	
	public void crearCompra(int numero, Date fecha, Cliente cliente, List DetalleCompra) {
		
		Compras compra= new Compras();
		
		compra.setNumero(numero);
		compra.setFecha(fecha);
		compra.setCliente(cliente);
		compra.setDetalles(DetalleCompra);
		
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
	
	public void listarCompras(Cliente cli) {
		for (int i = 0; i < listaCompras.size(); i++) {
			   Compras com = listaCompras.get(i);
					if (cli.getCedula().equals(com.getCliente().getCedula())) {
			    		System.out.println(com.toString());
			    	}
			    	
				}
	}
	
	
}
