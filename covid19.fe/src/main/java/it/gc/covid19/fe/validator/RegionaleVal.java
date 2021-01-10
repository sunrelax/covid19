package it.gc.covid19.fe.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.ListUtils;

import it.gc.covid19.fe.bean.NazionaleB;
import it.gc.covid19.fe.bean.RegionaleB;

@Component
public class RegionaleVal implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NazionaleB.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegionaleB regionaleB = (RegionaleB) target;
		if (ListUtils.isEmpty(regionaleB.getGraficiSelezionati())) {
			errors.rejectValue("graficiSelezionati", "obbligatorio");
		}
		if (regionaleB.getDataDa() != null && regionaleB.getDataA() != null
				&& regionaleB.getDataDa().after(regionaleB.getDataA())) {
			errors.rejectValue("dataDa", "dataDa.superiore");
		}
	}
}
