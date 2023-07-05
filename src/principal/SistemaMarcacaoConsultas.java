package principal;

import controller.ConsultaController;
import model.Consulta;
import view.TelaThread;

public class SistemaMarcacaoConsultas {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		//ConsultaThread consulta = new ConsultaThread();
		TelaThread tela = new TelaThread();
		
		//consulta.start();
		tela.start();
/*
		try {
			Thread.sleep(30000);// 30 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
*/
		//consulta.pararExecussao();

	}

}
