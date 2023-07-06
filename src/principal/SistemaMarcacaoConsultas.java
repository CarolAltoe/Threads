package principal;

import controller.ConsultaController;
import model.Consulta;
import view.TelaThread;

public class SistemaMarcacaoConsultas {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		ConsultaController consulta = new ConsultaController(true);
		TelaThread tela = new TelaThread();
		
		consulta.start();
		tela.start();
		
		tela.getFrame().setVisible(true);

		//consulta.pararExecussao();

	}

}
