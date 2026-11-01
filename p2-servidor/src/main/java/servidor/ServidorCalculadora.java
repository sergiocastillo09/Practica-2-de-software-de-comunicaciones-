/* Software de Comunicaciones - Prácticas de la asignatura

 * DTE, ETSIST, UPM
 * Curso 2026/2027
 * Práctica 1, fases 2 y 3
 * Archivo: ServidorCalculadora.java
 */


package servidor;


import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 * PREGUNTAS 1 y 2:
 * 
 * ¿Qué observa si en un cliente realiza una operación y en otro cliente simultáneo se solicita visualizar el último resultado?
 * Se observa que el segundo cliente visualiza el resultado de la operación realizada por el primer cliente, 
 * ya que el estado del último resultado se comparte de manera global entre todos los clientes conectados.
 * 
 * ¿Por qué ocurre eso?
 * Ocurre porque el objeto remoto (servidor) se instancia una única vez en el servidor RMI. Todas las peticiones 
 * de los diferentes clientes concurren sobre esa misma instancia única y comparten los mismos atributos de clase en memoria.
 */


/**
 * Clase principal para el servidor  de la calculadora de la práctica 2.
 * <p>
 * 
 * @author DMC, DTE, Software de Comunicaciones 2026/2027
 * @version 2.0.0
 */
public class ServidorCalculadora {

	/** Este es el método inicial del servidor.
	 */
	 public static void main(String[] args) throws AlreadyBoundException{
		 try {
		 AdaptadorOperacionesCalculadoraRMI	operaciones = new AdaptadorOperacionesCalculadoraRMI();
		
		 Remote remoteStub = UnicastRemoteObject.exportObject(operaciones, 0);
		 
		 Registry registry = LocateRegistry.createRegistry(1099);
		 registry.rebind("Calculadora", remoteStub);
		 
		 System.out.println("Servidor RMI iniciado correctamente en el puerto 1099.");
		 System.out.println("Objeto publicado: " + remoteStub.toString());
	
		 }catch(Exception e) {
			 System.err.println(e.getMessage());
			 e.printStackTrace();
			 
		 }
	      
	   }
}