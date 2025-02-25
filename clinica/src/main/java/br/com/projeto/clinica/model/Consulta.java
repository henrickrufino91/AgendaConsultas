package br.com.projeto.clinica.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codConsulta;
	
	@Column(nullable = false)
	private LocalDate dataConsulta;
	
	@Column(nullable = false)
	private LocalTime inicioConsulta;
	
	@Column(nullable = true)
	private LocalTime fimConsulta;
	
	@Column(nullable = false,length = 200)
	private String observacoes;
	
	
	@ManyToOne
	@JoinColumn(name = "medico_codigo",nullable = false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "paciente_codigo",nullable = false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "status_codigo",nullable = false)
	private Status status;

	
	@ManyToOne
	@JoinColumn(name = "consultorio_codigo",nullable = false)
	private Consultorio consultorio;


	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Consulta(Integer codConsulta, LocalDate dataConsulta, LocalTime inicioConsulta, LocalTime fimConsulta,
			String observacoes, Medico medico, Paciente paciente, Status status, Consultorio consultorio) {
		super();
		this.codConsulta = codConsulta;
		this.dataConsulta = dataConsulta;
		this.inicioConsulta = inicioConsulta;
		this.fimConsulta = fimConsulta;
		this.observacoes = observacoes;
		this.medico = medico;
		this.paciente = paciente;
		this.status = status;
		this.consultorio = consultorio;
	}


	public Integer getCodConsulta() {
		return codConsulta;
	}


	public void setCodConsulta(Integer codConsulta) {
		this.codConsulta = codConsulta;
	}


	public LocalDate getDataConsulta() {
		return dataConsulta;
	}


	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}


	public LocalTime getInicioConsulta() {
		return inicioConsulta;
	}


	public void setInicioConsulta(LocalTime inicioConsulta) {
		this.inicioConsulta = inicioConsulta;
	}


	public LocalTime getFimConsulta() {
		return fimConsulta;
	}


	public void setFimConsulta(LocalTime fimConsulta) {
		this.fimConsulta = fimConsulta;
	}


	public String getObservacoes() {
		return observacoes;
	}


	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Consultorio getConsultorio() {
		return consultorio;
	}


	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codConsulta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(codConsulta, other.codConsulta);
	}


	@Override
	public String toString() {
		return "Consulta [codConsulta=" + codConsulta + ", dataConsulta=" + dataConsulta + ", inicioConsulta="
				+ inicioConsulta + ", fimConsulta=" + fimConsulta + ", observacoes=" + observacoes + ", medico="
				+ medico.getNomeMedico() + ", paciente=" + paciente.getNomePaciente() + ", status=" + status.getDescricao() + ", consultorio=" + consultorio.getNomeConsultorio() + "]";
	}

	
	


}
