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
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codMedico;
	
	@Column(nullable = false,length = 40)
	private String nomeMedico;
	
	@Column(nullable = false)
	private Integer crm;
	
	@Column(nullable = false,length = 30)
	private String especialidade;
	
	@Column(nullable = false,length = 30)
	private String emailMedico;
	
	@Column(nullable = false)
	private Integer foneMedico;

	@OneToMany(mappedBy = "medico",cascade = CascadeType.REMOVE)
	private Set<Consulta> consultas;

	
	
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Medico(Integer codMedico, String nomeMedico, Integer crm, String especialidade, String emailMedico,
			Integer foneMedico, Set<Consulta> consultas) {
		super();
		this.codMedico = codMedico;
		this.nomeMedico = nomeMedico;
		this.crm = crm;
		this.especialidade = especialidade;
		this.emailMedico = emailMedico;
		this.foneMedico = foneMedico;
		this.consultas = consultas;
	}



	public Integer getCodMedico() {
		return codMedico;
	}



	public void setCodMedico(Integer codMedico) {
		this.codMedico = codMedico;
	}



	public String getNomeMedico() {
		return nomeMedico;
	}



	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}



	public Integer getCrm() {
		return crm;
	}



	public void setCrm(Integer crm) {
		this.crm = crm;
	}



	public String getEspecialidade() {
		return especialidade;
	}



	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}



	public String getEmailMedico() {
		return emailMedico;
	}



	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}



	public Integer getFoneMedico() {
		return foneMedico;
	}



	public void setFoneMedico(Integer foneMedico) {
		this.foneMedico = foneMedico;
	}



	public Set<Consulta> getConsultas() {
		return consultas;
	}



	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}



	@Override
	public int hashCode() {
		return Objects.hash(codMedico);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(codMedico, other.codMedico);
	}



	@Override
	public String toString() {
		return "Medico [codMedico=" + codMedico + ", nomeMedico=" + nomeMedico + ", crm=" + crm + ", especialidade="
				+ especialidade + ", emailMedico=" + emailMedico + ", foneMedico=" + foneMedico + ", consultas="
				+ consultas + "]";
	}
	
	
}
