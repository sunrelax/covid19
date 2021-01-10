
package it.gc.covid19.fe.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.client.RestTemplate;

import it.gc.covid19.fe.bean.ComboB;
import it.gc.covid19.fe.bean.RegionaleB;
import it.gc.covid19.fe.validator.RegionaleVal;

@Controller
public class RegionaleCon {

	Logger logger = LoggerFactory.getLogger(RegionaleCon.class);

	@Value("#{${grafici}}")
	public List<String> grafici;
	@Autowired
	private List<ComboB> regioni;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RegionaleVal regionaleVal;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "/regionale", method = RequestMethod.GET)
	public String regionaleForm(Model model) {
		RegionaleB regionaleB = new RegionaleB();
		regionaleB.setGrafici(grafici);
		regionaleB.setRegioni(regioni);
		model.addAttribute("regionaleb", regionaleB);
		return "regionale";
	}

	@RequestMapping(value = "/regionale/grafico", method = RequestMethod.GET)
	public String regionaleForm(Model model, @ModelAttribute("RegionaleB") RegionaleB regionaleB,
			BindingResult result) {
		logger.info("RegionaleB: " + regionaleB);
		regionaleB.setGrafici(grafici);
		model.addAttribute("regionaleb", regionaleB);
		regionaleVal.validate(regionaleB, result);
		if (result.hasErrors()) {
			return "regionale";
		}
		String graficiSel = String.join(",", regionaleB.getGraficiSelezionati());
		String regioniSel = String.join(",", regionaleB.getRegioniSelezionate());
		StringBuffer url = new StringBuffer("http://localhost:8081/regionale/line/" + regioniSel + "/" + graficiSel);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (regionaleB.getDataDa() != null && regionaleB.getDataA() == null) {
			url.append("?dataDa=" + sdf.format(regionaleB.getDataDa()));
		} else if (regionaleB.getDataDa() == null && regionaleB.getDataA() != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(regionaleB.getDataA());
			c.add(Calendar.DATE, 1);
			url.append("?dataA=" + sdf.format(c.getTime()));
		} else if (regionaleB.getDataDa() != null && regionaleB.getDataA() != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(regionaleB.getDataA());
			c.add(Calendar.DATE, 1);
			url.append("?dataDa=" + sdf.format(regionaleB.getDataDa()) + "&dataA=" + sdf.format(c.getTime()));
		}
		String linechart = restTemplate.getForObject(url.toString(), String.class);
		model.addAttribute("linechart", linechart);
		return "regionale";
	}

}
