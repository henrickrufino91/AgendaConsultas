package br.com.projeto.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.clinica.model.Usuario;
import br.com.projeto.clinica.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public Usuario inserir(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	
	public void remover(Usuario usuario) {
		
		usuarioRepository.delete(usuario);
	}
	
	
	
	public void remover(Integer codigo) {
		
		usuarioRepository.deleteById(codigo);
	}
	
	
	public List<Usuario> listarUsuario(){

		return usuarioRepository.findAll();
		
	}
	
	public Usuario listarPorId(Integer codigo) {
		
		return usuarioRepository.findById(codigo).get();
	}
	
	
	public Usuario editar(Integer codigo) {
		
		  Optional<Usuario> u = usuarioRepository.findById(codigo);
			
		  Usuario usuario = null;
		  
		  if (u.isPresent()) {
			  
			  usuario = u.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Usuario não existe :: " + codigo);
		  }
		  
		  return usuario;
		}
	
	
	
	public Usuario login(String email,String senha) {
		
		return usuarioRepository.buscarLogin(email, senha);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
