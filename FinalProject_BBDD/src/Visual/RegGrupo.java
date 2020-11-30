package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Grupo;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class RegGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPerAcad;
	private JTextField txtCodAsignatura;
	private JTextField txtNumGrupo;
	private JTextField txtCupoGrupo;
	private static JTable tblGrupos;
	private String auxPer;
	private String auxAsig;
	private String auxGrupo;
	JButton btnHorarioGrupo;
	JButton btnInsertar;
	JButton btnModificar;

	private int index;
	
	private static DefaultTableModel model; 
	private static Object[] fila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegGrupo dialog = new RegGrupo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegGrupo() {
		setTitle("Grupos");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarGrupos();
			}
		});
		setBounds(100, 100, 587, 496);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBounds(10, 11, 551, 154);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCodPerAcad = new JLabel("Codigo Periodo Academico:");
				lblCodPerAcad.setFont(new Font("Courier New", Font.BOLD, 12));
				lblCodPerAcad.setBounds(10, 11, 183, 14);
				panel.add(lblCodPerAcad);
			}
			{
				txtPerAcad = new JTextField();
				txtPerAcad.setBounds(10, 24, 173, 20);
				panel.add(txtPerAcad);
				txtPerAcad.setColumns(10);
			}
			{
				JLabel lblAsignatura = new JLabel("Codigo Asignatura:");
				lblAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
				lblAsignatura.setFont(new Font("Courier New", Font.BOLD, 12));
				lblAsignatura.setBounds(10, 55, 173, 14);
				panel.add(lblAsignatura);
			}
			{
				txtCodAsignatura = new JTextField();
				txtCodAsignatura.setColumns(10);
				txtCodAsignatura.setBounds(10, 68, 173, 20);
				panel.add(txtCodAsignatura);
			}
			{
				JLabel lblNumGrupo = new JLabel("Numero Grupo:");
				lblNumGrupo.setHorizontalAlignment(SwingConstants.CENTER);
				lblNumGrupo.setFont(new Font("Courier New", Font.BOLD, 12));
				lblNumGrupo.setBounds(10, 105, 173, 14);
				panel.add(lblNumGrupo);
			}
			{
				txtNumGrupo = new JTextField();
				txtNumGrupo.setColumns(10);
				txtNumGrupo.setBounds(10, 123, 173, 20);
				panel.add(txtNumGrupo);
			}
			{
				JLabel lblCupoGrupo = new JLabel("Cupo Grupo:");
				lblCupoGrupo.setHorizontalAlignment(SwingConstants.CENTER);
				lblCupoGrupo.setFont(new Font("Courier New", Font.BOLD, 12));
				lblCupoGrupo.setBounds(223, 11, 145, 14);
				panel.add(lblCupoGrupo);
			}
			{
				txtCupoGrupo = new JTextField();
				txtCupoGrupo.setColumns(10);
				txtCupoGrupo.setBounds(223, 24, 145, 20);
				panel.add(txtCupoGrupo);
			}
			{
				btnInsertar = new JButton("Insertar");
				btnInsertar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (txtPerAcad.getText().isEmpty() || txtCodAsignatura.getText().isEmpty() || txtNumGrupo.getText().isEmpty() || txtCupoGrupo.getText().isEmpty())
						{
						JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios! ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						}

						else {
							Grupo.InsertarGrupo(txtPerAcad.getText(), txtCodAsignatura.getText(), txtNumGrupo.getText(), Integer.parseInt(txtCupoGrupo.getText()), "");
							JOptionPane.showMessageDialog(null, "Grupo Insertado! ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
							
							try {
								if(buscarGrupoHorario(txtPerAcad.getText(),txtCodAsignatura.getText(),txtNumGrupo.getText()).isBlank()){
									int dialogButton = JOptionPane.YES_NO_OPTION;
									JOptionPane.showConfirmDialog (null, "El grupo no tiene horario programado, desea crearlo ?","Advertencia",dialogButton);
										if (dialogButton == JOptionPane.YES_OPTION) { 
											RegHorario h1 = new RegHorario(txtPerAcad.getText(),txtCodAsignatura.getText(),txtNumGrupo.getText());
											h1.setModal(true);
											h1.setVisible(true);
											
										}
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							Clean();
							cargarGrupos();
							
						} 
					
						
								
							
					
						
						
					}

				
				});
				btnInsertar.setBounds(223, 80, 145, 63);
				panel.add(btnInsertar);
			}
			
			btnHorarioGrupo = new JButton("Horario Grupo");
			btnHorarioGrupo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegHorario h2 = new RegHorario(txtPerAcad.getText(), txtCodAsignatura.getText(), txtNumGrupo.getText());
					h2.setModal(true);
					h2.setVisible(true);
					
				}
			});
			btnHorarioGrupo.setEnabled(false);
			btnHorarioGrupo.setBounds(390, 11, 151, 96);
			panel.add(btnHorarioGrupo);
			
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setForeground(Color.BLACK);
			separator.setBounds(378, 11, 10, 132);
			panel.add(separator);
			
			JLabel lblHorario = new JLabel("Insertar Horario \r\n");
			lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
			lblHorario.setFont(new Font("Courier New", Font.BOLD, 12));
			lblHorario.setBounds(390, 111, 151, 14);
			panel.add(lblHorario);
			
			JLabel lblAlGrupo = new JLabel("al Grupo");
			lblAlGrupo.setHorizontalAlignment(SwingConstants.CENTER);
			lblAlGrupo.setFont(new Font("Courier New", Font.BOLD, 12));
			lblAlGrupo.setBounds(390, 126, 151, 14);
			panel.add(lblAlGrupo);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Listado de Grupos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 176, 551, 237);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					tblGrupos = new JTable();
					tblGrupos.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							index = tblGrupos.getSelectedRow();
							if(index >= 0) { 
							    auxPer = (String)tblGrupos.getModel().getValueAt(index, 0).toString();
							    auxAsig = (String)tblGrupos.getModel().getValueAt(index, 1).toString();
							    auxGrupo = (String)tblGrupos.getModel().getValueAt(index, 2).toString();
								
							    
							    try {
									ArrayList<String> aux = buscarGrupoHorario1(auxPer, auxAsig, auxGrupo);
									txtPerAcad.setText(aux.get(0));
									txtCodAsignatura.setText(aux.get(1));
									txtNumGrupo.setText(aux.get(2));
									txtCupoGrupo.setText(aux.get(3));
									btnHorarioGrupo.setEnabled(true);
									btnInsertar.setEnabled(false);
									btnModificar.setEnabled(true);
									
									
									
								
									

									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							    txtPerAcad.setEditable(false);
							    txtCodAsignatura.setEditable(false);
							    txtNumGrupo.setEditable(false);
							    txtCupoGrupo.setEditable(false);
							
							   
							}
							
							
						}

						
					});
					scrollPane.setViewportView(tblGrupos);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
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
	
