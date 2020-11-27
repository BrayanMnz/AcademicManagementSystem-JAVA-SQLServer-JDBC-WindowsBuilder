package Logica;

public class Inscripcion {

	private String codPeriodoAcad;
	private String  Matricula;
	private String codAsignatura;
	private String numGrupo;
	
	public Inscripcion(String codPeriodoAcad, String matricula, String codAsignatura, String numGrupo) {
		this.setCodPeriodoAcad(codPeriodoAcad);
		setMatricula(matricula);
		this.setCodAsignatura(codAsignatura);
		this.setNumGrupo(numGrupo);
	}

	public String getCodPeriodoAcad() {
		return codPeriodoAcad;
	}

	public void setCodPeriodoAcad(String codPeriodoAcad) {
		this.codPeriodoAcad = codPeriodoAcad;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public String getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public String getNumGrupo() {
		return numGrupo;
	}

	public void setNumGrupo(String numGrupo) {
		this.numGrupo = numGrupo;
	}
}

