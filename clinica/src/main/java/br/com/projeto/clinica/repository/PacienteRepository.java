package br.com.projeto.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.clinica.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
