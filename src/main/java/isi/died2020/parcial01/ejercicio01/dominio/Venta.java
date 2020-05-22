package isi.died2020.parcial01.ejercicio01.dominio;

import java.time.LocalDate;

public class Venta {
	private Integer numeroVenta;
	private LocalDate fechaVenta;
	private Double monto;
	private CondicionDeVenta condicionDeVenta;
	
	public enum CondicionDeVenta{
		VENDER,ATENDER,REFERIR
	}
	
	public Venta(Integer numeroVenta, LocalDate fechaVenta, Double monto,CondicionDeVenta condicionDeVenta) {
		super();
		this.numeroVenta = numeroVenta;
		this.fechaVenta = fechaVenta;
		this.monto = monto;
		this.condicionDeVenta=condicionDeVenta;
	}
	public Integer getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(Integer numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
}
