package Logica;

import java.sql.Date;

public class periodoAcademico {
	
	private String codPeriodoAcad;
	private String descripcion; 
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;
	private java.sql.Date fechaInicioClases;
	private java.sql.Date fechaFinClases;
	private java.sql.Date fechaLimitePago;
	private java.sql.Date fechaLimitePrematricula;
	private java.sql.Date fechaLimiteRetiro;
	private java.sql.Date fechaLimitPublicacion;
	
	public periodoAcademico(String codPeriodoAcad, String descripcion, Date fechaInicio, Date fechaFin,
			Date fechaInicioClases, Date fechaFinClases, Date fechaLimitePago, Date fechaLimitePrematricula,
			Date fechaLimiteRetiro, Date fechaLimitPublicacion) {
		super();
		this.codPeriodoAcad = codPeriodoAcad;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaInicioClases = fechaInicioClases;
		this.fechaFinClases = fechaFinClases;
		this.fechaLimitePago = fechaLimitePago;
		this.fechaLimitePrematricula = fechaLimitePrematricula;
		this.fechaLimiteRetiro = fechaLimiteRetiro;
		this.fechaLimitPublicacion = fechaLimitPublicacion;
	}
	public String getCodPeriodoAcad() {
		return codPeriodoAcad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public java.sql.Date getFechaInicio() {
		return fechaInicio;
	}
	public java.sql.Date getFechaFin() {
		return fechaFin;
	}
	public java.sql.Date getFechaInicioClases() {
		return fechaInicioClases;
	}
	public java.sql.Date getFechaFinClases() {
		return fechaFinClases;
	}
	public java.sql.Date getFechaLimitePago() {
		return fechaLimitePago;
	}
	public java.sql.Date getFechaLimitePrematricula() {
		return fechaLimitePrematricula;
	}
	public java.sql.Date getFechaLimiteRetiro() {
		return fechaLimiteRetiro;
	}
	public java.sql.Date getFechaLimitPublicacion() {
		return fechaLimitPublicacion;
	}
	public void setCodPeriodoAcad(String codPeriodoAcad) {
		this.codPeriodoAcad = codPeriodoAcad;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setFechaInicio(java.sql.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin(java.sql.Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public void setFechaInicioClases(java.sql.Date fechaInicioClases) {
		this.fechaInicioClases = fechaInicioClases;
	}
	public void setFechaFinClases(java.sql.Date fechaFinClases) {
		this.fechaFinClases = fechaFinClases;
	}
	public void setFechaLimitePago(java.sql.Date fechaLimitePago) {
		this.fechaLimitePago = fechaLimitePago;
	}
	public void setFechaLimitePrematricula(java.sql.Date fechaLimitePrematricula) {
		this.fechaLimitePrematricula = fechaLimitePrematricula;
	}
	public void setFechaLimiteRetiro(java.sql.Date fechaLimiteRetiro) {
		this.fechaLimiteRetiro = fechaLimiteRetiro;
	}
	public void setFechaLimitPublicacion(java.sql.Date fechaLimitPublicacion) {
		this.fechaLimitPublicacion = fechaLimitPublicacion;
	}

}
