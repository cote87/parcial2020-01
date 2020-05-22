package isi.died2020.parcial01.ejercicio01.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmpleadoEnConvenio extends Empleado {
	private Integer antiguedad;
	private Double sueldoBase;

	public EmpleadoEnConvenio(Integer cuil, String nombre, String email, LocalDate fechaDeNacimiento) {
		super(cuil, nombre, email, fechaDeNacimiento);
		antiguedad = 0;
	}

	@Override
	public Double sueldo(Integer mes) {
		Double sueldoFinal = sueldoBase;
		for(Venta v : this.getVentas().stream().filter(v -> v.getFechaVenta().getMonthValue() == mes).collect(Collectors.toList())) {
			sueldoFinal = sueldoFinal + (v.getMonto()*0.15);
		}
		if(this.getFechaDeNacimiento().getMonthValue() == mes) {
			sueldoFinal = sueldoFinal + this.getBonoCumpleaños();
		}
		return sueldoFinal;
	}
}
