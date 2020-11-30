package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import Logica.GrupoHorario;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegHorario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodPerAcad;
	private JTextField txtCodigoAsignatura;
	private JTextField txtNumGrupo;
	private JTextField txtHoraInicial;
	private JTextField txtHoraFinal;
	JSpinner spnDia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the dialog.
	 */
	public RegHorario(String codPer, String codAsig, String numGrupo) {
		String periodo_ = codPer;
		String asignatura_ = codAsig;
		String grupo_ = numGrupo;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtCodigoAsignatura.setText(asignatura_);
				txtCodPerAcad.setText(periodo_);
				txtNumGrupo.setText(grupo_);
			}
		});
	
		
		setTitle("Horarios");
		setBounds(100, 100, 388, 296);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCodPerAcad = new JLabel("Cod. Periodo Academico:");
			lblCodPerAcad.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodPerAcad.setFont(new Font("Courier New", Font.BOLD, 12));
			lblCodPerAcad.setBounds(0, 11, 187, 14);
			panel.add(lblCodPerAcad);
			
			txtCodPerAcad = new JTextField();
			txtCodPerAcad.setEditable(false);
			txtCodPerAcad.setBounds(20, 36, 146, 20);
			panel.add(txtCodPerAcad);
			txtCodPerAcad.setColumns(10);
			
			JLabel lblCodAsignatura = new JLabel("Cod. Asignatura:");
			lblCodAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodAsignatura.setFont(new Font("Courier New", Font.BOLD, 12));
			lblCodAsignatura.setBounds(20, 78, 146, 14);
			panel.add(lblCodAsignatura);
			
			txtCodigoAsignatura = new JTextField();
			txtCodigoAsignatura.setEditable(false);
			txtCodigoAsignatura.setColumns(10);
			txtCodigoAsignatura.setBounds(20, 95, 146, 20);
			panel.add(txtCodigoAsignatura);
			
			JLabel lblNumGrupo = new JLabel("No. Grupo:");
			lblNumGrupo.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumGrupo.setFont(new Font("Courier New", Font.BOLD, 12));
			lblNumGrupo.setBounds(216, 11, 136, 14);
			panel.add(lblNumGrupo);
			
			JLabel lblDia = new JLabel("Dia");
			lblDia.setHorizontalAlignment(SwingConstants.CENTER);
			lblDia.setFont(new Font("Courier New", Font.BOLD, 12));
			lblDia.setBounds(20, 145, 146, 14);
			panel.add(lblDia);
			
			JLabel lblHoraInicial = new JLabel("Hora Inicial:");
			lblHoraInicial.setHorizontalAlignment(SwingConstants.CENTER);
			lblHoraInicial.setFont(new Font("Courier New", Font.BOLD, 12));
			lblHoraInicial.setBounds(216, 78, 136, 14);
			panel.add(lblHoraInicial);
			
			txtNumGrupo = new JTextField();
			txtNumGrupo.setEditable(false);
			txtNumGrupo.setBounds(216, 36, 136, 20);
			panel.add(txtNumGrupo);
			txtNumGrupo.setColumns(10);
			
			txtHoraInicial = new JTextField();
			txtHoraInicial.setColumns(10);
			txtHoraInicial.setBounds(216, 95, 136, 20);
			panel.add(txtHoraInicial);
			
			spnDia = new JSpinner();
			spnDia.setModel(new SpinnerNumberModel(0, 0, 6, 1));
			spnDia.setBounds(20, 161, 146, 20);
			panel.add(spnDia);
			
			JLabel lblHoraFinal = new JLabel("Hora Final:");
			lblHoraFinal.setHorizontalAlignment(SwingConstants.CENTER);
			lblHoraFinal.setFont(new Font("Courier New", Font.BOLD, 12));
			lblHoraFinal.setBounds(216, 144, 136, 14);
			panel.add(lblHoraFinal);
			
			txtHoraFinal = new JTextField();
			txtHoraFinal.setColumns(10);
			txtHoraFinal.setBounds(216, 161, 136, 20);
			panel.add(txtHoraFinal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnInsertar = new JButton("Insertar");
				btnInsertar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(txtCodPerAcad.getText().isEmpty() || txtCodigoAsignatura.getText().isEmpty() || txtHoraInicial.getText().isEmpty() || txtHoraFinal.getText().isEmpty() || txtNumGrupo.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
						} 
						else {
							GrupoHorario.InsertarGrupoHorario(txtCodPerAcad.getText(), txtCodigoAsignatura.getText(), txtNumGrupo.getText(), Integer.parseInt(spnDia.getValue().toString()),java.sql.Time.valueOf(txtHoraInicial.getText()), java.sql.Time.valueOf(txtHoraFinal.getText()));
							JOptionPane.showMessageDialog(null, "Horario Insertado !!  ", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
							RegGrupo.cargarGrupos();
							dispose();
						
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
