package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Estudiante {

	private String matricula;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String carrera;
	private String categoriaPago;
	private String nacionalidad;
	private String direccion;
	
	public Estudiante(String matricula, String nombre1, String nombre2, String apellido1, String apellido2,
			String carrera, String categoriaPago, String nacionalidad, String direccion) {
		super();
		this.matricula = matricula;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.carrera = carrera;
		this.categoriaPago = categoriaPago;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNombre1() {
		return nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getCarrera() {
		return carrera;
	}

	public String getCategoriaPago() {
		return categoriaPago;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public void setCategoriaPago(String categoriaPago) {
		this.categoriaPago = categoriaPago;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
//============================================================================	
	public static void InsertarEstudiante (
			String Matricula,
			String Nombre1,
			String Nombre2,
			String Apellido1,
			String Apellido2,
			String Carrera,
			String CatPago,
			String Nacionalidad,
			String Direccion) {
		
					String Matricula_ = Matricula;
					String Nombre1_ = Nombre1;
					String Nombre2_ = Nombre2; 
					String Apellido1_ = Apellido1;
					String Apellido2_ = Apellido2; 
					String Carrera_ = Carrera; 
					String CatPago_ = CatPago; 
					String Nacionalidad_ = Nacionalidad;
					String Direccion_ = Direccion;
		
		
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
	        	
	       
	            String sqlQuery = " INSERT INTO Estudiante (Matricula,Nombre1,Nombre2,Apellido1,Apellido2,Carrera,CategoriaPago,Nacionalidad,Direccion)"
	                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
	            prepStmt.setString(1, Matricula_); 
	            prepStmt.setString(2, Nombre1_);
	            prepStmt.setString(3, Nombre2_); 
	            prepStmt.setString(4, Apellido1_);
	            prepStmt.setString(5, Apellido2_); 
	            prepStmt.setString(6, Carrera_);
	            prepStmt.setString(7, CatPago_); 
	            prepStmt.setString(8, Nacionalidad_);
	            prepStmt.setString(9, Direccion_); 
	           
	        
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
	public static void UpdateEstudiante (
			String Matricula,
			String Nombre1,
			String Nombre2,
			String Apellido1,
			String Apellido2,
			String Carrera,
			String CatPago,
			String Nacionalidad,
			String Direccion) 
			{
					String Matricula_ = Matricula;
					String Nombre1_ = Nombre1;
					String Nombre2_ = Nombre2; 
					String Apellido1_ = Apellido1;
					String Apellido2_ = Apellido2; 
					String Carrera_ = Carrera; 
					String CatPago_ = CatPago; 
					String Nacionalidad_ = Nacionalidad;
					String Direccion_ = Direccion;
					
					
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
			            		"UPDATE Estudiante SET Nombre1 = ?,Nombre2 = ?,Apellido1 = ?,"
			            		+ "Apellido2 = ?,Carrera = ?,CategoriaPago = ?,Nacionalidad = ?,"
			            		+ "Direccion = ? WHERE  Matricula = ? ");

			            ps.setString(1, Nombre1_);
			            ps.setString(2, Nombre2_);
			            ps.setString(3, Apellido1_);
			            ps.setString(4, Apellido2_);
			            ps.setString(5, Carrera_);
			            ps.setString(6, CatPago_);
			            ps.setString(7, Nacionalidad_);
			            ps.setString(8, Direccion_);
			            ps.setString(9, Matricula_);


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
//============================================================================		
			public static void DeleteEstudiante (String PK_Matricula) {
				
				String matricula = PK_Matricula;
				
				
					  String dbURL = "jdbc:sqlserver://MUÑOZV";
				      String user = "Brayan";
				      String pass = "12345";
				      
				      
				      String sql = "DELETE FROM Estudiante WHERE Matricula = ?";
				
				      try (Connection conn = DriverManager.getConnection(dbURL, user, pass); 
				    		  PreparedStatement stmt = conn.prepareStatement(sql)) {
				  
							stmt.setString(1, matricula);
							stmt.executeUpdate();
				  
							System.out.println("Se elimino correctamente!! ");
							} catch (SQLException e) {
							  e.printStackTrace();
							}
																			 }
//=================================================================================================
	
}
