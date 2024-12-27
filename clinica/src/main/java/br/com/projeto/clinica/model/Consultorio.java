package br.com.projeto.clinica.model;

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
public class Consultorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codConsultorio;
	
	@Column(nullable = false,length = 40)
	private String nomeConsultorio;
	
	@OneToMany(mappedBy = "consultorio",cascade = CascadeType.REMOVE)
	private Set<Consulta> consultas;

	
	public Consultorio() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Consultorio(Integer codConsultorio, String nomeConsultorio, Set<Consulta> consultas) {
		super();
		this.codConsultorio = codConsultorio;
		this.nomeConsultorio = nomeConsultorio;
		this.consultas = consultas;
	}


	public Integer getCodConsultorio() {
		return codConsultorio;
	}


	public void setCodConsultorio(Integer codConsultorio) {
		this.codConsultorio = codConsultorio;
	}


	public String getNomeConsultorio() {
		return nomeConsultorio;
	}


	public void setNomeConsultorio(String nomeConsultorio) {
		this.nomeConsultorio = nomeConsultorio;
	}


	public Set<Consulta> getConsultas() {
		return consultas;
	}


	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codConsultorio);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consultorio other = (Consultorio) obj;
		return Objects.equals(codConsultorio, other.codConsultorio);
	}


	@Override
	public String toString() {
		return "Consultorio [codConsultorio=" + codConsultorio + ", nomeConsultorio=" + nomeConsultorio + ", consultas="
				+ consultas + "]";
	}
	
	
	
	
}
