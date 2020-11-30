package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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

//=================================================================================================
	public static void InsertarGrupo (
			String perAcad,
			String codAsig,
			String numGrupo,
			int cupoGrupo,
			String horario)     
			{
				
					String perAcad_ = perAcad;
					String codAsig_ = codAsig;
					String numGrupo_ = numGrupo; 
					int    cupoGrupo_ = cupoGrupo;
					String Horario_ = horario; 
						
				
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
			        	
			       
			            String sqlQuery = " INSERT INTO Grupo (CodPeriodoAcad,[Cod Asignatura ],NumGrupo,CupoGrupo,Horario)"
			                    + " VALUES(?, ?, ?, ?, ?)";
			            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
			            prepStmt.setString(1, perAcad_); 
			            prepStmt.setString(2, codAsig_);
			            prepStmt.setString(3, numGrupo_); 
			            prepStmt.setInt(4, cupoGrupo_);
			            prepStmt.setString(5, Horario_); 
			           
			        
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
//=================================================================================================
	public static void UpdateGrupo (
			String PKperAcad,
			String PKcodAsig, 
			String PKnumGrupo,
			int cupoGrupo, 
			String horario) 
			{
				
			String perAcad_ = PKperAcad;
			String codAsig_ = PKcodAsig;
			String numGrupo_ = PKnumGrupo; 
			int    cupoGrupo_ = cupoGrupo;
			String Horario_ = horario; 
				
				
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
			        	

			            PreparedStatement ps = conn.prepareStatement(
			            		"UPDATE Grupo SET CupoGrupo = ?,Horario = ? WHERE  CodPeriodoAcad = ? AND [Cod Asignatura ] = ? AND NumGrupo = ?");

			            ps.setString(3,perAcad_);
			            ps.setString(4,codAsig_);
			            ps.setString(5,numGrupo_);
			            ps.setInt(1,cupoGrupo_);
			            ps.setString(2, Horario_);

			            ps.executeUpdate();
			            ps.close();
			            
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
//=================================================================================================	
			public static void DeleteGrupo (String PKperAcad,
					String PKcodAsig, 
					String PKnumGrupo) {
				
				String perAcad = PKperAcad;
				String codAsig = PKcodAsig; 
				String numGrupo = PKnumGrupo;
				
				
					  String dbURL = "jdbc:sqlserver://MUÑOZV";
				      String user = "Brayan";
				      String pass = "12345";
				      
				      
				      String sql = "DELETE FROM Grupo WHERE [Cod Asignatura] = ? AND CodPeriodoAcad = ? AND NumGrupo = ?";
				
				      try (Connection conn = DriverManager.getConnection(dbURL, user, pass); 
				    		  PreparedStatement stmt = conn.prepareStatement(sql)) {
				  
							stmt.setString(1, codAsig);
							stmt.setString(2, perAcad);
							stmt.setString(3, numGrupo);
					
							stmt.executeUpdate();
				  
							System.out.println("Se elimino correctamente!! ");
							} catch (SQLException e) {
							  e.printStackTrace();
							}
																			 }		

	//============================================================================		
}