public static void cargarGrupos() {
		
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
	         String query = "SELECT G.CodPeriodoAcad as 'Per. Academico', G.[Cod Asignatura] as 'Cod. Asignatura', G.NumGrupo as 'No. Grupo', G.Horario\r\n" + 
	         		"FROM GRUPO G";
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
	        tblGrupos.setModel(tableModel);
	    
	    conn.close();
	    }
	    catch(Exception ex)
	    {
	    JOptionPane.showMessageDialog(null, ex.toString());
	    }
	}

private void Clean() {
	txtPerAcad.setText("");
	txtCodAsignatura.setText("");
	txtNumGrupo.setText("");
	txtCupoGrupo.setText("");

	
}

public static  String buscarGrupoHorario (String periodo_,String asignatura_,String grupo_) throws SQLException 
{
String ret = null;
String per = periodo_;
String asig = asignatura_;
String grupo = grupo_;

	Connection conn = null;

       String dbURL = "jdbc:sqlserver://MUÑOZV";
       String user = "Brayan";
       String pass = "12345";
       conn = DriverManager.getConnection(dbURL, user, pass);
       if (conn != null) {
           System.out.println("Conexion establecida ");
       			      }
    String query = "Select G.Horario from Grupo G\r\n" + 
    		"Where G.[Cod Asignatura] ='".concat(asig+"'")+"AND G.CodPeriodoAcad = '".concat(per+"'")+" AND G.NumGrupo = '".concat(grupo+"'");
    
    try (Statement stmt = conn.createStatement()) {
     ResultSet rs = stmt.executeQuery(query);
     while (rs.next()) {
       String Horario = rs.getString("Horario");
    
        
    ret = Horario;
     }
   } 



return ret;

}

private ArrayList<String> buscarGrupoHorario1(String auxPer, String auxAsig, String auxGrupo) throws SQLException {
	 ArrayList<String> ret = new ArrayList<String>();
	String per = auxPer;
	String asig = auxAsig;
	String grupo = auxGrupo;

		Connection conn = null;

	       String dbURL = "jdbc:sqlserver://MUÑOZV";
	       String user = "Brayan";
	       String pass = "12345";
	       try {
			conn = DriverManager.getConnection(dbURL, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       if (conn != null) {
	           System.out.println("Conexion establecida ");
	       			      }
	    String query = "Select * from Grupo G\r\n" + 
	    		"Where G.[Cod Asignatura] ='".concat(asig+"'")+"AND G.CodPeriodoAcad = '".concat(per+"'")+" AND G.NumGrupo = '".concat(grupo+"'");
	    
	    try (Statement stmt = conn.createStatement()) {
	     ResultSet rs = stmt.executeQuery(query);
	     while (rs.next()) {
	       String perA = rs.getString("CodPeriodoAcad");
	       String codA = rs.getString("Cod Asignatura");
	       String numG = rs.getString("NumGrupo");
	       int cupoG = rs.getInt("CupoGrupo");
	       
	       	ret.add(perA);
	       	ret.add(codA);
	       	ret.add(numG);
	        ret.add(Integer.toString(cupoG));
	    
	        
	  
	     }
	   } 



	return ret;
}
}
