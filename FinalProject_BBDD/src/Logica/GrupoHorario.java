package Logica;

import java.sql.Time;

public class GrupoHorario {
	
	private String codPeriodoAcad;
	private String codAsignatura;
	private String numGrupo;
	private int dia;
	private java.sql.Time horaInicial;
	private java.sql.Time horaFinal;
	
	public GrupoHorario(String codPeriodoAcad, String codAsignatura, String numGrupo, int dia, Time horaInicial,
			Time horaFinal) {
		super();
		this.codPeriodoAcad = codPeriodoAcad;
		this.codAsignatura = codAsignatura;
		this.numGrupo = numGrupo;
		this.dia = dia;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}

	public String getCodPeriodoAcad() {
		return codPeriodoAcad;
	}

	public String getCodAsignatura() {
		return codAsignatura;
	}

	public String getNumGrupo() {
		return numGrupo;
	}

	public int getDia() {
		return dia;
	}

	public java.sql.Time getHoraInicial() {
		return horaInicial;
	}

	public java.sql.Time getHoraFinal() {
		return horaFinal;
	}

	public void setCodPeriodoAcad(String codPeriodoAcad) {
		this.codPeriodoAcad = codPeriodoAcad;
	}

	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public void setNumGrupo(String numGrupo) {
		this.numGrupo = numGrupo;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setHoraInicial(java.sql.Time horaInicial) {
		this.horaInicial = horaInicial;
	}

	public void setHoraFinal(java.sql.Time horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	

}
