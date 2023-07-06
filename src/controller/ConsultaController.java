package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import connection.ConnectionFactoryMySQL;
import dao.ConsultaDAO;
import model.Consulta;

public class ConsultaController extends Thread{
	
	Connection con;
	
	private volatile boolean rodando;

    
    
    public ConsultaController(boolean rodando) {
		super();
		this.rodando = rodando;
	}

	@Override
    public void run(){
        Random random = new Random();
        
        while(rodando){
            System.out.println("Buscando informações...");
            
           try{
        	   Thread.sleep(2000);
        	   Read();
               pararExecussao();
               
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
        	   Thread.sleep(2000);
        	   ConsultaDAO dao = new ConsultaDAO();
        	   dao.Create(consulta, null);
               pararExecussao();
               
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
     
     
     
   public ArrayList<Consulta> Read(){
	   ConnectionFactoryMySQL.getInstancia();
		con = ConnectionFactoryMySQL.getConexao();
	   
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM consulta";
			ArrayList<Consulta> consultas = new ArrayList<>();
			
			try {
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				System.out.println("Dados capturados com sucesso!");
				
				while(rs.next()) {
					Consulta c = new Consulta();
					c.setId(rs.getInt("id"));
					c.setPaciente(rs.getString("paciente"));
					c.setMedico(rs.getString("medico"));
					c.setDia(rs.getString("dia"));
					c.setHora(rs.getString("hora"));
					c.setPlano(rs.getInt("plano"));
					consultas.add(c);
				}
				
				System.out.println("passou do while");
			} catch (SQLException e ){
				System.out.println("Falha ao consultar dados. erro: "
							+ e.getMessage());
			}
			return consultas;
		}
   
 //Método Consultar por descricao
 	public ArrayList<Consulta> ConsultarPorPaciente(String name){
 		ConnectionFactoryMySQL.getInstancia();
 		con = ConnectionFactoryMySQL.getConexao();
 		
 		PreparedStatement stmt = null;
 		ResultSet rs = null;
 		String sql = "SELECT * FROM consulta WHERE paciente like '%" + name + "%'";
 		ArrayList<Consulta> consultas = new ArrayList<>();
 		try {
 			stmt = con.prepareStatement(sql);
 			rs = stmt.executeQuery();
 			System.out.println("Dados capturados com sucesso!");
 			
 			while(rs.next()) {
 				Consulta c = new Consulta();
 				c.setId(rs.getInt("id"));
 				c.setPaciente(rs.getString("paciente"));
 				c.setMedico(rs.getString("medico"));
 				c.setDia(rs.getString("dia"));
 				c.setHora(rs.getString("hora"));
 				c.setPlano(rs.getInt("plano"));
 				consultas.add(c);
 			}
 		} catch(SQLException e) {
 			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
 		}
 		return consultas;
 	}


}
