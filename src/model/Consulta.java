package model;

public class Consulta extends Thread {

	private Integer id;
	private String paciente;
	private String medico;
	private String dia;
	private String hora;
	private Boolean plano;
	
	
	public Consulta() {	}

	public Consulta(Integer id, String paciente, String medico, String dia, String hora, Boolean plano) {
		this.id = id;
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
	public Boolean getPlano() {
		return plano;
	}
	public void setPlano(Boolean plano) {
		this.plano = plano;
	}
	
	
	
	
}
