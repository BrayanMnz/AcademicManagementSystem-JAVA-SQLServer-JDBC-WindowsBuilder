package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;

import Logica.periodoAcademico;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.ref.Cleaner.Cleanable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegPeriodoAcademico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPerAcad;
	private JTextField txtDescripcion;
	JFormattedTextField ftxtInicioPeriodo;
	JFormattedTextField ftxtLimiteRetiro;
	JFormattedTextField ftxtFinPeriodo ;
	JFormattedTextField ftxtInicioClases ;
	JFormattedTextField ftxtLimitePrem;
	JFormattedTextField ftxtFinClases;
	JFormattedTextField ftxtLimitePago;
	JFormattedTextField ftxtLimitePublicacion;
	private JTable tblPeriodosAcademicos;
	private String auxPeriodo;
	
	private int index;
	
	private static DefaultTableModel model; 
	private static Object[] fila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPeriodoAcademico dialog = new RegPeriodoAcademico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPeriodoAcademico() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarPeriodos();
				
			}
		});
		setTitle("Periodos Academicos");
		setBounds(100, 100, 755, 564);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 719, 239);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblPerAcad = new JLabel("Codigo Per. Academico:");
		lblPerAcad.setFont(new Font("Courier New", Font.BOLD, 12));
		lblPerAcad.setBounds(10, 23, 177, 14);
		panel.add(lblPerAcad);
		
		txtPerAcad = new JTextField();
		txtPerAcad.setBounds(20, 37, 153, 20);
		panel.add(txtPerAcad);
		txtPerAcad.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Courier New", Font.BOLD, 12));
		lblDescripcion.setBounds(10, 79, 119, 14);
		panel.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(20, 96, 153, 20);
		panel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblFechainicioPer = new JLabel("Fecha Inicio Periodo:");
		lblFechainicioPer.setFont(new Font("Courier New", Font.BOLD, 12));
		lblFechainicioPer.setBounds(263, 23, 177, 14);
		panel.add(lblFechainicioPer);
		
		JLabel lblFechaFinPer = new JLabel("Fecha Fin Periodo:");
		lblFechaFinPer.setFont(new Font("Courier New", Font.BOLD, 12));
		lblFechaFinPer.setBounds(263, 79, 177, 14);
		panel.add(lblFechaFinPer);
		
		MaskFormatter formatoFecha = null;
		
		try {
			formatoFecha = new MaskFormatter("####-##-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatoFecha.setPlaceholder("1912-12-31");
		ftxtInicioPeriodo =  new JFormattedTextField(formatoFecha);
		
		
		ftxtInicioPeriodo.setBounds(273, 37, 153, 20);
		panel.add(ftxtInicioPeriodo);
		
		ftxtFinPeriodo = new JFormattedTextField(formatoFecha);
		ftxtFinPeriodo.setBounds(273, 93, 153, 20);
		panel.add(ftxtFinPeriodo);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(211, 11, 13, 105);
		panel.add(separator);
		
		JLabel lblFechainicioClases = new JLabel("Fecha Inicio Clases:");
		lblFechainicioClases.setFont(new Font("Courier New", Font.BOLD, 12));
		lblFechainicioClases.setBounds(532, 23, 177, 14);
		panel.add(lblFechainicioClases);
		
		 ftxtInicioClases = new JFormattedTextField(formatoFecha);
		ftxtInicioClases.setBounds(542, 37, 153, 20);
		panel.add(ftxtInicioClases);
		
		JLabel lblFechaFinClases = new JLabel("Fecha Fin Clases:");
		lblFechaFinClases.setFont(new Font("Courier New", Font.BOLD, 12));
		lblFechaFinClases.setBounds(532, 79, 177, 14);
		panel.add(lblFechaFinClases);
		
		 ftxtFinClases = new JFormattedTextField(formatoFecha);
		ftxtFinClases.setBounds(542, 93, 153, 20);
		panel.add(ftxtFinClases);
		
		JLabel lblFechaLimitePago = new JLabel("Fecha Limite Pago:");
		lblFechaLimitePago.setFont(new Font("Courier New", Font.BOLD, 12));
		lblFechaLimitePago.setBounds(264, 141, 177, 14);
		panel.add(lblFechaLimitePago);
		
		 ftxtLimitePago = new JFormattedTextField(formatoFecha);
		ftxtLimitePago.setBounds(274, 155, 153, 20);
		panel.add(ftxtLimitePago);
		
		JLabel lblFechaLimitePrematricula = new JLabel("Fecha Limite Prematricula:");
		lblFechaLimitePrematricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaLimitePrematricula.setFont(new Font("Courier New", Font.BOLD, 12));
		lblFechaLimitePrematricula.setBounds(263, 196, 183, 14);
		panel.add(lblFechaLimitePrematricula);
		
	    ftxtLimitePrem = new JFormattedTextField(formatoFecha);
		ftxtLimitePrem.setBounds(273, 210, 153, 20);
		panel.add(ftxtLimitePrem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 122, 699, 8);
		panel.add(separator_1);
		
		JLabel lblFechaLimiteRetiro = new JLabel("Fecha Limite Retiro:");
		lblFechaLimiteRetiro.setFont(new Font("Courier New", Font.BOLD, 12));
		lblFechaLimiteRetiro.setBounds(527, 141, 177, 14);
		panel.add(lblFechaLimiteRetiro);
		
		ftxtLimiteRetiro = new JFormattedTextField(formatoFecha);
		ftxtLimiteRetiro.setBounds(537, 155, 153, 20);
		panel.add(ftxtLimiteRetiro);
		
		JLabel lblFechaLimitePublicacion = new JLabel("Fecha Limite Publicacion:");
		lblFechaLimitePublicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaLimitePublicacion.setFont(new Font("Courier New", Font.BOLD, 12));
		lblFechaLimitePublicacion.setBounds(526, 196, 183, 14);
		panel.add(lblFechaLimitePublicacion);
		
		ftxtLimitePublicacion = new JFormattedTextField(formatoFecha);
		ftxtLimitePublicacion.setBounds(536, 210, 153, 20);
		panel.add(ftxtLimitePublicacion);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtPerAcad.getText().equalsIgnoreCase("1912-12-31") || txtDescripcion.getText().equalsIgnoreCase("1912-12-31") || ftxtInicioPeriodo.getText().equalsIgnoreCase("1912-12-31") ||  ftxtFinPeriodo.getText().equalsIgnoreCase("1912-12-31") ||
			    		ftxtInicioClases.getText().equalsIgnoreCase("1912-12-31") || ftxtFinClases.getText().equalsIgnoreCase("1912-12-31") || ftxtLimitePago.getText().equalsIgnoreCase("1912-12-31") ||
			    		ftxtLimitePrem.getText().equalsIgnoreCase("1912-12-31") || ftxtLimiteRetiro.getText().equalsIgnoreCase("1912-12-31") || ftxtLimitePublicacion.getText().equalsIgnoreCase("1912-12-31")) 
						
				{ 		JOptionPane.showMessageDialog(null, "Debe completar todos los campos! ", "Error", JOptionPane.WARNING_MESSAGE);
				
											}
				else if (txtPerAcad.getText().isEmpty() || txtDescripcion.getText().isEmpty() || ftxtInicioPeriodo.getText().isEmpty() ||  ftxtFinPeriodo.getText().isEmpty()||
			    		ftxtInicioClases.getText().isEmpty()|| ftxtFinClases.getText().isEmpty()|| ftxtLimitePago.getText().isEmpty() ||
			    		ftxtLimitePrem.getText().isEmpty() || ftxtLimiteRetiro.getText().isEmpty() || ftxtLimitePublicacion.getText().isEmpty()) 
				{ 
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos! ", "Error", JOptionPane.WARNING_MESSAGE);
					
				}
			    
				else {
				periodoAcademico a1 = new periodoAcademico(txtPerAcad.getText(), txtDescripcion.getText(), Date.valueOf(ftxtInicioPeriodo.getText()),Date.valueOf(ftxtFinPeriodo.getText()),
			    		Date.valueOf(ftxtInicioClases.getText()), Date.valueOf(ftxtFinClases.getText()),Date.valueOf(ftxtLimitePago.getText()),
			    		Date.valueOf(ftxtLimitePrem.getText()),Date.valueOf(ftxtLimiteRetiro.getText()), Date.valueOf(ftxtLimitePublicacion.getText()));
			   
				periodoAcademico.InsertarPerAcad(a1);
			    
			    clean();
			    cargarPeriodos();
				
				}
			}

	
		});
		btnInsertar.setBounds(10, 127, 71, 103);
		panel.add(btnInsertar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			periodoAcademico.DeletePeriodo(txtPerAcad.getText());
			cargarPeriodos();
			clean();
			
			}
		});
		btnEliminar.setBounds(183, 127, 71, 103);
		panel.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				periodoAcademico.UpdatePeriodo(txtPerAcad.getText(), txtDescripcion.getText(), Date.valueOf(ftxtInicioPeriodo.getText()),Date.valueOf(ftxtFinPeriodo.getText()),
			    		Date.valueOf(ftxtInicioClases.getText()), Date.valueOf(ftxtFinClases.getText()),Date.valueOf(ftxtLimitePago.getText()),
			    		Date.valueOf(ftxtLimitePrem.getText()),Date.valueOf(ftxtLimiteRetiro.getText()), Date.valueOf(ftxtLimitePublicacion.getText()));
					JOptionPane.showMessageDialog(null, "Se ha modificado correctamente! ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
					cargarPeriodos();
					clean();
				
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnModificar.setBounds(91, 127, 82, 103);
		panel.add(btnModificar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 261, 719, 220);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tblPeriodosAcademicos = new JTable();
		tblPeriodosAcademicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				index = tblPeriodosAcademicos.getSelectedRow();
				if(index >= 0) { 
				    auxPeriodo = (String)tblPeriodosAcademicos.getModel().getValueAt(index, 0).toString();
				    
				    try {
						ArrayList<String> aux = buscarPorPeriodo(auxPeriodo);
						txtPerAcad.setText(aux.get(0));
						txtDescripcion.setText(aux.get(1));
						ftxtInicioPeriodo.setText(aux.get(2));
						ftxtFinPeriodo.setText(aux.get(3));
						ftxtInicioClases.setText(aux.get(4));
						ftxtFinClases.setText(aux.get(5));
						ftxtLimitePago.setText(aux.get(6));
						ftxtLimitePrem.setText(aux.get(7));
						ftxtLimiteRetiro.setText(aux.get(8));
						ftxtLimitePublicacion.setText(aux.get(9));

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
				    btnModificar.setEnabled(true);
				    btnEliminar.setEnabled(true);
				    btnInsertar.setEnabled(false);
				    txtPerAcad.setEditable(false);
				    
				}
				
			}
		});
		scrollPane.setViewportView(tblPeriodosAcademicos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insertar nuevo");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clean();
						btnInsertar.setEnabled(true);
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
private void cargarPeriodos() {
		
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
	         String query = "Select PA.[Cod PeriodoAcad] as 'Periodo', PA.Descripcion, PA.FechaInicio as 'F. Inicio', PA.FechaFin as 'F. Fin', PA.FechaInicioClases as 'F. Inicio Clases', PA.FechaFinClases as 'F. Fin Clases', PA.FechaLimitePago as 'F. Limite Pago',\r\n" + 
	         		"PA.FechaLimitePrematricula as 'F. Lim Prem', PA.FechaLimiteRetiro as 'F. Lim Retiro', PA.FechaLimitePublicacion as 'F. Lim. Publ'\r\n" + 
	         		"From PeriodoAcademico PA";
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
	        tblPeriodosAcademicos.setModel(tableModel);
	    
	    conn.close();
	    }
	    catch(Exception ex)
	    {
	    JOptionPane.showMessageDialog(null, ex.toString());
	    }
	    
	}

