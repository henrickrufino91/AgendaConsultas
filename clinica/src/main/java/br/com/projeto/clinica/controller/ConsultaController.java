package br.com.projeto.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.clinica.model.Consulta;

import br.com.projeto.clinica.service.ConsultaService;
import br.com.projeto.clinica.service.ConsultorioService;
import br.com.projeto.clinica.service.MedicoService;
import br.com.projeto.clinica.service.PacienteService;
import br.com.projeto.clinica.service.StatusService;
import jakarta.validation.Valid;

@Controller
public class ConsultaController {

	
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private ConsultorioService consultorioService;
	
	
	
	
	@GetMapping("/novaConsulta")
	public String novaConsulta(Model model) {
		
		model.addAttribute("consulta", new Consulta());
		model.addAttribute("listarPacientes", pacienteService.listarPacientes());
		model.addAttribute("listarMedicos", medicoService.listarMedicos());
		model.addAttribute("listarStatus", statusService.listarStatus());
		model.addAttribute("listarConsultorios", consultorioService.listarConsultorio());
		
		return "/consulta/novaConsulta";
	}
	
	
	@PostMapping("/salvarConsulta")
	public String salvarConsulta(@Valid Consulta consulta,Model model) {
		
		try {
			
			if (consulta.getCodConsulta() == null) {
				consultaService.inserir(consulta);
			} else {
				Consulta consulta2 = consultaService.listarPorId(consulta.getCodConsulta());
				consulta2.setStatus(consulta.getStatus());
				consulta2.setPaciente(consulta.getPaciente());
				consulta2.setObservacoes(consulta.getObservacoes());
				consulta2.setMedico(consulta.getMedico());
				consulta2.setInicioConsulta(consulta.getInicioConsulta());
				consulta2.setFimConsulta(consulta.getFimConsulta());
				consulta2.setDataConsulta(consulta.getDataConsulta());
				consulta2.setConsultorio(consulta.getConsultorio());
	
				consultaService.inserir(consulta2);
				
			}
			
			model.addAttribute("consulta", consulta);
						
			return "redirect:/novaConsulta";
			
		} catch (Exception e) {
			
			model.addAttribute("msg", "Erro ao inserir consulta!");
			
			return "redirect:/novaConsulta";
		}
		
	}
	
	
	@GetMapping("/removerConsulta")
    public String removerConsulta(@RequestParam Integer codigo){
        
		Consulta consulta = consultaService.listarPorId(codigo);
		consultaService.remover(consulta);
		
        return "redirect:/listarConsultas";
    }

	
	@GetMapping(value = "/editarConsulta")
    public ModelAndView editar(@RequestParam Integer codigo){
       
        ModelAndView mv = new ModelAndView("/consulta/editarConsulta");
    
        Consulta consulta = consultaService.listarPorId(codigo);
        mv.addObject("consulta",  consulta);
        mv.addObject("listarPacientes",  pacienteService.listarPacientes());
        mv.addObject("listarMedicos",  medicoService.listarMedicos());
        mv.addObject("listarStatus",  statusService.listarStatus());
        mv.addObject("listarConsultorios",  consultorioService.listarConsultorio());
        
        return mv;
   
    }
	
	
	
	@GetMapping(value = "/listarConsultas")
	public String listarConsulta(Consulta consulta,Model model) {
		
		model.addAttribute("consulta", consulta);
		model.addAttribute("listarConsultas", consultaService.listarConsultas());
			
		return "/consulta/listarConsultas";
	}
	
	
	@PostMapping(value = "/listarPorNome")
	public ModelAndView listarPorNome(@RequestParam("nome") String nome) {
				
		ModelAndView mv = new ModelAndView("redirect:/listarConsultas");
		mv.addObject("listarConsultas",consultaService.buscarConsulta(nome));
		mv.addObject("consulta", new Consulta());

		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
