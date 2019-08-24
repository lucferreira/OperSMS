package br.com.apirest.opersms.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperSMSUtils {

	public static Boolean validaData(LocalDateTime dataRecebida) throws ParseException {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dataFormt = dataRecebida.format(format);
		
		String dataAtual = time.format(format);
		
		return dataFormt.equals(dataAtual);
	}

}
