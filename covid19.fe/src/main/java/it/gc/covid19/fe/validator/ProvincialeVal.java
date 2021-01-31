/**
 * 
 */
package it.gc.covid19.fe.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.ListUtils;

import it.gc.covid19.fe.bean.ProvincialeB;

@Component
public class ProvincialeVal implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProvincialeB.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProvincialeB nazionaleb = (ProvincialeB) target;
		if (nazionaleb.getDataDa() != null && nazionaleb.getDataA() != null
				&& nazionaleb.getDataDa().after(nazionaleb.getDataA())) {
			errors.rejectValue("dataDa", "dataDa.superiore");
		}
	}
}
