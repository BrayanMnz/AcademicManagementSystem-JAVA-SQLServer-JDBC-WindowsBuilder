package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	//=================================================================================================

	public static void InsertarGrupoHorario (
			String perAcad,
			String codAsig,
			String numGrupo,
			int dia,
			java.sql.Time horaInicial,
			java.sql.Time horaFinal)     
			{
				
					String perAcad_ = perAcad;
					String codAsig_ = codAsig;
					String numGrupo_ = numGrupo;
					int dia_ = dia;
					java.sql.Time hrInicial = horaInicial;
					java.sql.Time hrFinal = horaFinal;
									
				
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
			        	
			       
			            String sqlQuery = " INSERT INTO GrupoHorario (CodPeriodoAcad,CodAsignatura,NumGrupo,Dia,HoraInicial, HoraFinal)"
			                    + " VALUES(?, ?, ?, ?, ?, ?)";
			            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
			            prepStmt.setString(1, perAcad_); 
			            prepStmt.setString(2, codAsig_);
			            prepStmt.setString(3, numGrupo_); 
			            prepStmt.setInt(4, dia_);
			            prepStmt.setTime(5, hrInicial); 
			            prepStmt.setTime(6, hrFinal); 
				           
			        
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
	public static void UpdateGrupoHorario (
			String perAcad,
			String codAsig,
			String numGrupo,
			int dia,
			java.sql.Time horaInicial,
			java.sql.Time horaFinal) 
			{
				
				String perAcad_ = perAcad;
				String codAsig_ = codAsig;
				String numGrupo_ = numGrupo;
				int dia_ = dia;
				java.sql.Time hrInicial = horaInicial;
				java.sql.Time hrFinal = horaFinal;
								
				
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
			        	

			            PreparedStatement prepStmt = conn.prepareStatement(
			            		"UPDATE GrupoHorario SET dia = ?,HoraInicial = ?, HoraFinal = ? WHERE  CodPeriodoAcad = ? AND CodAsignatura= ? AND NumGrupo = ?");

			            prepStmt.setString(4, perAcad_); 
			            prepStmt.setString(5, codAsig_);
			            prepStmt.setString(6, numGrupo_); 
			            prepStmt.setInt(1, dia_);
			            prepStmt.setTime(2, hrInicial); 
			            prepStmt.setTime(3, hrFinal); 
			            
			            
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
			public static void DeleteGrupoHorario (String PKperAcad,
					String PKcodAsig, 
					String PKnumGrupo) {
				
				String perAcad = PKperAcad;
				String codAsig = PKcodAsig; 
				String numGrupo = PKnumGrupo;
				
				
					  String dbURL = "jdbc:sqlserver://MUÑOZV";
				      String user = "Brayan";
				      String pass = "12345";
				      
				      
				      String sql = "DELETE FROM GrupoHorario WHERE CodAsignatura = ? AND CodPeriodoAcad = ? AND NumGrupo = ?";
				
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
	//=================================================================================================	
			}
