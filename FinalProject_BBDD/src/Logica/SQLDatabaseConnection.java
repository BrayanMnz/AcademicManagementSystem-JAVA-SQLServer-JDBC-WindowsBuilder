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
 
       // InsertarAsignatura("ITT347T", "Redes Telematicas I", 4, 3, 1);
      //  InsertarEstudiante("20170843", "Jose", "Rafael", "Almonte", null, "ITT", "Contado", "DOM", null);
    	  InsertarGrupo("202020212", "ITT328T", "001", 25, null); 
    	  }


public static void InsertarAsignatura (String codigoAsig, String nombreAsig, int creditosAsig, int horasT, int horasP) {
	
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
        	
            String code = codigoAsig;
            String name = nombreAsig;
            int creditos = creditosAsig;
            int HorasT = horasT;
            int HorasP = horasP;
            
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

public static void InsertarEstudiante (String Matricula, String Nombre1, String Nombre2 
 ,String Apellido1, String Apellido2, String Carrera, String CatPago, String Nacionalidad
 ,String Direccion) {
	
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

public static void InsertarGrupo (String perAcad, String codAsig, String numGrupo 
		 ,int cupoGrupo, String horario) {
			
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




}