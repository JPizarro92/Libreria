package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.LibroImpreso;
import modelo.Cliente;
import modelo.LibroDigital;

public class ControladorLibro {
	
	private List <LibroImpreso> fi;
	private List<LibroDigital>vi;
	
	public ControladorLibro() {
		fi= new ArrayList<LibroImpreso>();
		vi= new ArrayList<LibroDigital>();
	}

	public void crearLibroFisico(String titulo, String autor, int edicion, double precio) {
		
		LibroImpreso l = new LibroImpreso();
		
		l.setTitulo(titulo);
		l.setAutor(autor);
		l.setEdicion(edicion);
		l.setPrecio(precio);
		
		fi.add(l);
		
		
	}
	
	public void crearLibroVirtual(String titulo, String autor, int edicion, double precio) {
		
		LibroDigital l = new LibroDigital();
		
		l.setTitulo(titulo);
		l.setAutor(autor);
		l.setEdicion(edicion);
		l.setPrecio(precio);
		
		vi.add(l);
		
	}

	public LibroDigital obtenerLibroDigital(int pos) {
		return vi.get(pos);
	}
	
	public LibroImpreso obtenerLibroImpreso(int pos) {
		return fi.get(pos);
	}
	
	public int sizeLibrosDigitales() {
		return vi.size();
	}
	
	public int sizeLibrosImpresos() {
		return fi.size();
	}

	public String listarLibroDigital() {
		String cadena="****************************************";
		for(int i = 0 ; i< vi.size() ;i++) {
			cadena = cadena + "\n[" + i+1+ "] "
					+ "\n Titulo: " + vi.get(i).getTitulo()
					+ "\n Autor: "+vi.get(i).getAutor() 
					+ "\n Edicion: " + vi.get(i).getEdicion()
					+ "\n Costo: $" + vi.get(i).getPrecio()
					+"****************************************";
		}
		return cadena;
	}
	
	public String listarLibroImpreso() {
		String cadena="****************************************";
		for(int i = 0 ; i< fi.size() ;i++) {
			cadena = cadena + "\n[" + i+1+ "] "
					+ "\n Titulo: " + fi.get(i).getTitulo()
					+ "\n Autor: "+fi.get(i).getAutor() 
					+ "\n Edicion: " + fi.get(i).getEdicion()
					+ "\n Costo: $" + fi.get(i).getPrecio()
					+"****************************************";
		}
		return cadena;
	}

}
