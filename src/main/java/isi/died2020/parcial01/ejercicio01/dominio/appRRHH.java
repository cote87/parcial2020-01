package isi.died2020.parcial01.ejercicio01.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class appRRHH {
		
	public List<Recibo> generarRecibos(Integer numero,ArrayList<Empleado> empleados, Integer mes) {		
		return empleados
				.stream()
				.map(e -> new Recibo(numero, mes, e.sueldo(mes) ,e) ).collect(Collectors.toList());
	}

}
