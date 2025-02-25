package br.com.projeto.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.clinica.model.Status;
import br.com.projeto.clinica.repository.StatusRepository;

@Service
public class StatusService {

	
	
	@Autowired
	private StatusRepository statusRepository;
	
	
	public Status inserir(Status status) {
		
		return statusRepository.save(status);
	}
	
	
	public void remover(Status status) {
		
		statusRepository.delete(status);
	}
	
	
	
	public void remover(Integer codigo) {
		
		statusRepository.deleteById(codigo);
	}
	
	
	public List<Status> listarStatus(){

		return statusRepository.findAll();
		
	}
	
	public Status listarPorId(Integer codigo) {
		
		return statusRepository.findById(codigo).get();
	}
	
	
	public Status editar(Integer codigo) {
		
		  Optional<Status> u = statusRepository.findById(codigo);
			
		  Status status = null;
		  
		  if (u.isPresent()) {
			  
			  status = u.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Status não existe :: " + codigo);
		  }
		  
		  return status;
		}
	
	
	
}
