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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RegGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt;
	private JTextField txtCodAsignatura;
	private JTextField txtNumGrupo;
	private JTextField txtCupoGrupo;
	private JTextField txtHorario;
	private JTable tblGrupos;
	
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
				txt = new JTextField();
				txt.setBounds(10, 24, 173, 20);
				panel.add(txt);
				txt.setColumns(10);
			}
			{
				JLabel lblAsignatura = new JLabel("Codigo Asignatura:");
				lblAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
				lblAsignatura.setFont(new Font("Courier New", Font.BOLD, 12));
				lblAsignatura.setBounds(10, 67, 173, 14);
				panel.add(lblAsignatura);
			}
			{
				txtCodAsignatura = new JTextField();
				txtCodAsignatura.setColumns(10);
				txtCodAsignatura.setBounds(10, 80, 173, 20);
				panel.add(txtCodAsignatura);
			}
			{
				JLabel lblNumGrupo = new JLabel("Numero Grupo:");
				lblNumGrupo.setHorizontalAlignment(SwingConstants.CENTER);
				lblNumGrupo.setFont(new Font("Courier New", Font.BOLD, 12));
				lblNumGrupo.setBounds(10, 111, 173, 14);
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
				JLabel lblHorario = new JLabel("Horario:");
				lblHorario.setFont(new Font("Courier New", Font.BOLD, 12));
				lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
				lblHorario.setBounds(223, 63, 145, 14);
				panel.add(lblHorario);
			}
			{
				txtHorario = new JTextField();
				txtHorario.setBounds(223, 80, 145, 20);
				panel.add(txtHorario);
				txtHorario.setColumns(10);
			}
			{
				JButton btnInsertar = new JButton("Insertar");
				btnInsertar.setBounds(223, 111, 145, 32);
				panel.add(btnInsertar);
			}
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
					scrollPane.setViewportView(tblGrupos);
				}
			}
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
