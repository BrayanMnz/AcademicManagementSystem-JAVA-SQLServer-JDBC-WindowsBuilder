package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Asignatura;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarAsignaturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscar;
	private JTextField txtCodAsignatura;
	private JTextField txtNombre;
	private JTextField txtCreditos;
	private JTextField txtHrsTeoricas;
	private JTextField txtHrsPracticas;
	private JTable tblAsignaturas;
	
	private static DefaultTableModel model; 
	private static Object[] fila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarAsignaturas dialog = new ListarAsignaturas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarAsignaturas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				CargarAsignaturas();
			}

			
		});
		setTitle("Asignaturas");
		setBounds(100, 100, 529, 419);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnBuscarAsignatura = new JPanel();
		pnBuscarAsignatura.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnBuscarAsignatura.setBounds(10, 11, 493, 140);
		contentPanel.add(pnBuscarAsignatura);
		pnBuscarAsignatura.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar: ");
		lblBuscar.setFont(new Font("Courier New", Font.BOLD, 12));
		lblBuscar.setBounds(10, 13, 61, 14);
		pnBuscarAsignatura.add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(65, 9, 111, 20);
		pnBuscarAsignatura.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					ArrayList<String> aux = buscarPorCodigoAsignatura(txtBuscar.getText());
					 txtCodAsignatura.setText(aux.get(0));
					 txtNombre.setText(aux.get(1));
					 txtCreditos.setText(aux.get(2));
					 txtHrsTeoricas.setText(aux.get(3));
					 txtHrsPracticas.setText(aux.get(4));
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtNombre.setEditable(true);
				txtCreditos.setEditable(true);
				txtHrsPracticas.setEditable(true);
				txtHrsTeoricas.setEditable(true);
			}
		});
		btnBuscar.setBounds(186, 8, 89, 23);
		pnBuscarAsignatura.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(9, 38, 473, 14);
		pnBuscarAsignatura.add(separator);
		
		JLabel lblCodAsignatura = new JLabel("Codigo Asignatura:");
		lblCodAsignatura.setFont(new Font("Courier New", Font.BOLD, 12));
		lblCodAsignatura.setBounds(10, 50, 144, 14);
		pnBuscarAsignatura.add(lblCodAsignatura);
		
		txtCodAsignatura = new JTextField();
		txtCodAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodAsignatura.setEditable(false);
		txtCodAsignatura.setBounds(10, 65, 144, 20);
		pnBuscarAsignatura.add(txtCodAsignatura);
		txtCodAsignatura.setColumns(10);
		
		JLabel lblNombreAsignatura = new JLabel("Nombre Asignatura:");
		lblNombreAsignatura.setFont(new Font("Courier New", Font.BOLD, 12));
		lblNombreAsignatura.setBounds(10, 96, 144, 14);
		pnBuscarAsignatura.add(lblNombreAsignatura);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 111, 193, 20);
		pnBuscarAsignatura.add(txtNombre);
		
		JLabel lblCreditos = new JLabel("Creditos:");
		lblCreditos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditos.setFont(new Font("Courier New", Font.BOLD, 12));
		lblCreditos.setBounds(232, 50, 115, 14);
		pnBuscarAsignatura.add(lblCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCreditos.setEditable(false);
		txtCreditos.setBounds(232, 65, 115, 20);
		pnBuscarAsignatura.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		JLabel lblHorasTeoricas = new JLabel("Horas Teoricas:");
		lblHorasTeoricas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasTeoricas.setFont(new Font("Courier New", Font.BOLD, 12));
		lblHorasTeoricas.setBounds(223, 96, 124, 14);
		pnBuscarAsignatura.add(lblHorasTeoricas);
		
		txtHrsTeoricas = new JTextField();
		txtHrsTeoricas.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHrsTeoricas.setEditable(false);
		txtHrsTeoricas.setColumns(10);
		txtHrsTeoricas.setBounds(232, 111, 115, 20);
		pnBuscarAsignatura.add(txtHrsTeoricas);
		
		JLabel lblHorasPracticas = new JLabel("Horas Practicas:");
		lblHorasPracticas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasPracticas.setFont(new Font("Courier New", Font.BOLD, 12));
		lblHorasPracticas.setBounds(358, 74, 124, 14);
		pnBuscarAsignatura.add(lblHorasPracticas);
		
		txtHrsPracticas = new JTextField();
		txtHrsPracticas.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHrsPracticas.setEditable(false);
		txtHrsPracticas.setColumns(10);
		txtHrsPracticas.setBounds(367, 92, 115, 20);
		pnBuscarAsignatura.add(txtHrsPracticas);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(285, 9, 12, 22);
		pnBuscarAsignatura.add(separator_1);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Asignatura.UpdateAsignatura(txtCodAsignatura.getText(), txtNombre.getText(), Integer.parseInt(txtCreditos.getText()), Integer.parseInt(txtHrsTeoricas.getText()), Integer.parseInt(txtHrsPracticas.getText()));
				JOptionPane.showMessageDialog(null, "Se modifico correctamente!! ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
				
				CargarAsignaturas();
				Clean(); 
			}
		});
		btnModificar.setBounds(295, 8, 89, 23);
		pnBuscarAsignatura.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Asignatura.DeleteAsignatura(txtCodAsignatura.getText());
			JOptionPane.showMessageDialog(null, "Se elimino correctamente!! ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
			CargarAsignaturas();
			Clean();
			}

			
		});
		btnEliminar.setBounds(394, 8, 89, 23);
		pnBuscarAsignatura.add(btnEliminar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Listado de Asignaturas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 162, 493, 174);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblAsignaturas = new JTable();
		
		scrollPane.setViewportView(tblAsignaturas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
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
	
	public static  ArrayList<String> buscarPorCodigoAsignatura (String codAsig) throws SQLException 
	{
ArrayList<String> ret = new ArrayList<String>();
    String codAsignatura_ = codAsig;
  
		Connection conn = null;

	        String dbURL = "jdbc:sqlserver://MUÑOZV";
	        String user = "Brayan";
	        String pass = "12345";
	        conn = DriverManager.getConnection(dbURL, user, pass);
	        if (conn != null) {
	            System.out.println("Conexion establecida ");
	        			      }
	     String query = "Select * \r\n" + 
	   	     		"FROM Asignatura WHERE [Cod Asignatura]=".concat("'"+codAsignatura_+"'");
	    try (Statement stmt = conn.createStatement()) {
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
	        String codigo   = rs.getString("Cod Asignatura");
	        String nombre   = rs.getString("Nombre");
	        int    creditos = rs.getInt("Creditos");
	        int hrTeoricas  = rs.getInt("HorasTeoricas");
	        int hrPracticas  = rs.getInt("HorasPracticas");
	         
	        
	        
	     ret.add(codigo);
	     ret.add(nombre);
	     ret.add(Integer.toString(creditos));
	     ret.add(Integer.toString(hrTeoricas));
	     ret.add(Integer.toString(hrPracticas));
	      }
	    } 
	
	

return ret;

	}
	
	private void CargarAsignaturas() {
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
	         String query = "SELECT * FROM Asignatura";
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
	        tblAsignaturas.setModel(tableModel);
	    
	    conn.close();
	    }
	    catch(Exception ex)
	    {
	    JOptionPane.showMessageDialog(null, ex.toString());
	    }
		
	}
	
	private void Clean() {
	txtBuscar.setText("");
	txtCodAsignatura.setText("");
	txtNombre.setText("");
	txtCreditos.setText("");
	txtHrsPracticas.setText("");
	txtHrsTeoricas.setText("");
	}
	
	
	
	
}
