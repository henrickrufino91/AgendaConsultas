package br.com.projeto.clinica.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codUsuario;
	
	@Column(nullable = false,length = 40)
	private String nome;
	
	@Column(nullable = false,length = 40)
	private String email;
	
	@Column(nullable = false,length = 40)
	private String senha;
	
	@Column(nullable = false)
	private Integer foneUsuario;

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(Integer codUsuario, String nome, String email, String senha, Integer foneUsuario) {
		super();
		this.codUsuario = codUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foneUsuario = foneUsuario;
	}


	public Integer getCodUsuario() {
		return codUsuario;
	}


	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Integer getFoneUsuario() {
		return foneUsuario;
	}


	public void setFoneUsuario(Integer foneUsuario) {
		this.foneUsuario = foneUsuario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codUsuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(codUsuario, other.codUsuario);
	}


	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", foneUsuario=" + foneUsuario + "]";
	}
	
	
	
}
