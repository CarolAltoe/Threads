package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import controller.ConsultaController;
import model.Consulta;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FiltraConsulta extends Thread{

	private JFrame frmFiltrar;
	private JTextField txtPaciente;
	private JTable table;

	public JFrame getFrmFiltrar() {
		return frmFiltrar;
	}

	public void setFrmFiltrar(JFrame frmFiltrar) {
		this.frmFiltrar = frmFiltrar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiltraConsulta window = new FiltraConsulta();
					window.frmFiltrar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void atualizaBusca() {
		//ConsultaDAO cd = new ConsultaDAO();
		ConsultaController thread = new ConsultaController(true);
		System.out.println("status thread:" + thread.isRodando());
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		modelo.setNumRows(0);
		for(Consulta c: thread.ConsultarPorPaciente(txtPaciente.getText())) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getPaciente(),
					c.getMedico(),
					c.getDia(),
					c.getHora(),
					c.getPlano()
		});
		}
	}

	/**
	 * Create the application.
	 */
	public FiltraConsulta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFiltrar = new JFrame();
		frmFiltrar.getContentPane().setBackground(new Color(255, 128, 128));
		frmFiltrar.setBounds(100, 100, 586, 441);
		frmFiltrar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFiltrar.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(0, 0, 572, 404);
		frmFiltrar.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();
			}
		});
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFiltrar.setBackground(new Color(128, 128, 255));
		btnFiltrar.setBounds(456, 66, 88, 37);
		panel.add(btnFiltrar);
		
		JLabel lblTexto = new JLabel("Filtrar Consultas:");
		lblTexto.setBounds(27, 20, 286, 37);
		panel.add(lblTexto);
		lblTexto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNewLabel = new JLabel("Paciente: ");
		lblNewLabel.setBounds(27, 67, 62, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(99, 70, 347, 29);
		panel.add(txtPaciente);
		txtPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPaciente.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 128, 517, 242);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Id Consulta", "Paciente", "Medico", "Data", "Hora", "Plano"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.setAutoCreateRowSorter(true);
	}
}
