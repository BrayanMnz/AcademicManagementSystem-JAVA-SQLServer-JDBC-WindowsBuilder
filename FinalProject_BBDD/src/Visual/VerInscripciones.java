package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Inscripcion;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerInscripciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tblInscripciones;
	private String auxAsignatura;
	private String auxPeriodo;
	private String auxGrupo;
	private String auxMatricula;
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerInscripciones dialog = new VerInscripciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerInscripciones() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				cargarInscripciones();
			}
		});
		setTitle("Inscripciones");
		setBounds(100, 100, 565, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				tblInscripciones = new JTable();
				tblInscripciones.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						index = tblInscripciones.getSelectedRow();
						if(index >= 0) { 
						    auxPeriodo = (String)tblInscripciones.getModel().getValueAt(index, 0).toString();
						    auxMatricula = (String)tblInscripciones.getModel().getValueAt(index, 1).toString();
						    auxAsignatura = (String)tblInscripciones.getModel().getValueAt(index, 2).toString();
						    auxGrupo = (String)tblInscripciones.getModel().getValueAt(index, 3).toString();
						    
						    
						   
						   
						   
						}
					}
				});
				scrollPane.setViewportView(tblInscripciones);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Inscripcion.DeleteInscripcion(auxPeriodo, auxAsignatura, auxGrupo, auxMatricula);
						JOptionPane.showMessageDialog(null, "Grupo eliminado de inscripcion!  ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						
						cargarInscripciones();
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Salir");
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

	
private void cargarInscripciones() {
		
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
	         String query = "SELECT * FROM INSCRIPCION";
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
	        tblInscripciones.setModel(tableModel);
	    
	    conn.close();
	    }
	    catch(Exception ex)
	    {
	    JOptionPane.showMessageDialog(null, ex.toString());
	    }
	}
	

	
}
