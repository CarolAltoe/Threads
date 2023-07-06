package model;

public class Consulta extends Thread {

	private Integer id;
	private String paciente;
	private String medico;
	private String dia;
	private String hora;
	private Integer plano;
	
	
	public Consulta() {	}

	public Consulta( String paciente, String medico, String dia, String hora, Integer plano) {
		this.paciente = paciente;
		this.medico = medico;
		this.dia = dia;
		this.hora = hora;
		this.plano = plano;
	}
	
	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getPlano() {
		return plano;
	}
	public void setPlano(Integer plano) {
		this.plano = plano;
	}
	
	
	
	
}
