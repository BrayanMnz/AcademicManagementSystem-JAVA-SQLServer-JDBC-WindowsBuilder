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

import Logica.Academica;
import Logica.Estudiante;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	private Estudiante miEstudiante;

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
			
			JButton btnInsertarEstudiante = new JButton("Insertar");
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
			btnInsertarEstudiante.setBounds(511, 140, 89, 23);
			panel_RegEstudiante.add(btnInsertarEstudiante);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
}
