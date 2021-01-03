package it.gc.covid19.be.controller;

import it.gc.covid19.be.document.NazionaleDoc;
import it.gc.covid19.be.service.NazionaleMSer;
import it.gc.covid19.be.util.Aggregation;
import it.gc.covid19.be.util.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/covidData")
public class CovidController {
    @Autowired
    private NazionaleMSer nazionaleSer;

    //http://localhost:8081/covidData/dati?from=2020-04-20&to=2020-05-20&type=nuovi_positivi&agg=DAY
    @GetMapping("/dati")
    public List<Integer> getNazionaleData(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                          @RequestParam("from")LocalDate from,
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                          @RequestParam("to")LocalDate to,
                                          @RequestParam("type") Type type,
                                          @RequestParam("agg") Aggregation agg){
        List<Integer> res = nazionaleSer.getCountryData(from, to, type, agg)
                .stream()
                .map(type::getValue)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return res;
    }
}
