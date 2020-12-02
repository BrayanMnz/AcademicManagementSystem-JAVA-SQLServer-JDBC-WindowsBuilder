package Logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	//=================================================================================================

	public static void InsertarPerAcad (periodoAcademico auxPer)     
			{
			periodoAcademico aux = auxPer;
				
				
									
				
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
			        	
			       
			            String sqlQuery = "Insert into PeriodoAcademico ([Cod PeriodoAcad],Descripcion, FechaInicio, FechaFin, FechaInicioClases, FechaFinClases, FechaLimitePago, FechaLimitePrematricula,FechaLimiteRetiro,FechaLimitePublicacion)"
			                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
			            prepStmt.setString(1, aux.getCodPeriodoAcad()); 
			            prepStmt.setString(2, aux.getDescripcion());
			            prepStmt.setDate(3, aux.getFechaInicio()); 
			            prepStmt.setDate(4, aux.getFechaFin());
			            prepStmt.setDate(5, aux.getFechaInicioClases()); 
			            prepStmt.setDate(6, aux.getFechaFinClases()); 
			            prepStmt.setDate(7, aux.getFechaLimitePago()); 
			            prepStmt.setDate(8, aux.getFechaLimitePrematricula()); 
			            prepStmt.setDate(9, aux.getFechaLimiteRetiro()); 
			            prepStmt.setDate(10, aux.getFechaLimitPublicacion()); 
				           
			        
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
	
	//============================================================================		
	public static void DeletePeriodo (String PK_Periodo) {
		
		String periodo_ = PK_Periodo;
		
		
			  String dbURL = "jdbc:sqlserver://MUÑOZV";
		      String user = "Brayan";
		      String pass = "12345";
		      
		      
		      String sql = "DELETE FROM PeriodoAcademico WHERE [Cod PeriodoAcad] = ?";
		
		      try (Connection conn = DriverManager.getConnection(dbURL, user, pass); 
		    		  PreparedStatement stmt = conn.prepareStatement(sql)) {
		  
					stmt.setString(1, periodo_);
					stmt.executeUpdate();
		  
					System.out.println("Se elimino correctamente!! ");
					} catch (SQLException e) {
					  e.printStackTrace();
					}
																	 }
//=================================================================================================
	public static void DeletePerAcad (String PKperAcad) {
		
		String perAcad = PKperAcad;

		
		
			  String dbURL = "jdbc:sqlserver://MUÑOZV";
		      String user = "Brayan";
		      String pass = "12345";
		      
		      
		      String sql = "DELETE FROM PeriodoAcademico WHERE [Cod PeriodoAcad] = ?";
		
		      try (Connection conn = DriverManager.getConnection(dbURL, user, pass); 
		    		  PreparedStatement stmt = conn.prepareStatement(sql)) {
		  
					stmt.setString(1, perAcad);
					
			
					stmt.executeUpdate();
		  
					System.out.println("Se elimino correctamente!! ");
					} catch (SQLException e) {
					  e.printStackTrace();
					} 
	}


	
//=================================================================================================
	public static void UpdatePeriodo (
			String perAcad,
			String descripcion,
			java.sql.Date fechainicio,
			java.sql.Date fechaFin,
			java.sql.Date fechaInicioClases,
			java.sql.Date fechaFinClases,
			java.sql.Date fechaLimite,
			java.sql.Date fechaLimitePrem,
			java.sql.Date fechaLimiteRet,
			java.sql.Date fechaLimitePub
			
			) 
			{
				
				String per  = perAcad;
				String desc = descripcion;
				java.sql.Date fi   = fechainicio;
				java.sql.Date ff   = fechaFin;
				java.sql.Date fic  = fechaInicioClases;
				java.sql.Date ffc  = fechaFinClases;
				java.sql.Date fl   = fechaLimite;
				java.sql.Date flp  = fechaLimitePrem;
				java.sql.Date flr  = fechaLimiteRet;
				java.sql.Date flpu = fechaLimitePub;
			
								
				
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
			            		"UPDATE PeriodoAcademico SET descripcion = ?,FechaInicio = ?, FechaFin = ?, fechaInicioClases =?,fechaFinClases=?,fechaLimitePago=?, fechaLimitePrematricula = ?,fechaLimiteRetiro =?,fechaLimitePublicacion =? WHERE  [Cod PeriodoAcad] = ? ");

			            prepStmt.setString(10, per); 
			            prepStmt.setString(1, desc);
			            prepStmt.setDate(2, fi); 
			            prepStmt.setDate(3, ff);
			            prepStmt.setDate(4, fic); 
			            prepStmt.setDate(5, ffc); 
			            prepStmt.setDate(6, fl);
			            prepStmt.setDate(7, flp); 
			            prepStmt.setDate(8, flr); 
			            prepStmt.setDate(9, flpu); 
			            
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
	
	
}
