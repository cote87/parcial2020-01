package isi.died2020.parcial01.ejercicio02.dominio;

public class NoSePuedeInscribirException extends Exception {
	public NoSePuedeInscribirException() {
		super("El alumno tiene examenes aprobados de materias correlativas");
	}
}
