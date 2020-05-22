package isi.died2020.parcial01.ejercicio02.db;

public class ErrorIngresandoDBException extends Exception {
	
	public ErrorIngresandoDBException() {
		super("No se puede conectar a la Base de Datos.");
	}

}
