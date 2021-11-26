package modelo;

public class LibroDigital extends Libro{
	
	public LibroDigital() {};
	
	public LibroDigital(String titulo, String autor, int edicion, double precio) {
		super(titulo, autor, edicion, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double costoComision() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costoEnvio() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
