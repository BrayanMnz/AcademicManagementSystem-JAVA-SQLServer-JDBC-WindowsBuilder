package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Logica.Inscripcion;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegInscripcion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox<String> cbxPerAcad;
	JComboBox<String> cbxMatricula;
	JComboBox<String> cbxCodA;
	JComboBox<String> cbxNumGrupo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegInscripcion dialog = new RegInscripcion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegInscripcion() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarPeriodos();
				cargarAsignaturas();
				cargarMatriculas();
				
			}

			private void cargarAsignaturas() {

				Connection conn = null;

			       String dbURL = "jdbc:sqlserver://MUÑOZV";
			       String user = "Brayan";
			       String pass = "12345";
			       try {
					conn = DriverManager.getConnection(dbURL, user, pass);
				} catch (SQLException e2) {
			
					e2.printStackTrace();
				}
			       if (conn != null) {
			           System.out.println("Conexion establecida ");
			       			      }
			    String query = "Select A.[Cod Asignatura] as 'codigo' From Asignatura A";
			    
			    try (Statement stmt = conn.createStatement()) {
			     ResultSet rs = stmt.executeQuery(query);
			     while (rs.next()) {
			        cbxCodA.addItem(rs.getString("codigo"));
			    
			     
			    
			     }
			    
			   } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
			
			private void cargarMatriculas() {

				Connection conn = null;

			       String dbURL = "jdbc:sqlserver://MUÑOZV";
			       String user = "Brayan";
			       String pass = "12345";
			       try {
					conn = DriverManager.getConnection(dbURL, user, pass);
				} catch (SQLException e2) {
			
					e2.printStackTrace();
				}
			       if (conn != null) {
			           System.out.println("Conexion establecida ");
			       			      }
			    String query = "Select E.Matricula as 'Matricula' From Estudiante E";
			    
			    try (Statement stmt = conn.createStatement()) {
			     ResultSet rs = stmt.executeQuery(query);
			     while (rs.next()) {
			        cbxMatricula.addItem(rs.getString("Matricula"));
			    
			     
			    
			     }
			    
			   } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
			
			private void cargarPeriodos() {

				Connection conn = null;

			       String dbURL = "jdbc:sqlserver://MUÑOZV";
			       String user = "Brayan";
			       String pass = "12345";
			       try {
					conn = DriverManager.getConnection(dbURL, user, pass);
				} catch (SQLException e2) {
			
					e2.printStackTrace();
				}
			       if (conn != null) {
			           System.out.println("Conexion establecida ");
			       			      }
			    String query = "Select PA.[Cod PeriodoAcad] as 'Periodo' From  PeriodoAcademico PA\r\n" + 
			    		"Where PA.FechaInicio > (Select GETDATE())";
			    
			    try (Statement stmt = conn.createStatement()) {
			     ResultSet rs = stmt.executeQuery(query);
			     while (rs.next()) {
			        cbxPerAcad.addItem(rs.getString("Periodo"));
			    
			     
			    
			     }
			    
			   } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
			
			
			
			
		});
		setTitle("Inscripcion");
		setBounds(100, 100, 500, 314);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodPeriodoAcad = new JLabel("Periodo Academico:");
		lblCodPeriodoAcad.setFont(new Font("Courier New", Font.BOLD, 12));
		lblCodPeriodoAcad.setBounds(10, 23, 143, 27);
		contentPanel.add(lblCodPeriodoAcad);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Courier New", Font.BOLD, 12));
		lblMatricula.setBounds(10, 118, 143, 27);
		contentPanel.add(lblMatricula);
		
		JLabel lblCodigoAsignatura = new JLabel("Codigo Asignatura:");
		lblCodigoAsignatura.setFont(new Font("Courier New", Font.BOLD, 12));
		lblCodigoAsignatura.setBounds(304, 23, 143, 27);
		contentPanel.add(lblCodigoAsignatura);
		
		JLabel lblNumeroDeGrupo = new JLabel("Numero de Grupo:");
		lblNumeroDeGrupo.setFont(new Font("Courier New", Font.BOLD, 12));
		lblNumeroDeGrupo.setBounds(304, 118, 143, 27);
		contentPanel.add(lblNumeroDeGrupo);
		
		cbxPerAcad = new JComboBox();
		cbxPerAcad.setBounds(20, 45, 143, 20);
		contentPanel.add(cbxPerAcad);
		
		cbxCodA = new JComboBox();
		cbxCodA.setBounds(314, 44, 143, 20);
		contentPanel.add(cbxCodA);
		
		cbxMatricula = new JComboBox();
		cbxMatricula.setBounds(20, 143, 143, 20);
		contentPanel.add(cbxMatricula);
		
		cbxNumGrupo = new JComboBox();
		cbxNumGrupo.setEnabled(false);
		cbxNumGrupo.setBounds(314, 143, 143, 20);
		contentPanel.add(cbxNumGrupo);
		
		JButton btnVerGrupos = new JButton("Ver Grupos");
		btnVerGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					cargarGrupos(cbxPerAcad.getSelectedItem().toString(), cbxCodA.getSelectedItem().toString());
					cbxNumGrupo.setEnabled(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}

			private void cargarGrupos(String Per, String codAsig) throws SQLException {
				
				
				Connection conn = null;

			       String dbURL = "jdbc:sqlserver://MUÑOZV";
			       String user = "Brayan";
			       String pass = "12345";
			       try {
					conn = DriverManager.getConnection(dbURL, user, pass);
				} catch (SQLException e2) {
			
					e2.printStackTrace();
				}
			       if (conn != null) {
			           System.out.println("Conexion establecida ");
			       			      }
			    
			    PreparedStatement pstmt = null;
				try {
					pstmt = conn.prepareStatement(
						      "Select G.NumGrupo as 'Grupo' From Grupo G\r\n" + 
						      "Where G.[Cod Asignatura] = ? AND G.CodPeriodoAcad = ?");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    	pstmt.setString(1, codAsig);
			    	pstmt.setString(2, Per);

			    	ResultSet rs = pstmt.executeQuery();
			    
			     while (rs.next()) {
			        cbxNumGrupo.addItem(rs.getString("Grupo"));
			    
			     
			    
			     }
			    
		
				
			}
		});
		btnVerGrupos.setBounds(314, 190, 143, 35);
		contentPanel.add(btnVerGrupos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnInscribir = new JButton("Inscribir");
				btnInscribir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Inscripcion.InsertarInscripcion(cbxPerAcad.getSelectedItem().toString(), cbxCodA.getSelectedItem().toString(), cbxNumGrupo.getSelectedItem().toString(), cbxMatricula.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Grupo Inscrito !  ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						cbxNumGrupo.setEnabled(false);
					}
				});
				btnInscribir.setActionCommand("OK");
				buttonPane.add(btnInscribir);
				getRootPane().setDefaultButton(btnInscribir);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
