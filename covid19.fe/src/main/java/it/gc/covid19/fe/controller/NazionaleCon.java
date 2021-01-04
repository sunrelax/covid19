package it.gc.covid19.fe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.gc.covid19.fe.bean.NazionaleB;

@Controller
public class NazionaleCon {

	Logger logger = LoggerFactory.getLogger(NazionaleCon.class);

	@Value("#{${grafici}}")
	public List<String> grafici;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "/nazionale", method = RequestMethod.GET)
	public String nazionaleForm(Model model) {
		NazionaleB nazionaleB = new NazionaleB();
		nazionaleB.setGrafici(grafici);
		model.addAttribute("nazionaleb", nazionaleB);
		return "nazionale";
	}

	@RequestMapping(value = "/nazionale/grafico", method = RequestMethod.GET)
	public String nazionaleForm(@ModelAttribute("nazionaleb") NazionaleB nazionaleb, BindingResult result) {
		logger.info("nazionaleb: " + nazionaleb);
		return "nazionale";
	}

}
