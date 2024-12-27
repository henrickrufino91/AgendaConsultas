package br.com.projeto.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.clinica.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
