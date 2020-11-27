package Logica;

public class Asignatura {
	
	private String codAsignatura;
	private String nombreAsignatura;
	private int creditos;
	private int horasTeoricas;
	private int horasPracticas;
	public Asignatura(String codAsignatura, String nombreAsignatura, int creditos, int horasTeoricas,
			int horasPracticas) {
		super();
		this.codAsignatura = codAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.creditos = creditos;
		this.horasTeoricas = horasTeoricas;
		this.horasPracticas = horasPracticas;
	}
	public String getCodAsignatura() {
		return codAsignatura;
	}
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}
	public int getCreditos() {
		return creditos;
	}
	public int getHorasTeoricas() {
		return horasTeoricas;
	}
	public int getHorasPracticas() {
		return horasPracticas;
	}
	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public void setHorasTeoricas(int horasTeoricas) {
		this.horasTeoricas = horasTeoricas;
	}
	public void setHorasPracticas(int horasPracticas) {
		this.horasPracticas = horasPracticas;
	}
}
