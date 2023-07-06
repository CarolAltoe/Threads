package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connection.ConnectionFactoryMySQL;
import model.Consulta;


public class ConsultaDAO extends Thread {
	
		Connection con;
		
		public ConsultaDAO(){ 
			ConnectionFactoryMySQL.getInstancia();
			con = ConnectionFactoryMySQL.getConexao();	
		}
		
		//Metodo Create
		public void Create(Consulta c, JFrame tela) {
			PreparedStatement stmt = null;
			
			try {
				String sql = " INSERT INTO consulta "
						+ " (paciente, medico, dia, hora, plano) "
						+ " VALUES (?,?,?,?,?) ";
				
				stmt = con.prepareStatement(sql);
				stmt.setString(1,c.getPaciente());
				stmt.setString(2,c.getMedico());
				stmt.setString(3,c.getDia());
				stmt.setString(4,c.getHora());
				stmt.setInt(5, c.getPlano());
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(tela, "Consulta cadastrado com sucesso!");
				
			} catch(SQLException e){
				JOptionPane.showMessageDialog(tela, "Consulta não cadastrado. Erro: " 
													+ e.getMessage());
			}
		}

		//Metodo read
		public ArrayList<Consulta> Read(){
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

}
