package Logica;

public class main {

	public static void main(String[] args) {

		Estudiante Darianny = new Estudiante("20170771", "Darianny", null, "Escoboza", "Namias", "ITT", "Contado", "DOM", null);
		Asignatura Elaboracion = new Asignatura("ITT361P", "Elaboracion de Proyectos", 4, 3, 1);
		
		Asignatura.InsertarAsignatura(Elaboracion.getCodAsignatura(), Elaboracion.getNombreAsignatura(), Elaboracion.getCreditos(),
				Elaboracion.getHorasTeoricas(), Elaboracion.getHorasPracticas());
		
	}

}