public static  ArrayList<String> buscarPorPeriodo(String periodo) throws SQLException 
{
ArrayList<String> ret = new ArrayList<String>();
String periodo_ = periodo;

	Connection conn = null;

        String dbURL = "jdbc:sqlserver://MUÑOZV";
        String user = "Brayan";
        String pass = "12345";
        conn = DriverManager.getConnection(dbURL, user, pass);
        if (conn != null) {
            System.out.println("Conexion establecida ");
        			      }
     String query = "select * FROM PeriodoAcademico WHERE [Cod PeriodoAcad] = ".concat(periodo_);
    try (Statement stmt = conn.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        String Periodo = rs.getString("Cod PeriodoAcad");
        String Descripcion    = rs.getString("Descripcion");
        String Inicio    = rs.getString("FechaInicio");
        String Fin  = rs.getString("FechaFin");
        String InicioClases  = rs.getString("FechaInicioClases");
        
        String FinClases    = rs.getString("FechaFinClases");
        String Pago  = rs.getString("FechaLimitePago");
        String  Prematricula  = rs.getString("FechaLimitePrematricula");
        String Retiro  = rs.getString("FechaLimiteRetiro");
        String Publicacion  = rs.getString("FechaLimitePublicacion"); 
     
        ret.add(Periodo);
     ret.add(Descripcion);
     ret.add(Inicio);
     ret.add(Fin);
     ret.add(InicioClases);
     ret.add(FinClases);
     ret.add(Pago);
     ret.add(Prematricula);
     ret.add(Retiro);
     ret.add(Publicacion);
     
      }
    } 



return ret;

}


private void clean() {
	txtPerAcad.setText("");
	txtDescripcion.setText(""); 
	ftxtInicioPeriodo.setText("");
	ftxtFinPeriodo.setText("");				
    ftxtInicioClases.setText("");
    ftxtFinClases.setText("");
    ftxtLimitePago.setText("");
    ftxtLimitePrem.setText("");
    ftxtLimiteRetiro.setText("");
    ftxtLimitePublicacion.setText("");
	
}
}
