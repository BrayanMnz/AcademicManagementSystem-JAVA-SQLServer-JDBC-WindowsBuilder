package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Principal() {
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
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
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnEstudiante = new JMenu("Estudiantes");
				menuBar.add(mnEstudiante);
				{
					JMenuItem mntmAddStudent = new JMenuItem("Manejo de Estudiantes");
					mntmAddStudent.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegEstudiante cliente1 = new RegEstudiante();
							cliente1.setModal(true);
							cliente1.setVisible(true);
							
							//==============================
						}
					});
					mnEstudiante.add(mntmAddStudent);
				}
			}
			{
				JMenu mnGrupo = new JMenu("Grupos");
				menuBar.add(mnGrupo);
				{
					JMenuItem mntmGrupos = new JMenuItem("Manejo de Grupos");
					mntmGrupos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegGrupo g1 = new RegGrupo();
							g1.setModal(true);
							g1.setVisible(true);
						}
					});
					mnGrupo.add(mntmGrupos);
				}
			}
			{
				JMenu mnAsignatura = new JMenu("Asignatura");
				menuBar.add(mnAsignatura);
				{
					JMenuItem mntmRegAsignatura = new JMenuItem("Registrar Asignatura");
					mntmRegAsignatura.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegAsignatura a1 = new RegAsignatura();
							a1.setModal(true);
							a1.setVisible(true);
						}
					});
					mnAsignatura.add(mntmRegAsignatura);
				}
				{
					JMenuItem mntmListarAsignatura = new JMenuItem("Listar Asignatura");
					mntmListarAsignatura.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListarAsignaturas la1 = new ListarAsignaturas();
							la1.setVisible(true);
							la1.setModal(true);
						}
					});
					mnAsignatura.add(mntmListarAsignatura);
				}
			}
		}
	}

}
