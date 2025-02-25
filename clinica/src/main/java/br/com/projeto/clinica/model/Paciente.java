package br.com.projeto.clinica.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPaciente;
	
	@Column(nullable = false,length = 40)
	private String nomePaciente;
	
	@Column(nullable = false)
	private Integer fonePaciente;
	
	@Column(nullable = false,length = 40)
	private String emailPaciente;
	
	@Column(nullable = false,length = 200)
	private String diagnostico;
	
	@Column(nullable = false)
	private LocalDate dataRegistro;
	
	
	@OneToMany(mappedBy = "paciente",cascade = CascadeType.REMOVE)
	private Set<Consulta> consultas;


	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Paciente(Integer codPaciente, String nomePaciente, Integer fonePaciente, String emailPaciente,
			String diagnostico, LocalDate dataRegistro, Set<Consulta> consultas) {
		super();
		this.codPaciente = codPaciente;
		this.nomePaciente = nomePaciente;
		this.fonePaciente = fonePaciente;
		this.emailPaciente = emailPaciente;
		this.diagnostico = diagnostico;
		this.dataRegistro = dataRegistro;
		this.consultas = consultas;
	}


	public Integer getCodPaciente() {
		return codPaciente;
	}


	public void setCodPaciente(Integer codPaciente) {
		this.codPaciente = codPaciente;
	}


	public String getNomePaciente() {
		return nomePaciente;
	}


	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}


	public Integer getFonePaciente() {
		return fonePaciente;
	}


	public void setFonePaciente(Integer fonePaciente) {
		this.fonePaciente = fonePaciente;
	}


	public String getEmailPaciente() {
		return emailPaciente;
	}


	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	public LocalDate getDataRegistro() {
		return dataRegistro;
	}


	
	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}


	
	
	
	
	
	
	public Set<Consulta> getConsultas() {
		return consultas;
	}


	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codPaciente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(codPaciente, other.codPaciente);
	}


	@Override
	public String toString() {
		return "Paciente [codPaciente=" + codPaciente + ", nomePaciente=" + nomePaciente + ", fonePaciente="
				+ fonePaciente + ", emailPaciente=" + emailPaciente + ", diagnostico=" + diagnostico + ", dataRegistro="
				+ dataRegistro + ", consultas=" + consultas + "]";
	}
	
	
}
