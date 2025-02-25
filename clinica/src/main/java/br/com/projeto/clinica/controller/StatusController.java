package br.com.projeto.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.clinica.model.Status;
import br.com.projeto.clinica.service.StatusService;
import jakarta.validation.Valid;

@Controller
public class StatusController {

	
	@Autowired
	private StatusService statusService;
	
	
	@GetMapping("/novoStatus")
	public String novoStatus(Model model) {
		
		model.addAttribute("status", new Status());
		
		return "/status/novoStatus";
	}
	
	
	@PostMapping("/salvarStatus")
	public String salvarStatus(@Valid Status status,Model model) {
		
		try {
			
			if (status.getCodStatus() == null) {
				statusService.inserir(status);
			} else {
				Status status2 = statusService.listarPorId(status.getCodStatus());
				status2.setDescricao(status.getDescricao());
	
				statusService.inserir(status2);
				
			}
			
			model.addAttribute("status", status);
						
			return "redirect:/novoStatus";
			
		} catch (Exception e) {
			
			model.addAttribute("msg", "Erro ao inserir status!");
			
			return "redirect:/novoStatus";
		}
		
	}
	
	
	@GetMapping("/removerStatus")
    public String removerStatus(@RequestParam Integer codigo){
        
		Status status = statusService.listarPorId(codigo);
		statusService.remover(status);
		
        return "redirect:/listarStatus";
    }
	
	
	@GetMapping("/editarStatus")
    public ModelAndView editar(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("/status/editarStatus");
    
        Status status = statusService.listarPorId(codigo);
        mv.addObject("status",  status);
          
        return mv;
   
    }
	
	
	
	@GetMapping(value = "/listarStatus")
	public String listarUsuario(Status status,Model model) {
		
		model.addAttribute("status", status);
		model.addAttribute("listarStatus", statusService.listarStatus());
			
		return "/status/listarStatus";
	}
	
	
	
}
