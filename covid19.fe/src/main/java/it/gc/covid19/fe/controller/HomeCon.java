package it.gc.covid19.fe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCon {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Benvenuto nel servizio di visualizzazione grafici dell'andamento della pandemia da Covid19 in Italia");
		return "index";
	}
}
