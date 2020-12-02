package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class InformeInscripcion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMatricula;
	private JTextField txtPeriodo;
	private JTable tblInforme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InformeInscripcion dialog = new InformeInscripcion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InformeInscripcion() {
		setTitle("Informe de Inscripcion");
		setBounds(100, 100, 601, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserte matricula estudiante:");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 203, 37);
		contentPanel.add(lblNewLabel);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(20, 40, 203, 20);
		contentPanel.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblInsertePeriodoAcademico = new JLabel("Inserte Periodo Academico:");
		lblInsertePeriodoAcademico.setFont(new Font("Courier New", Font.BOLD, 12));
		lblInsertePeriodoAcademico.setBounds(334, 11, 203, 37);
		contentPanel.add(lblInsertePeriodoAcademico);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(344, 40, 203, 20);
		contentPanel.add(txtPeriodo);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 107, 565, 173);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tblInforme = new JTable();
		scrollPane.setViewportView(tblInforme);
		
		JButton btnInforme = new JButton("Generar Informe");
		btnInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMatricula.getText().isEmpty() || txtPeriodo.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "Debe completar los campos necesarios!  ", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
				cargarInforme(txtMatricula.getText(), txtPeriodo.getText());
				txtMatricula.setText("");
				txtPeriodo.setText("");
				}
			}
		});
		btnInforme.setBounds(410, 73, 137, 23);
		contentPanel.add(btnInforme);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("OK");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
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
	
	private void cargarInforme(String matricula, String periodo) {
		
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
	         String query = "EXEC [dbo].[InformeInscripcion]".concat("'"+matricula+"','"+periodo+"'");
	         
	         
	         
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
	        tblInforme.setModel(tableModel);
	    
	    conn.close();
	    }
	    catch(Exception ex)
	    {
	    JOptionPane.showMessageDialog(null, ex.toString());
	    }
	}
	
	
	
	
	
}
