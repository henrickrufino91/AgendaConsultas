package br.com.projeto.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.clinica.model.Medico;
import br.com.projeto.clinica.repository.MedicoRepository;

@Service
public class MedicoService {

	
	@Autowired
	private MedicoRepository medicoRepository;
	
	
	public Medico inserir(Medico medico) {
		
		return medicoRepository.save(medico);
	}
	
	
	public void remover(Medico medico) {
		
		medicoRepository.delete(medico);
	}
	
	
	
	public void remover(Integer codigo) {
		
		medicoRepository.deleteById(codigo);
	}
	
	
	public List<Medico> listarMedicos(){

		return medicoRepository.findAll();
		
	}
	
	public Medico listarPorId(Integer codigo) {
		
		return medicoRepository.findById(codigo).get();
	}
	
	
	public Medico editar(Integer codigo) {
		
		  Optional<Medico> u = medicoRepository.findById(codigo);
			
		  Medico medico = null;
		  
		  if (u.isPresent()) {
			  
			  medico = u.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Medico não existe :: " + codigo);
		  }
		  
		  return medico;
		}
	
		
	
}
