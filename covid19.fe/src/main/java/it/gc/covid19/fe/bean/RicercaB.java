package it.gc.covid19.fe.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RicercaB {

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date dataDa;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date dataA;

}
