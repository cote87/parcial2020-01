package isi.died2020.parcial01.ejercicio01.dominio;

public class Recibo {
	private Integer numero;
	private Integer mes;
	private Double monto;
	private Empleado empleado;
	
	public Recibo(Integer numero, Integer mes, Double monto, Empleado empleado) {
		super();
		this.numero = numero;
		this.mes = mes;
		this.monto = monto;
		this.empleado = empleado;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
