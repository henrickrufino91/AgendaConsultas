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
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codStatus;
	
	@Column(nullable = false,length = 30)
	private String descricao;
	
	
	@OneToMany(mappedBy = "status",cascade = CascadeType.REMOVE)
	private Set<Consulta> consultas;


	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Status(Integer codStatus, String descricao, Set<Consulta> consultas) {
		super();
		this.codStatus = codStatus;
		this.descricao = descricao;
		this.consultas = consultas;
	}


	public Integer getCodStatus() {
		return codStatus;
	}


	public void setCodStatus(Integer codStatus) {
		this.codStatus = codStatus;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Set<Consulta> getConsultas() {
		return consultas;
	}


	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codStatus);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		return Objects.equals(codStatus, other.codStatus);
	}


	@Override
	public String toString() {
		return "Status [codStatus=" + codStatus + ", descricao=" + descricao + ", consultas=" + consultas + "]";
	}
	
	
	
}
