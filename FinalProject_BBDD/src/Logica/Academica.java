package Logica;

import java.util.ArrayList;

public class Academica {
	
	private ArrayList <Estudiante> misEstudiantes;
	private ArrayList <Asignatura> misAsignaturas;
	private ArrayList <Grupo> misGrupos;
	private ArrayList <GrupoHorario> misGruposHorarios;
	private ArrayList <Inscripcion> misInscripciones; 
	private ArrayList <periodoAcademico> misPeriodos; 
	
	private static Academica miAcademica;

	public Academica() {
		misEstudiantes = new ArrayList<Estudiante>();
		misAsignaturas = new ArrayList<Asignatura>();
		misGrupos = new ArrayList<Grupo>();
		misGruposHorarios = new ArrayList<GrupoHorario>();
		misInscripciones = new ArrayList<Inscripcion>();
		misPeriodos = new ArrayList<periodoAcademico>();
	} 
	
	
	
	public ArrayList<Estudiante> getMisEstudiantes() {
		return misEstudiantes;
	}



	public ArrayList<Asignatura> getMisAsignaturas() {
		return misAsignaturas;
	}



	public ArrayList<Grupo> getMisGrupos() {
		return misGrupos;
	}



	public ArrayList<GrupoHorario> getMisGruposHorarios() {
		return misGruposHorarios;
	}

	
	public ArrayList<Inscripcion> getMisInscripciones() {
		return misInscripciones;
	}



	public ArrayList<periodoAcademico> getMisPeriodos() {
		return misPeriodos;
	}



	public static Academica getMiAcademica() {
		return miAcademica;
	}



	public void setMisEstudiantes(ArrayList<Estudiante> misEstudiantes) {
		this.misEstudiantes = misEstudiantes;
	}



	public void setMisAsignaturas(ArrayList<Asignatura> misAsignaturas) {
		this.misAsignaturas = misAsignaturas;
	}



	public void setMisGrupos(ArrayList<Grupo> misGrupos) {
		this.misGrupos = misGrupos;
	}



	public void setMisGruposHorarios(ArrayList<GrupoHorario> misGruposHorarios) {
		this.misGruposHorarios = misGruposHorarios;
	}



	public void setMisInscripciones(ArrayList<Inscripcion> misInscripciones) {
		this.misInscripciones = misInscripciones;
	}



	public void setMisPeriodos(ArrayList<periodoAcademico> misPeriodos) {
		this.misPeriodos = misPeriodos;
	}



	public static void setMiAcademica(Academica miAcademica) {
		Academica.miAcademica = miAcademica;
	}



		//Metodos para insertar
		public void insertEstudiante(Estudiante auxEstudiante) {  
			getMisEstudiantes().add(auxEstudiante);  
		}
		
		public void insertAsignatura(Asignatura auxAsignatura) {  
			getMisAsignaturas().add(auxAsignatura);  
		}
		public void insertGrupo(Grupo auxGrupo) {  
			getMisGrupos().add(auxGrupo);  
		}
		
		public void insertGrupoHorario(GrupoHorario auxGrupoHorario) {  
			getMisGruposHorarios().add(auxGrupoHorario);  
		}
		public void insertInscripciones(Inscripcion auxInscripciones) {  
			getMisInscripciones().add(auxInscripciones);  
		}
		
		public void insertPerAcademico(periodoAcademico auxPerAcad) {  
			getMisPeriodos().add(auxPerAcad);  
		}
		
	
	

}
