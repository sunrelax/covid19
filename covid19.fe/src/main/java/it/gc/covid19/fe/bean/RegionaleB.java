package it.gc.covid19.fe.bean;

import java.util.List;

import javax.validation.constraints.NotNull;

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
public class RegionaleB extends RicercaB {

	public List<ComboB> regioni;

	@NotNull
	public List<String> regioniSelezionate;
}
