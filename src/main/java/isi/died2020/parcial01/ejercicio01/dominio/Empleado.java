package isi.died2020.parcial01.ejercicio01.dominio;

import java.time.LocalDate;
import java.util.List;

public abstract class Empleado {
	private Integer cuil;
	private String nombre,email;
	private LocalDate fechaDeNacimiento;
	private static int bonoCumpleaños=20000;
	private List<Venta> ventas;
	
	public Empleado(Integer cuil, String nombre, String email, LocalDate fechaDeNacimiento) {
		super();
		this.cuil = cuil;
		this.nombre = nombre;
		this.email = email;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Integer getCuil() {
		return cuil;
	}
	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public static int getBonoCumpleaños() {
		return bonoCumpleaños;
	}
	
	public List<Venta> getVentas() {
		return ventas;
	}
	public void agregarVenta(Venta venta) {
		this.ventas.add(venta);
	}
	public abstract Double sueldo(Integer mes);
	
}
