package rmiCalculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadoraRMI extends Remote {
  double sumar(double operando1, double operando2) throws RemoteException;
  double restar(double operando1, double operando2) throws RemoteException;
  double multiplicar(double operando1, double operando2) throws RemoteException;
  double dividir(double operando1, double operando2) throws RemoteException, CalculadoraExcepcion;
  void obtenerUltimoResultado() throws RemoteException;
  void memoriaLimpiar() throws RemoteException;
  void memoriaAniadir() throws RemoteException;
  void memoriaObtener() throws RemoteException;
  double raizCuadrada(double operando1, double operando2) throws RemoteException, CalculadoraExcepcion;
  
  
}
