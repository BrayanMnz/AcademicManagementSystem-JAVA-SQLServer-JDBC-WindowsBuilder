package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
	

public static void InsertarInscripcion (
		String perAcad,
		String codAsig,
		String numGrupo,
		String matricula
		)     
		{
			
			Connection conn = null;
			 
		    try {

		        String dbURL = "jdbc:sqlserver://MUÑOZV";
		        String user = "Brayan";
		        String pass = "12345";
		        conn = DriverManager.getConnection(dbURL, user, pass);
		        if (conn != null) {
		            System.out.println("Conexion establecida ");
		        			      }

		        try (Statement stmt = conn.createStatement()) {
		        	
		       
		            String sqlQuery = " INSERT INTO Inscripcion ([Cod PeriodoAcad],Matricula,[Cod Asignatura],NumGrupo)"
		                    + " VALUES(?, ?, ?, ?)";
		            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
		            prepStmt.setString(1, perAcad); 
		            prepStmt.setString(2, matricula);
		            prepStmt.setString(3, codAsig); 
		            prepStmt.setString(4, numGrupo);
		         
		        
		            prepStmt.executeUpdate();
		            prepStmt.close();
		        	
		        } catch (SQLException e) {
		          e.printStackTrace();
		        }        

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } finally {
		        try {
		            if (conn != null && !conn.isClosed()) {
		                conn.close();
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
			 }
	
	
//============================================================================		
public static void DeleteInscripcion (String Periodo, String Asignatura, String Grupo, String Matricula ) {
	
	
	
	
		  String dbURL = "jdbc:sqlserver://MUÑOZV";
	      String user = "Brayan";
	      String pass = "12345";
	      
	      
	      String sql = "DELETE FROM Inscripcion WHERE Matricula = ? AND [Cod PeriodoAcad] = ? AND [Cod Asignatura] = ? AND NumGrupo = ?";
	
	      try (Connection conn = DriverManager.getConnection(dbURL, user, pass); 
	    		  PreparedStatement stmt = conn.prepareStatement(sql)) {
	  
				stmt.setString(1, Matricula);
				stmt.setString(2, Periodo);
				stmt.setString(3, Asignatura);
				stmt.setString(4, Grupo);
				stmt.executeUpdate();
	  
				System.out.println("Se elimino correctamente!! ");
				} catch (SQLException e) {
				  e.printStackTrace();
				}
																 }
//=================================================================================================
	
}

