package Logica;

public class Grupo {

	private String codPeriodoAcademico;
	private String codAsignatura;
	private String numGrupo; 
	
	private int cupoGrupo;
	private String horario;
	
	public Grupo(String codPeriodoAcademico, String codAsignatura, String numGrupo, int cupoGrupo) {
		super();
		this.codPeriodoAcademico = codPeriodoAcademico;
		this.codAsignatura = codAsignatura;
		this.numGrupo = numGrupo;
		this.cupoGrupo = cupoGrupo;
	}

	public String getCodPeriodoAcademico() {
		return codPeriodoAcademico;
	}

	public String getCodAsignatura() {
		return codAsignatura;
	}

	public String getNumGrupo() {
		return numGrupo;
	}

	public int getCupoGrupo() {
		return cupoGrupo;
	}

	public String getHorario() {
		return horario;
	}

	public void setCodPeriodoAcademico(String codPeriodoAcademico) {
		this.codPeriodoAcademico = codPeriodoAcademico;
	}

	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public void setNumGrupo(String numGrupo) {
		this.numGrupo = numGrupo;
	}

	public void setCupoGrupo(int cupoGrupo) {
		this.cupoGrupo = cupoGrupo;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
