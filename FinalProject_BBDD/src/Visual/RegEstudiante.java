package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;


import Logica.Estudiante;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class RegEstudiante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMatricula;
	private JTextField txtNombre1;
	private JTextField txtNombre2;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtCarrera;
	private JTextField txtDireccion;
	private JTextField txtNacionalidad;
	private int index;
	private static DefaultTableModel model; 
	private static Object[] fila;
	private String auxMatricula;

	private JTable tblEstudiantes;
	JButton btnEliminarEstudiante;
	JButton btnModificarEstudiante;
	JButton btnInsertarEstudiante;
	JComboBox cbxCatPago;
	private static String ret_Array[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEstudiante dialog = new RegEstudiante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEstudiante() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarEstudiantes();
			}
		});
		setModal(true);
		setResizable(false);
		setTitle("Registro de Estudiantes");
		setBounds(100, 100, 726, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel_RegEstudiante = new JPanel();
			panel_RegEstudiante.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_RegEstudiante.setBounds(5, 5, 710, 174);
			contentPanel.add(panel_RegEstudiante);
			panel_RegEstudiante.setLayout(null);
			{
				JLabel lblMatricula = new JLabel("Matricula:");
				lblMatricula.setFont(new Font("Courier New", Font.BOLD, 12));
				lblMatricula.setBounds(10, 11, 101, 14);
				panel_RegEstudiante.add(lblMatricula);
			}
			
			txtMatricula = new JTextField();
			txtMatricula.setBounds(20, 29, 118, 20);
			panel_RegEstudiante.add(txtMatricula);
			txtMatricula.setColumns(10);
			
			JLabel lblNombre1 = new JLabel("1er Nombre:");
			lblNombre1.setFont(new Font("Courier New", Font.BOLD, 12));
			lblNombre1.setBounds(10, 60, 101, 14);
			panel_RegEstudiante.add(lblNombre1);
			
			txtNombre1 = new JTextField();
			txtNombre1.setBounds(20, 78, 118, 20);
			panel_RegEstudiante.add(txtNombre1);
			txtNombre1.setColumns(10);
			
			JLabel lblNombre2 = new JLabel("2do Nombre:");
			lblNombre2.setFont(new Font("Courier New", Font.BOLD, 12));
			lblNombre2.setBounds(10, 109, 101, 14);
			panel_RegEstudiante.add(lblNombre2);
			
			txtNombre2 = new JTextField();
			txtNombre2.setColumns(10);
			txtNombre2.setBounds(20, 127, 118, 20);
			panel_RegEstudiante.add(txtNombre2);
			
			JLabel lblApellido1 = new JLabel("1er Apellido:");
			lblApellido1.setFont(new Font("Courier New", Font.BOLD, 12));
			lblApellido1.setBounds(194, 11, 101, 14);
			panel_RegEstudiante.add(lblApellido1);
			
			txtApellido1 = new JTextField();
			txtApellido1.setColumns(10);
			txtApellido1.setBounds(204, 29, 118, 20);
			panel_RegEstudiante.add(txtApellido1);
			
			JLabel lblApellido2 = new JLabel("2do Apellido:");
			lblApellido2.setFont(new Font("Courier New", Font.BOLD, 12));
			lblApellido2.setBounds(194, 60, 101, 14);
			panel_RegEstudiante.add(lblApellido2);
			
			txtApellido2 = new JTextField();
			txtApellido2.setColumns(10);
			txtApellido2.setBounds(204, 77, 118, 20);
			panel_RegEstudiante.add(txtApellido2);
			
			JLabel lblCarrera = new JLabel("Carrera:");
			lblCarrera.setFont(new Font("Courier New", Font.BOLD, 12));
			lblCarrera.setBounds(378, 11, 101, 14);
			panel_RegEstudiante.add(lblCarrera);
			
			txtCarrera = new JTextField();
			txtCarrera.setBounds(388, 29, 118, 20);
			panel_RegEstudiante.add(txtCarrera);
			txtCarrera.setColumns(10);
			
			JLabel lblCatPago = new JLabel("Categoria Pago:");
			lblCatPago.setFont(new Font("Courier New", Font.BOLD, 12));
			lblCatPago.setHorizontalAlignment(SwingConstants.CENTER);
			lblCatPago.setBounds(378, 60, 111, 14);
			panel_RegEstudiante.add(lblCatPago);
			
			JComboBox cbxCatPago = new JComboBox();
			cbxCatPago.setFont(new Font("Courier New", Font.BOLD, 12));
			cbxCatPago.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Credito", "Contado "}));
			cbxCatPago.setBounds(388, 77, 118, 20);
			panel_RegEstudiante.add(cbxCatPago);
			
			JLabel lblNacionalidad = new JLabel("Nacionalidad:");
			lblNacionalidad.setHorizontalAlignment(SwingConstants.CENTER);
			lblNacionalidad.setFont(new Font("Courier New", Font.BOLD, 12));
			lblNacionalidad.setBounds(562, 10, 101, 14);
			panel_RegEstudiante.add(lblNacionalidad);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setFont(new Font("Courier New", Font.BOLD, 12));
			lblDireccion.setBounds(562, 60, 101, 14);
			panel_RegEstudiante.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(572, 78, 118, 20);
			panel_RegEstudiante.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			txtNacionalidad = new JTextField();
			txtNacionalidad.setBounds(572, 29, 118, 20);
			panel_RegEstudiante.add(txtNacionalidad);
			txtNacionalidad.setColumns(10);
			
			 btnInsertarEstudiante = new JButton("Insertar");
			btnInsertarEstudiante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtNombre1.getText().isEmpty() || txtApellido1.getText().isEmpty() || txtMatricula.getText().isEmpty()
							|| txtCarrera.getText().isEmpty() ) { 
						JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
						}
					else { Estudiante.InsertarEstudiante(txtMatricula.getText(), txtNombre1.getText(), txtNombre2.getText(), txtApellido1.getText(), txtApellido2.getText(), txtCarrera.getText(), (String) cbxCatPago.getSelectedItem(), txtNacionalidad.getText(), txtDireccion.getText());
					JOptionPane.showMessageDialog(null, "Insertado Correctamente", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnInsertarEstudiante.setFont(new Font("Courier New", Font.BOLD, 12));
			btnInsertarEstudiante.setBounds(204, 120, 118, 36);
			panel_RegEstudiante.add(btnInsertarEstudiante);
			
			 btnModificarEstudiante = new JButton("Modificar");
			btnModificarEstudiante.setEnabled(false);
			btnModificarEstudiante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbxCatPago.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
						JOptionPane.showMessageDialog(null, "Elija una categoria de pago ", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
					
					Estudiante.UpdateEstudiante(txtMatricula.getText(), txtNombre1.getText(), txtNombre2.getText(), txtApellido1.getText(), txtApellido2.getText(), txtCarrera.getText(), (String) cbxCatPago.getSelectedItem(), txtNacionalidad.getText(), txtDireccion.getText());
					JOptionPane.showMessageDialog(null, "Se modifico correctamente!! ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
					cargarEstudiantes();
					Clean();
					}
				}

			
			});
			btnModificarEstudiante.setFont(new Font("Courier New", Font.BOLD, 12));
			btnModificarEstudiante.setBounds(388, 120, 118, 36);
			panel_RegEstudiante.add(btnModificarEstudiante);
			
		
			btnEliminarEstudiante = new JButton("Eliminar");
			btnEliminarEstudiante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Estudiante.DeleteEstudiante(txtMatricula.getText());
					cargarEstudiantes();
					Clean();
					JOptionPane.showMessageDialog(null, "Se elimino correctamente!! ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
			btnEliminarEstudiante.setEnabled(false);
			btnEliminarEstudiante.setFont(new Font("Courier New", Font.BOLD, 12));
			btnEliminarEstudiante.setBounds(572, 120, 118, 36);
			panel_RegEstudiante.add(btnEliminarEstudiante);
		}
		
		JPanel panel_verEstudiantes = new JPanel();
		panel_verEstudiantes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Estudiantes Registrados", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_verEstudiantes.setBounds(5, 190, 710, 173);
		contentPanel.add(panel_verEstudiantes);
		panel_verEstudiantes.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneEstudiantes = new JScrollPane();
		panel_verEstudiantes.add(scrollPaneEstudiantes);
		
		tblEstudiantes = new JTable();
		tblEstudiantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = tblEstudiantes.getSelectedRow();
				if(index >= 0) { 
				    auxMatricula = (String)tblEstudiantes.getModel().getValueAt(index, 0).toString();
				    
				    try {
						ArrayList<String> aux = buscarPorMatricula(auxMatricula);
						txtMatricula.setText(aux.get(0));
						txtNombre1.setText(aux.get(1));
						txtNombre2.setText(aux.get(2));
						txtApellido1.setText(aux.get(3));
						txtApellido2.setText(aux.get(4));
						txtCarrera.setText(aux.get(5));
						txtNacionalidad.setText(aux.get(7));
						txtDireccion.setText(aux.get(8));

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    txtMatricula.setEditable(false);
				    btnEliminarEstudiante.setEnabled(true);
				    btnInsertarEstudiante.setEnabled(false);
				    btnModificarEstudiante.setEnabled(true);
				   
				}
				
			}
		});
		scrollPaneEstudiantes.setViewportView(tblEstudiantes);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Actualizar Lista");
				okButton.setFont(new Font("Courier New", Font.BOLD, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cargarEstudiantes();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void cargarEstudiantes() {
		
		Connection conn = null;
	    try
	    {
	    	 String dbURL = "jdbc:sqlserver://MUÑOZV";
	         String user = "Brayan";
	         String pass = "12345";
	         conn = DriverManager.getConnection(dbURL, user, pass);
	         if (conn != null) {
	             System.out.println("Conexion establecida ");
	         			      }
	         String query = "SELECT E.Matricula, E.Nombre1 + LEFT(E.Nombre2, 1)+'.' AS 'Nombre',E.Apellido1+LEFT(E.Apellido2, 1)+'.' AS 'Apellidos',\r\n" + 
	         		"E.Carrera, E.CategoriaPago AS 'Cat. Pago', E.Nacionalidad, E.Direccion\r\n" + 
	         		"FROM Estudiante E";
	    PreparedStatement st =conn.prepareStatement(query);
	    ResultSet rs = st.executeQuery();
	    
	    
	        //Create new table model
	        DefaultTableModel tableModel = new DefaultTableModel();

	        //Retrieve meta data from ResultSet
	        ResultSetMetaData metaData = rs.getMetaData();

	        //Get number of columns from meta data
	        int columnCount = metaData.getColumnCount();

	        //Get all column names from meta data and add columns to table model
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
	            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
	        }

	        //Create array of Objects with size of column count from meta data
	        Object[] row = new Object[columnCount];

	        //Scroll through result set
	        while (rs.next()){
	            //Get object from column with specific index of result set to array of objects
	            for (int i = 0; i < columnCount; i++){
	                row[i] = rs.getObject(i+1);
	            }
	            //Now add row to table model with that array of objects as an argument
	            tableModel.addRow(row);
	        }

	        //Now add that table model to your table and you are done :D
	        tblEstudiantes.setModel(tableModel);
	    
	    conn.close();
	    }
	    catch(Exception ex)
	    {
	    JOptionPane.showMessageDialog(null, ex.toString());
	    }
	}
	
	
	public static  ArrayList<String> buscarPorMatricula (String matricula) throws SQLException 
					{
		 ArrayList<String> ret = new ArrayList<String>();
				    String matricula_ = matricula;
				  
			   		Connection conn = null;

			   	        String dbURL = "jdbc:sqlserver://MUÑOZV";
			   	        String user = "Brayan";
			   	        String pass = "12345";
			   	        conn = DriverManager.getConnection(dbURL, user, pass);
			   	        if (conn != null) {
			   	            System.out.println("Conexion establecida ");
			   	        			      }
			   	     String query = "select * FROM Estudiante WHERE Matricula = ".concat(matricula_);
			   	    try (Statement stmt = conn.createStatement()) {
			   	      ResultSet rs = stmt.executeQuery(query);
			   	      while (rs.next()) {
			   	        String Matricula1 = rs.getString("Matricula");
			   	        String Nombre1    = rs.getString("Nombre1");
			   	        String Nombre2    = rs.getString("Nombre2");
			   	        String Apellido1  = rs.getString("Apellido1");
			   	        String Apellido2  = rs.getString("Apellido2");
			   	        
			   	        String Carrera    = rs.getString("Carrera");
			   	        String CategoriaPago  = rs.getString("CategoriaPago");
			   	        String  Nacionalidad  = rs.getString("Nacionalidad");
			   	        String Direccion  = rs.getString("Direccion");
			   	         
			   	     ret.add(Matricula1);
			   	     ret.add(Nombre1);
			   	     ret.add(Nombre2);
			   	     ret.add(Apellido1);
			   	     ret.add(Apellido2);
			   	     ret.add(Carrera);
			   	     ret.add(CategoriaPago);
			   	     ret.add(Nacionalidad);
			   	     ret.add(Direccion);
			   	     
			   	      }
			   	    } 
			    	
			    	
	       
	            return ret;
	      
					}
	
	private void Clean() {
	txtApellido1.setText("");
	txtApellido2.setText("");
	txtNombre1.setText("");
	txtNombre2.setText("");
	txtCarrera.setText("");
	txtNacionalidad.setText("");
	txtMatricula.setText("");
	txtDireccion.setText("");

	}
	
	
	
	
	
}
