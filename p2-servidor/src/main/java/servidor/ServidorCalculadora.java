/* Software de Comunicaciones - Prácticas de la asignatura

 * DTE, ETSIST, UPM
 * Curso 2026/2027
 * Práctica 1, fases 2 y 3
 * Archivo: ServidorCalculadora.java
 */

/* 
 * PREGUNTA 1: ¿Qué ocurre cuando el segundo cliente intenta solicitar operaciones remotas?
 * Respuesta: El servidor atiende la solicitud del segundo cliente de manera simultánea y concurrente 
 * con el primero, procesando la operación y devolviendo el resultado correcto a su interfaz gráfica 
 * sin que ninguna de las dos instancias de cliente sufra bloqueos o interferencias.
 *
 * PREGUNTA 2: ¿Por qué ocurre eso?
 * Respuesta: Esto ocurre gracias a la arquitectura multiproceso y multihilo del modelo de transporte 
 * subyacente de gRPC (basado en Netty), el cual gestiona un pool de hilos capaz de aceptar conexiones 
 * y despachar llamadas a métodos remotos de forma asíncrona e independiente para cada canal de cliente 
 * establecido.
 */

package servidor;


import java.rmi.AlreadyBoundException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



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
		
		 Registry registry = LocateRegistry.createRegistry(1099);
		 registry.rebind("Calculadora", operaciones);
		 
		 System.out.println("Servidor RMI iniciado correctamente en el puerto 1099.");
		 System.out.println(operaciones.toString());
	
		 }catch(RemoteException e) {
			 System.err.println(e.getMessage());
			 e.printStackTrace();
			 
		 }
	      
	   }
}