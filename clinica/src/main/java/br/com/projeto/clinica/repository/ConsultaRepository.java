package br.com.projeto.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projeto.clinica.model.Consulta;



@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

	
	@Query("select j from Consulta j where j.paciente.nomePaciente = :nome ")
	public List<Consulta> buscarConsulta(String nome);
	
	
	
	
	
}
