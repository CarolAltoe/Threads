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

public class TelaThread extends Thread{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaThread window = new TelaThread();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaThread() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 128, 128));
		frame.setBounds(100, 100, 358, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(0, 0, 344, 404);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAgendar = new JButton("Agendar Consulta");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				CadastraConsulta telaCadastro = new CadastraConsulta();
				telaCadastro.getFrmCadastro().setVisible(true);
			}
		});
		btnAgendar.setBackground(new Color(128, 128, 255));
		btnAgendar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgendar.setBounds(63, 140, 206, 50);
		panel.add(btnAgendar);
		
		JButton btnVisualizar = new JButton("Visualizar agendamentos");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiltraConsulta telaFiltrar = new FiltraConsulta();
				telaFiltrar.getFrmFiltrar().setVisible(true);
			}
		});
		btnVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVisualizar.setBackground(new Color(128, 128, 255));
		btnVisualizar.setBounds(63, 225, 206, 50);
		panel.add(btnVisualizar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaController consulta = new ConsultaController();
				consulta.pararExecussao();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBackground(new Color(128, 128, 255));
		btnSair.setBounds(63, 303, 206, 50);
		panel.add(btnSair);
		
		JLabel lblTexto = new JLabel("Sistema de marcação de consultas");
		lblTexto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTexto.setBounds(34, 24, 286, 55);
		panel.add(lblTexto);
		
		JLabel lblSejaBemvindo = new JLabel("Seja bem-vindo!");
		lblSejaBemvindo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSejaBemvindo.setBounds(95, 68, 146, 50);
		panel.add(lblSejaBemvindo);
	}
}
