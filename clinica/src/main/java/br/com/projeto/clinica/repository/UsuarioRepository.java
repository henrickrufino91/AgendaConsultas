package br.com.projeto.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projeto.clinica.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select j from Usuario j where j.email = :celular and j.senha = :senha")
	public Usuario buscarLogin(String celular,String senha);
	
	
}
