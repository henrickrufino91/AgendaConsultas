package br.com.projeto.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.clinica.model.Consultorio;

import br.com.projeto.clinica.repository.ConsultorioRepository;

@Service
public class ConsultorioService {

	
	@Autowired
	private ConsultorioRepository consultorioRepository;
	
	
	
	public Consultorio inserir(Consultorio consultorio) {
		
		return consultorioRepository.save(consultorio);
	}
	
	
	public void remover(Consultorio consultorio) {
		
		consultorioRepository.delete(consultorio);
	}
	
	
	
	public void remover(Integer codigo) {
		
		consultorioRepository.deleteById(codigo);
	}
	
	
	public List<Consultorio> listarConsultorio(){

		return consultorioRepository.findAll();
		
	}
	
	public Consultorio listarPorId(Integer codigo) {
		
		return consultorioRepository.findById(codigo).get();
	}
	
	
	public Consultorio editar(Integer codigo) {
		
		  Optional<Consultorio> u = consultorioRepository.findById(codigo);
			
		  Consultorio consultorio = null;
		  
		  if (u.isPresent()) {
			  
			  consultorio = u.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Consultorio não existe :: " + codigo);
		  }
		  
		  return consultorio;
		}
	
	
	
}
