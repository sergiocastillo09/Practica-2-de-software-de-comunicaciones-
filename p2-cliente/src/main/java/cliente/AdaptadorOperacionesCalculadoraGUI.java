/* Software de Comunicaciones - Prácticas de la asignatura
 * DTE, ETSIST, UPM
 * Curso 2026/2027
 * Práctica 1, fase 2
 * Archivo: AdaptadorOperacionesCalculadoraGUI.java
 */

package cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import calculadoraGUI.ICalculadora;
import rmiCalculadora.CalculadoraExcepcion;
import rmiCalculadora.ICalculadoraRMI;


/**
 * Esta clase sirve para adaptar el stub cliente de gRPC generado a partir del fichero .proto de la calculadora
 * a la interfaz de {@link calculadoraGUI.ICalculadora}.
 * Se debe decidir qué tipo de adaptador (clase u objeto) es conveniente/posible.
 *
 * @see calculadoraGUI.ICalculadora
 */
class AdaptadorOperacionesCalculadoraGUI implements ICalculadora {
	
	private Registry registry;
	private ICalculadoraRMI stubCliente;
	
	public AdaptadorOperacionesCalculadoraGUI() {
		try {
			this.registry = LocateRegistry.getRegistry("Localhost");
			this.stubCliente = (ICalculadoraRMI) registry.lookup("Calculadora");
			
		}catch(RemoteException | NotBoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	
	public double sumar(double operando1, double operando2) {
		try {
			return stubCliente.sumar(operando1, operando2);
			
			
		}catch(Exception e) {
			System.err.println("Error en sumar: " + e.getMessage());
		}
		
		return 0;
		
	}
	
	
	
	
	public double restar(double operando1, double operando2) {
		try {
			return stubCliente.restar(operando1, operando2);
			
			
		}catch(Exception e) {
			System.err.println("Error en restar: " + e.getMessage());
		}
		
		return 0;
	 
	}
	
	
	
	
	public double multiplicar(double operando1, double operando2) {
		try {
			return stubCliente.multiplicar(operando1, operando2);
			
			
		}catch(Exception e) {
			System.err.println("Error en multiplicar: " + e.getMessage());
		}
		
		return 0;
	 
	}
	
	
	
	public double dividir(double operando1, double operando2) {
		try {
			return stubCliente.dividir(operando1, operando2);
			
			
		}catch(CalculadoraExcepcion e) {
			System.err.println("Error en calculadora: " + e.getMessage());
		}catch(Exception e) {
			System.err.println("Error en dividir: " + e.getMessage());
		}
		
		return 0;
	  
	}
	
	
	
	
	public double raizCuadrada(double operando) {
		try {
			return stubCliente.raizCuadrada(operando);
			
			
		}catch(CalculadoraExcepcion e) {
			System.err.println("Error en calculadora: " + e.getMessage());
		}catch(Exception e) {
			System.err.println("Error en dividir: " + e.getMessage());
		}
		
		return 0;
	
	  
	}
	
	public double obtenerUltimoResultado() {
	
		try {
			return stubCliente.obtenerUltimoResultado();
			
			
		}catch(Exception e) {
			System.err.println("Error en dividir: " + e.getMessage());
		}
		
		return 0;
	}
	
	public void memoriaLimpiar() {
		
		try {
			stubCliente.memoriaLimpiar();
			
		}catch(Exception e) {
			System.err.println("Error en dividir: " + e.getMessage());
		}
		
	}
	
	public void memoriaAniadir() {
		try {
			stubCliente.memoriaAniadir();
			
		}catch(Exception e) {
			System.err.println("Error en dividir: " + e.getMessage());
		
		}
	}
	
	public double memoriaObtener() {
		try {
			return stubCliente.memoriaObtener();
			
			
		}catch(Exception e) {
			System.err.println("Error en dividir: " + e.getMessage());
		}
		
		return 0;
	}
		
	}
	
	
	
	

	
	

	


