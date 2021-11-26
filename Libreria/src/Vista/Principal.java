package Vista;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controlador.ControladorCompras;
import controlador.ControladorLibro;
import controlador.ControladorPersona;
import modelo.Cliente;
import modelo.Credito;
import modelo.DetalleCompra;
import modelo.LibroDigital;
import modelo.LibroImpreso;

public class Principal {
	
	static Scanner entrada = new Scanner(System.in);
	static ControladorLibro cLibro;
	static ControladorPersona controladorPersona;
	static ControladorCompras controladorCompras;
	static DetalleCompra detalleCompra;
	static List<DetalleCompra> detalles;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		controladorPersona = new ControladorPersona();
		cLibro = new ControladorLibro();
		controladorCompras = new ControladorCompras();
		detalleCompra = new DetalleCompra();
		detalles = new ArrayList<DetalleCompra>();
		int numFactura=1;
		int opc;
		boolean bandera = false;
		
		String menu = "********************************************\n"
				+ "                 Menu Librería\n"
				+ "********************************************\n"
				+ "[1] Registro Libro\n"
				+ "[2] Menu Clientes\n"
				+ "[3] Menu Venta\n"
				+ "[4] Salir\n"
				+ "********************************************";
		
		do {
			System.out.println(menu);
			opc= validaNumeroIntRango(1, 4);
			switch(opc){
			case 1:
				System.out.println("********************************************");
				System.out.println("             Registro de Libro");
				System.out.println("********************************************");
				//System.out.println("");
				
				System.out.println("----Ingrese Título del Libro----");
				String titulo = entrada.nextLine();
				System.out.println("----Ingrese Nombre del Autor----");
				String autor = entrada.nextLine();
				System.out.println("----Ingrese Número de Edición");
				int edicion = validaNumeroInt();
				System.out.println("----Ingrese el Costo del Libro");
				double costo = validaNumeroDouble();
				
				System.out.println("----Indique el tipo de libro ingreso\n"
						+ "[1] Digital\n"
						+ "[2] Impreso\n");
				
				int opcLibro = validaNumeroIntRango(1, 2);
				
				switch(opcLibro) {
				case 1:
					cLibro.crearLibroVirtual(titulo, autor, edicion,costo);
					;break;
				case 2:
					cLibro.crearLibroFisico(titulo, autor, edicion,costo);
					;break;
				}
				
				;break;
			case 2:
				System.out.println("********************************************");
				System.out.println("              Menu de Clientes");
				System.out.println("********************************************");
				String menuCliente = "----Seleccione una opción:----\n"
						+ "[1] Registrar Cliente\n"
						+ "[2] Recargar Credito\n"
						+ "[3] Listar Clientes\n"
						+ "[4] << Regresar";
				System.out.println(menuCliente);
				int opcMenuCliente = validaNumeroIntRango(1, 4);
				switch(opcMenuCliente) {
				case 1:
					System.out.println("********************************************");
					System.out.println("             Registro Cliente");
					System.out.println("********************************************");
					System.out.println("----Ingrese Nombre:");
					String nombre = entrada.nextLine();
					System.out.println("----Ingrese Apellido:");
					String apellido = entrada.nextLine();
					System.out.println("----Ingrese Cédula:");
					String cedula = entrada.nextLine();
					System.out.println("----Ingrese Fecha Nacimiento (yyyy-MM-dd):");
					Date fechaNacimiento = validaFecha();
					System.out.println("----Ingrese E-mail:");
					String email = entrada.nextLine();
					System.out.println("----Ingrese Teléfono:");
					String telefono = entrada.nextLine();
					
					System.out.println("----Desea agregar saldo a su credito? \n"
							+ "[1] Si\n"
							+ "[2] No");
					int opcRecargaNuevoCliente = validaNumeroIntRango(1,2);
					double valorRecarga = 0;
					if(opcRecargaNuevoCliente==1) {
						System.out.println("Ingrese valor de la recarga");
						valorRecarga = validaNumeroDouble();
					}
					controladorPersona.agregarCliente(nombre, apellido, cedula, email, telefono, fechaNacimiento, valorRecarga);
					;break;
				case 2:
					System.out.println("********************************************");
					System.out.println("             Regarga Credito");
					System.out.println("********************************************");
					System.out.println("----Ingrese Cedula Cliente:");
					String cedulaCliente = entrada.nextLine();
					Cliente cli = controladorPersona.buscarCliente(cedulaCliente);
					System.out.println("----Ingrese el valor a recargar:");
					double recarga = entrada.nextDouble();
					controladorPersona.recargaCredito(cli.getCredito().getId(), recarga);
					System.out.println("VALOR RECARGADO CORRECTAMENTE");
					;break;
				case 3:
					System.out.println(controladorPersona.ListarClientes());
					//controladorPersona.ListarCliente();
					;break;
				}
				
				;break;
			case 3:
				System.out.println("********************************************");
				System.out.println("            Menu de Compras");
				System.out.println("********************************************");
				String menuCompras = "----Seleccione una opción:----\n"
						+ "[1] Registrar Compra\n"
						+ "[2] Lista Compras por Cliente\n"
						+ "[3] << Regresar";
				System.out.println(menuCompras);
				int opcMenuCompras = validaNumeroIntRango(1, 3);
				switch(opcMenuCompras) {
				case 1:
					System.out.println("********************************************");
					System.out.println("             Registrar Compra");
					System.out.println("********************************************");
					System.out.println("----Ingrese Cedula Cliente:");
					String cedulaCliente = entrada.nextLine();
					Cliente cli = controladorPersona.buscarCliente(cedulaCliente);
					if(cli!=null) {
						
						System.out.println("----Tipo de libro para comprar:");
						String menuLibros = "----Seleccione una opción:----\n"
								+ "[1] Digital\n"
								+ "[2] Impreso\n";
						System.out.println(menuLibros);
						//Leer opcion de libro a comprar
						int opcMenuLibros = validaNumeroIntRango(1, 3);
						
						switch (opcMenuLibros) {
						case 1:
							if(cLibro.sizeLibrosDigitales()!=0) {
								System.out.println("Seleccione un libro a comprar");
								System.out.println(cLibro.listarLibroDigital());
								int eleccionLibro = validaNumeroIntRango(1, cLibro.sizeLibrosDigitales());
								LibroDigital libroCompradoDigital = cLibro.obtenerLibroDigital(eleccionLibro-1);
								DetalleCompra detalleCompra = new DetalleCompra();
									
								System.out.println("----Ingrese la cantidad de compra");
								int cantidad = validaNumeroInt();
									
								detalleCompra.setNumeroDetalle(1);
								detalleCompra.setLibro(libroCompradoDigital);
								detalleCompra.setCantidad(cantidad);
								detalleCompra.setPrecioTotal(cantidad*libroCompradoDigital.calcularCostoFinal());
								
								SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
							    Calendar calendar = Calendar.getInstance();
							    Date dateObj = calendar.getTime();
								Date fecha = calendar.getTime();
								
								if(cli.getCredito().getCupo()>detalleCompra.getPrecioTotal()) {
									cli.getCredito().setCupo(cli.getCredito().getCupo()-detalleCompra.getPrecioTotal());
									//controladorPersona.actualizarCliente(cli);
									controladorCompras.agregarCompra(numFactura, fecha, cli, detalleCompra);
									System.out.println("*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*");
									System.out.println("\t Compra Realizada Exitosamente");
									System.out.println("*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*");
								}else{
									System.out.println("///////////////////////////////////////////");
									System.out.println("        Saldo insuficiente - Recarge!!");
									System.out.println("///////////////////////////////////////////");
								}
								
							}else {
								System.out.println("///////////////////////////////////////////");
								System.out.println("        No existen libros a vender!!");
								System.out.println("///////////////////////////////////////////");
							}
							;break;
						case 2:
							if(cLibro.sizeLibrosImpresos() !=0) {
								System.out.println("Seleccione un libro a comprar");
								System.out.println(cLibro.listarLibroImpreso());
								int eleccionLibro = validaNumeroIntRango(1, cLibro.sizeLibrosImpresos());
								LibroImpreso libroCompradoImpreso = cLibro.obtenerLibroImpreso(eleccionLibro-1);
								DetalleCompra detalleCompra = new DetalleCompra();
									
								System.out.println("----Ingrese la cantidad de compra");
								int cantidad = validaNumeroInt();
									
								detalleCompra.setNumeroDetalle(1);
								detalleCompra.setLibro(libroCompradoImpreso);
								detalleCompra.setCantidad(cantidad);
								detalleCompra.setPrecioTotal(cantidad*libroCompradoImpreso.calcularCostoFinal());
								
								SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
							    Calendar calendar = Calendar.getInstance();
							    Date dateObj = calendar.getTime();
								Date fecha = calendar.getTime();
								
								if(cli.getCredito().getCupo()>detalleCompra.getPrecioTotal()) {
									cli.getCredito().setCupo(cli.getCredito().getCupo()-detalleCompra.getPrecioTotal());
									controladorPersona.actualizarCliente(cli);
									controladorCompras.agregarCompra(numFactura, fecha, cli, detalleCompra);
									System.out.println("*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*");
									System.out.println("\t Compra Realizada Exitosamente");
									System.out.println("*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*");
								}else{
									System.out.println("///////////////////////////////////////////");
									System.out.println("        Saldo insuficiente - Recarge!!");
									System.out.println("///////////////////////////////////////////");
								}
								
							}else {
								System.out.println("///////////////////////////////////////////");
								System.out.println("        No existen libros a vender!!");
								System.out.println("///////////////////////////////////////////");
							}					
							;break;
						}
						
						numFactura++;
					}else {
						System.out.println("///////////////////////////////////////////");
						System.out.println("        El cliente no registrado!!");
						System.out.println("///////////////////////////////////////////");
					}
					;break;
				case 2:
					
					if(controladorCompras.sizeCompras()>0) {
						System.out.println("********************************************");
						System.out.println("          Listar Compra por Cliente");
						System.out.println("********************************************");
						System.out.println("----Ingrese Cedula Cliente:");
						String cedulaClien = entrada.nextLine();
						System.out.println(controladorCompras.listarCompras(cedulaClien));
					}else {
						System.out.println("///////////////////////////////////////////");
						System.out.println("        El ventas no registradas!!");
						System.out.println("///////////////////////////////////////////");
					}
					;break;
				}
				
				;break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("Realizado: \n"
						+ "Tracy Cardenas \n"
						+ "David Paguay \n"
						+ "Jorge Pizarro \n"
						+ "Universidad Politecnica Salesiana - Derechos reservados :v");
				System.out.println("*********************************************");
				bandera = true;
				;break;
			}

			
		}while(bandera==false);
		
	}
	
	public static double validaNumeroDouble() {
		boolean bandera = false;
		do {
			try {
				String dato = entrada.nextLine();
				double n = Double.parseDouble(dato);
				return n;
			}catch(Exception e) {
				System.out.println("///////////////////////////////////////////");
				System.out.println("  El valor ingresado debe ser númerico");
				System.out.println("///////////////////////////////////////////");
			}
		}while(bandera==false);
		
		return 0;
	}
	
	public static int validaNumeroInt() {
		boolean bandera = false;
		do {
			try {
				String dato = entrada.nextLine();
				int n = Integer.parseInt(dato);
				bandera = true;
				return n;
			}catch(Exception e) {
				System.out.println("///////////////////////////////////////////");
				System.out.println("  El valor ingresado debe ser entero");
				System.out.println("///////////////////////////////////////////");
			}
		}while(bandera==false);
		
		return 0;
	}
	
	public static int validaNumeroIntRango(int a, int b) {
		boolean bandera = false;
		int n = 0 ;
		do {
			try {
				String dato = entrada.nextLine();
				n = Integer.parseInt(dato);
				
				if(n<a || n>b) {
					System.out.println("///////////////////////////////////////////");
					System.out.println("  Por favor escoja un número entre "+a+" al "+ b);
					System.out.println("///////////////////////////////////////////");
				}else {
					bandera = true;
				}
			}catch(Exception e) {
				System.out.println("///////////////////////////////////////////");
				System.out.println("  El valor ingresado debe ser entero");
				System.out.println("///////////////////////////////////////////");
			}
		}while(bandera==false);
		
		return n;
	}
	
	public static Date validaFecha() {
		boolean bandera = false;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		do {
			String dato = entrada.nextLine();
			try {
				fecha= formatoFecha.parse(dato);
				bandera = true;
			}catch(Exception e) {
				System.out.println("///////////////////////////////////////////");
				System.out.println("  Ingrese fecha en formato yyyy-MM-dd");
				System.out.println("                    Ejemplo 1992-01-16");
				System.out.println("///////////////////////////////////////////");
			}
		}while(bandera==false);
		
		return fecha;
	}

}
