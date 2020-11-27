package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
	

//=================================================================================================	
	public static void InsertarAsignatura (
			String codigoAsig,
			String nombreAsig,
			int creditosAsig,
			int horasT, 
			int horasP) 
					{
				    String code = codigoAsig;
				    String name = nombreAsig;
				    int creditos = creditosAsig;
				    int HorasT = horasT;
				    int HorasP = horasP;
		
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
	        	
	      
	            
	            String sqlQuery = " INSERT INTO Asignatura ([Cod Asignatura],Nombre,Creditos,HorasTeoricas,HorasPracticas)"
	                    + " VALUES(?, ?, ?, ?, ?)";
	            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
	            prepStmt.setString(1, code); 
	            prepStmt.setString(2, name);
	            prepStmt.setInt(3, creditos);
	            prepStmt.setInt(4, HorasT);
	            prepStmt.setInt(5, HorasP);
	            prepStmt.executeUpdate();
	            prepStmt.close();
	            System.out.println("\n");

	            System.out.println("Asignatura Insertada Correctamente! ");
	                  
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
	public static void UpdateAsignatura (
			String codigoAsig,
			String nombreAsig,
			int creditosAsig,
			int horasT, 
			int horasP) 
			{
				String codAsig_ = codigoAsig;
				String nombreAsig_ = nombreAsig;
				int cdtAsig_ = creditosAsig;
				int hrT_ = horasT; 
				int hrP_ = horasP;
							
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
			            		"UPDATE Asignatura SET Nombre = ?,Creditos = ?,HorasTeoricas = ?,"
			            		+ "HorasPracticas = ? WHERE  [Cod Asignatura] = ? ");

			            ps.setString(1, nombreAsig_);
			            ps.setInt(2, cdtAsig_);
			            ps.setInt(3, hrT_);
			            ps.setInt(4, hrP_);
			            ps.setString(5, codAsig_);
			         


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
			public static void DeleteAsignatura (String cod_Asignatura) {
			
			String asignatura_Cod = cod_Asignatura;
			
			
				  String dbURL = "jdbc:sqlserver://MUÑOZV";
			      String user = "Brayan";
			      String pass = "12345";
			      
			      
			      String sql = "DELETE FROM Asignatura WHERE [Cod Asignatura] = ?";
			
			      try (Connection conn = DriverManager.getConnection(dbURL, user, pass); 
			    		  PreparedStatement stmt = conn.prepareStatement(sql)) {
			  
						stmt.setString(1, asignatura_Cod);
				
						stmt.executeUpdate();
			  
						System.out.println("Se elimino correctamente!! ");
						} catch (SQLException e) {
						  e.printStackTrace();
						}
																		}

//=================================================================================================
}
