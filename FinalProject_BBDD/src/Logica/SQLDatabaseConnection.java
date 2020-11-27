package Logica;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 
public class SQLDatabaseConnection {
 
    public static void main(String[] args) {
 
       // InsertarAsignatura("ITT348T", "Redes Telematicas II", 4, 3, 1);
       // InsertarEstudiante("20170843", "Jose", "Rafael", "Almonte", null, "ITT", "Contado", "DOM", null);
       // InsertarGrupo("202020212", "ITT328T", "001", 25, null); 
       // UpdateGrupo("202020211", "ISC484T", "001", 100, null);
       // UpdateEstudiante("20170843", "Jose", "R.", "Almonte", "Cabrera", "ITT", "Credito", "DOM", null);
       //UpdateAsignatura("ISC484T", "Bases de Datos", 3, 3, 0);
       //DeleteAsignatura("ITT348T");
       //DeleteGrupo("202020211", "ISC484T", "001");
    	
    }


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
     //   String query1 = "select * from Asignatura";
       

//        String query2 = "Insert into Asignatura ([Cod Asignatura],Nombre,Creditos,HorasTeoricas,HorasPracticas)\r\n" + 
//        		"Values('ITT384T','Redes Telematicas II',4,4,0)";
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
        	
        	
        	
        	
        	

        //  stmt.executeUpdate(query2);
        //  ResultSet rs = stmt.executeQuery(query1);
//          while (rs.next()) {
//        	 
//            String Asignatura = rs.getString("Cod Asignatura");
//            String NombreAsig = rs.getString("Nombre");
//            int CreditosAsig = rs.getInt("Creditos");
//            int HorasTeor = rs.getInt("HorasTeoricas");
//            int HorasPrac = rs.getInt("HorasPracticas");
//            System.out.println("Asignatura" + ", " + "NombreAsig" + ", " + "Creditos" +
//                    ", " + "Horas Teoricas" + ", " + "Horas Practicas");
//            System.out.println(Asignatura + ", " + NombreAsig + ", " + CreditosAsig +
//                               ", " + HorasTeor + ", " + HorasPrac);
//            
//            
//          }
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
		


}