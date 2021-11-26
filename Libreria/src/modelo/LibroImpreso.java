package modelo;

public class LibroImpreso extends Libro {

	public LibroImpreso() {};
	public LibroImpreso(String titulo, String autor, int edicion, double precio) {
		super(titulo, autor, edicion, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double costoComision() {
		// TODO Auto-generated method stub
		return (1.02*this.getPrecio())-this.getPrecio();
	}

	@Override
	public double costoEnvio() {
		// TODO Auto-generated method stub
		return 20.0;
	}
	
	

}
