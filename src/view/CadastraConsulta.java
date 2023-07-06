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
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CadastraConsulta extends Thread{

	private JFrame frmCadastro;
	private JTextField txtPaciente;
	private JTextField txtMedico;
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtPlano;


	public JFrame getFrmCadastro() {
		return frmCadastro;
	}

	public void setFrmCadastro(JFrame frmCadastro) {
		this.frmCadastro = frmCadastro;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraConsulta window = new CadastraConsulta();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastraConsulta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.getContentPane().setBackground(new Color(255, 128, 128));
		frmCadastro.setBounds(100, 100, 358, 441);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(0, 0, 344, 404);
		frmCadastro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("Cadastrar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paciente = txtPaciente.getText();
				String medico = txtMedico.getText();
				String dia = txtData.getText();
				String hora = txtHora.getText();
				String op =  txtPlano.getText().toLowerCase();
				Integer plano = 0;
				
				if(op.equals("sim")) {
					plano = 1;
				} else if (op.equals("não")) {
					plano = 0;
				} else {
					JOptionPane.showMessageDialog( txtPlano, "Valor Inválido.\nEspera-se sim ou não." );
				}
				
				Consulta consulta = new Consulta( paciente, medico, dia, hora, plano);
				ConsultaController thread = new ConsultaController(true);
				thread.run(consulta);
				frmCadastro.dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBackground(new Color(128, 128, 255));
		btnSair.setBounds(221, 348, 102, 35);
		panel.add(btnSair);
		
		JLabel lblTexto = new JLabel("Cadatro de Consultas:");
		lblTexto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTexto.setBounds(23, 20, 286, 35);
		panel.add(lblTexto);
		
		JLabel lblNewLabel = new JLabel("Paciente: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 81, 62, 35);
		panel.add(lblNewLabel);
		
		txtPaciente = new JTextField();
		txtPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPaciente.setBounds(93, 81, 230, 29);
		panel.add(txtPaciente);
		txtPaciente.setColumns(10);
		
		JLabel lblMedico = new JLabel("Medico:");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedico.setBounds(23, 140, 62, 35);
		panel.add(lblMedico);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDia.setBounds(23, 198, 62, 35);
		panel.add(lblDia);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHora.setBounds(23, 251, 62, 35);
		panel.add(lblHora);
		
		JLabel lblPlano = new JLabel("Plano:");
		lblPlano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlano.setBounds(23, 306, 62, 35);
		panel.add(lblPlano);
		
		txtMedico = new JTextField();
		txtMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMedico.setColumns(10);
		txtMedico.setBounds(93, 143, 230, 29);
		panel.add(txtMedico);
		
		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setColumns(10);
		txtData.setBounds(93, 201, 230, 29);
		panel.add(txtData);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHora.setColumns(10);
		txtHora.setBounds(93, 254, 230, 29);
		panel.add(txtHora);
	
		txtPlano = new JTextField();
		txtPlano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPlano.setColumns(10);
		txtPlano.setBounds(93, 309, 230, 29);
		panel.add(txtPlano);
		
		
	}
}
