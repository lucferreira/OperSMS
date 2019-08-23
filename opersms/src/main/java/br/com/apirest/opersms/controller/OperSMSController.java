package br.com.apirest.opersms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.opersms.modelo.OperSMS;
import br.com.apirest.opersms.service.OperSMSService;

@RestController
public class OperSMSController {

	@Autowired
	private OperSMSService operSMSService;

	@GetMapping(name = "/opersms", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OperSMS> OperSMSTodos() {
		List<OperSMS> operSMSEnviados = operSMSService.findAll();
		return operSMSEnviados;
	}

	@PostMapping(name = "/opersms", produces = MediaType.APPLICATION_JSON_VALUE)
	public OperSMS saveOperSMS(@Valid @RequestBody OperSMS operSMS) {
		OperSMS oper = operSMSService.save(operSMS);
		return oper;
	}

}
