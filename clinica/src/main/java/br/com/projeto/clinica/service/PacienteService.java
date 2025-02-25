package br.com.projeto.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.clinica.model.Paciente;
import br.com.projeto.clinica.repository.PacienteRepository;

@Service
public class PacienteService {

	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	
	public Paciente inserir(Paciente paciente) {
		
		return pacienteRepository.save(paciente);
	}
	
	
	public void remover(Paciente paciente) {
		
		pacienteRepository.delete(paciente);
	}
	
	
	
	public void remover(Integer codigo) {
		
		pacienteRepository.deleteById(codigo);
	}
	
	
	public List<Paciente> listarPacientes(){

		return pacienteRepository.findAll();
		
	}
	
	public Paciente listarPorId(Integer codigo) {
		
		return pacienteRepository.findById(codigo).get();
	}
	
	
	public Paciente editar(Integer codigo) {
		
		  Optional<Paciente> u = pacienteRepository.findById(codigo);
			
		  Paciente paciente = null;
		  
		  if (u.isPresent()) {
			  
			  paciente = u.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Paciente não existe :: " + codigo);
		  }
		  
		  return paciente;
		}
	
	
	
}
