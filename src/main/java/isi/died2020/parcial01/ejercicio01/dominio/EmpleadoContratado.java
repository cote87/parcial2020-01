package isi.died2020.parcial01.ejercicio01.dominio;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class EmpleadoContratado extends Empleado {
	private Double costoHora;
	private Integer horasTrabajadas;

	public EmpleadoContratado(Integer cuil, String nombre, String email, LocalDate fechaDeNacimiento) {
		super(cuil, nombre, email, fechaDeNacimiento);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public Double sueldo(Integer mes) {
		Double sueldoFinal = this.getHorasTrabajadas() * this.getCostoHora();
		for(Venta v : this.getVentas().stream().filter(v -> v.getFechaVenta().getMonthValue() == mes && v.getMonto()>10.000).collect(Collectors.toList())) {
			sueldoFinal = sueldoFinal + (this.costoHora*10);
		}
		if(this.getFechaDeNacimiento().getMonthValue() == mes) {
			sueldoFinal = sueldoFinal + this.getBonoCumpleaños();
		}
		return sueldoFinal;
	}

	public Double getCostoHora() {
		return costoHora;
	}

	public void setCostoHora(Double costoHora) {
		this.costoHora = costoHora;
	}

	public Integer getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	

}
