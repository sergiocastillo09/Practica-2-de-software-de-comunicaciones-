/* Software de Comunicaciones - Prácticas de la asignatura
 * DTE, ETSIST, UPM
 * Curso 2026/2027
 * Práctica 1
 * Archivo: OperacionesCalculadora.java
 */

package calculadora;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/** Esta clase contiene la implementación final de cada operación disponible en la calculadora.
 * Debe contener un método público de instancia por cada método de la interfaz {@link CalculadoraGUI.ICalculadora}.
 * Para evitar confusiones, se recomienda que cada uno de los métodos citados anteponga 'implementacion' al
 * nombre del método de {@link CalculadoraGUI.ICalculadora}. Por ejemplo: si se desea crear el método que implementa
 * la suma, su nombre en esta clase será 'implementacionSumar'.
 */
public class OperacionesCalculadora {

	// Realizar aquí la implementación de los métodos correspondientes a cada
	// operación de la calculadora, siguiendo las indicaciones del enunciado.
	private double memoria ;
    private double ultimoResultado;
    
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReadLock readLock = lock.readLock();
    private final WriteLock writeLock = lock.writeLock();
	
	
	public OperacionesCalculadora() {
		 memoria = 0;
		 ultimoResultado = 0;
		
	}
	
	
	
	public double implementacionSumar(double operando1, double operando2) {
		writeLock.lock();
		try {
			return ultimoResultado = operando1 + operando2;
		}finally {
			writeLock.unlock();
		}	
	}
	
	
	
	
    public double implementacionRestar(double operando1, double operando2) {
    	
    	writeLock.lock();
		try {
			return ultimoResultado = operando1-operando2;
		}finally {
			writeLock.unlock();
		}	
	}
    
    
    
     
    public double implementacionMultiplicar(double operando1, double operando2) {
    	writeLock.lock();
		try {
			return ultimoResultado = operando1*operando2;
		}finally {
			writeLock.unlock();
		}
    	
    }
    
    
    
    
    public double implementacionDividir(double operando1, double operando2) {
    	writeLock.lock();
		try {
			if ( operando2 == 0) {
	    		
	    		 throw new IllegalArgumentException("Indeterminacion");
	    		
	    	}else {
	    		return ultimoResultado = operando1/operando2;
	    	}
		}finally {
			writeLock.unlock();
		}
     }
    
    
    
    
    public double  implementacionUR() {
    	readLock.lock();
    	try {
    		return ultimoResultado;
    	}finally {
    		readLock.unlock();
    	}
    }
    
    
    

    
    public void implementacionML() {
    	
    	writeLock.lock();
		try {
			memoria = 0;
		}finally {
			writeLock.unlock();
		}
    }
    
    
    
    
    public void implementacionMA() {
    	writeLock.lock();
		try {
			memoria = memoria + ultimoResultado;
		}finally {
			writeLock.unlock();
		}
    	
    }
    
    
    
    
    public double  implementacionMO() {
    	readLock.lock();
    	try {
    		return memoria;
    	}finally {
    		readLock.unlock();
    	}
    }
    
    
    
    
   public double implementacionRaizCuadrada(double operando){  
	   writeLock.lock();
		try {
			 if ( operando <  0) {
			   		
		  		 throw new IllegalArgumentException("Indeterminacion");
		  		
		  	}else {
		  		
		  		return ultimoResultado = Math.sqrt(operando);
		  	}
		}finally {
			writeLock.unlock();
		}
    }
   
   
   

}
