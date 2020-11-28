package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Logica.Asignatura;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegAsignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodAsignatura;
	private JTextField txtNombreAsignatura;
	
	JSpinner spnCreditos;
	JSpinner spnHrTeoricas;
	JSpinner spnHrPracticas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegAsignatura dialog = new RegAsignatura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegAsignatura() {
		setTitle("Registrar Asignatura");
		setBounds(100, 100, 388, 296);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCodAsignatura = new JLabel("Cod Asignatura:");
			lblCodAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodAsignatura.setFont(new Font("Courier New", Font.BOLD, 12));
			lblCodAsignatura.setBounds(108, 11, 146, 14);
			panel.add(lblCodAsignatura);
			
			txtCodAsignatura = new JTextField();
			txtCodAsignatura.setBounds(113, 28, 136, 20);
			panel.add(txtCodAsignatura);
			txtCodAsignatura.setColumns(10);
			
			JLabel lblNombreAsignatura = new JLabel("Nombre Asignatura:");
			lblNombreAsignatura.setFont(new Font("Courier New", Font.BOLD, 12));
			lblNombreAsignatura.setBounds(10, 78, 146, 14);
			panel.add(lblNombreAsignatura);
			
			txtNombreAsignatura = new JTextField();
			txtNombreAsignatura.setColumns(10);
			txtNombreAsignatura.setBounds(20, 95, 136, 20);
			panel.add(txtNombreAsignatura);
			
			JLabel lblCreditos = new JLabel("Creditos:");
			lblCreditos.setFont(new Font("Courier New", Font.BOLD, 12));
			lblCreditos.setBounds(206, 78, 146, 14);
			panel.add(lblCreditos);
			
			 spnCreditos = new JSpinner();
			spnCreditos.setBounds(216, 95, 136, 20);
			panel.add(spnCreditos);
			
			JLabel lblHorasTeoricas = new JLabel("Horas Teoricas:");
			lblHorasTeoricas.setFont(new Font("Courier New", Font.BOLD, 12));
			lblHorasTeoricas.setBounds(10, 145, 146, 14);
			panel.add(lblHorasTeoricas);
			
			JLabel lblHorasPracticas = new JLabel("Horas Practicas:");
			lblHorasPracticas.setFont(new Font("Courier New", Font.BOLD, 12));
			lblHorasPracticas.setBounds(206, 145, 146, 14);
			panel.add(lblHorasPracticas);
			
			spnHrPracticas = new JSpinner();
			spnHrPracticas.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
			spnHrPracticas.setBounds(216, 162, 136, 20);
			panel.add(spnHrPracticas);
			
			spnHrTeoricas = new JSpinner();
			spnHrTeoricas.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
			spnHrTeoricas.setBounds(20, 162, 136, 20);
			panel.add(spnHrTeoricas);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnInsertar = new JButton("Insertar");
				btnInsertar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(txtCodAsignatura.getText().isEmpty() || txtNombreAsignatura.getText().isEmpty() || spnCreditos.getValue().toString().equalsIgnoreCase("0")) {
							JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
						} 
						else {
							Asignatura.InsertarAsignatura(txtCodAsignatura.getText(), txtNombreAsignatura.getText(), Integer.parseInt(spnCreditos.getValue().toString()), Integer.parseInt(spnHrTeoricas.getValue().toString()), Integer.parseInt( spnHrPracticas.getValue().toString()));
							JOptionPane.showMessageDialog(null, "Asignatura Insertada!  ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
							
						} 
						
					}
				});
				btnInsertar.setActionCommand("OK");
				buttonPane.add(btnInsertar);
				getRootPane().setDefaultButton(btnInsertar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
