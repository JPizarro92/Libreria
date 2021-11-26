package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Admin;
import modelo.Cliente;
import modelo.Credito;

public class ControladorPersona {
	
	List<Admin> adm;
	List<Cliente> cli;
	List<Credito>listaCredito;
	
	public ControladorPersona() {
		adm = new ArrayList<Admin>();
		cli = new ArrayList<Cliente>();
		listaCredito = new ArrayList<Credito>();
	}
	
	public void crearAdmin (Admin a) {
		adm.add(a);
		 
	}
	
	public void agregarCliente (String nombre, String apellido, String cedula, String email, String telefono, Date fechaNacimiento, double valorRecarga) {
		Cliente cliente = new Cliente(nombre, apellido, cedula, email, telefono, fechaNacimiento);
		if(valorRecarga==0) {
			Credito credito = new Credito();
			credito.setCupo(0);
			credito.setId(Integer.parseInt(cedula));
			listaCredito.add(credito);
			cliente.setCredito(credito);
			
		} else {
			Credito credito = new Credito();
			credito.setCupo(valorRecarga);
			credito.setId(Integer.parseInt(cedula));
			listaCredito.add(credito);
			cliente.setCredito(credito);
		}
		cli.add(cliente);
	}
	
	public String ListarClientes() {
		String cadena="****************************************";
		for(int i = 0 ; i< cli.size() ;i++) {
			cadena = cadena + "\n[" + i+1+ "] "
					+ "\n Cliente: " + cli.get(i).getNombre() + " " + cli.get(i).getApellido()
					+ "\n Cedula: "+ cli.get(i).getCedula() 
					+ "\n Email: " + cli.get(i).getEmail()
					+ "\n Credito: $" + cli.get(i).getCredito().getCupo()
					+"****************************************";
		}
		return cadena;
	}
	
	public void actualizarCliente(Cliente cliente) {
		int i = 0;
		boolean bandera = false;
		while(bandera==false) {
			if(cli.get(i).getCedula()==cliente.getCedula()) {
				cli.add(i, cliente);
				bandera= true;
			}
			i++;
		}
	}
	
	public Cliente buscarCliente(String cedula) {
		for (int i = 0; i < cli.size(); i++) {
	    	Cliente cliente = cli.get(i);
	    	//System.out.println("entro al for");
	    	if (cedula.equals(cliente.getCedula())) {
	    		//System.out.println("entro al if");
	    		return cliente;
	    		
	    	}else {
	    		return null;
	    	}
		}
		return null;
	}
	
	public void recargaCredito(int id, double cantidad) {
			
		    for (int i = 0; i < listaCredito.size(); i++) {
		    	
		    	Credito credito = listaCredito.get(i);
		    	
		    	if (id==credito.getId()) {
		    		
		    		double nuevo = credito.getCupo()+cantidad;
		    		credito.setCupo(nuevo);
		    		
		    	}
		    	
			}
			
		}
	
	public void restarCredito(int id, double cantidad) {
		
	    for (int i = 0; i < listaCredito.size(); i++) {
	    	
	    	Credito credito = listaCredito.get(i);
	    	
	    	if (id==credito.getId()) {
	    		
	    		double nuevo = credito.getCupo()-cantidad;
	    		
	    		if (nuevo > 0) {
	    			System.out.println("nuevo "+nuevo);
	    			credito.setCupo(nuevo);
	    			
	    		}else {
	    			System.out.println("Creditos insuficientes");
	    		}
	    		
	    	}
	    }
	}
	    	
	
	


}
