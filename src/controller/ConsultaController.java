package controller;

import java.util.Random;

import dao.ConsultaDAO;

public class ConsultaController extends Thread{
	private volatile boolean rodando;

    public void Consulta(model.Consulta consulta) {
        this.rodando = true;
    }
    @Override
    public void run(){
        Random random = new Random();
        
        while(rodando){
            System.out.println("Buscando informações...");
            
           try{
        	 //verificar se chamo a dao antes ou depois de dar sleeep
        	   ConsultaDAO dao = new ConsultaDAO();
        	   dao.Read();
               Thread.sleep(2000);
               
            } catch(InterruptedException e) { 
                e.printStackTrace();
            }
        } 
    }
    
    public void run(model.Consulta consulta){
        Random random = new Random();
        
        while(rodando){
            System.out.println("Cadastrando...");
            
           try{
        	   //verificar se chamo a dao antes ou depois de dar sleeep
        	   ConsultaDAO dao = new ConsultaDAO();
        	   dao.Create(consulta, null);
               Thread.sleep(2000);
               
            } catch(InterruptedException e) { 
                e.printStackTrace();
            }
        } 
    }
    
    
    public void pararExecussao(){
        rodando = false;
    }
      
     public boolean isRodando(){
        return rodando;
    }
}
