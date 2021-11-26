package modelo;

import java.util.Date;

public class Cliente extends Persona{

	private Credito credito;
	
	public Cliente(String nombre, String apellido, String cedula, String email, String telefono, Date fechaNacimiento) {
		super(nombre, apellido, cedula, email, telefono, fechaNacimiento);
		// TODO Auto-generated constructor stub
	}

	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	@Override
	public String toString() {
		return "Cliente [credito=" + credito + "]";
	}

	
	
}
