package br.com.apirest.opersms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperSMSUtils {

	public static Boolean validaData(String dataRecebida) throws ParseException {
		Date data = new SimpleDateFormat("dd-MM-yyyy").parse(dataRecebida);
		if (!data.equals(new Date().getTime())) {
			return false;
		}
		return true;
	}

}
