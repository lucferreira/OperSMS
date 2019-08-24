package br.com.apirest.opersms.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.opersms.model.OperSMS;
import br.com.apirest.opersms.service.OperSMSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API de envio de SMS para clientes")
public class OperSMSController {
	
	@Autowired
	private OperSMSService operSMSService;

	@ApiOperation(value = "EndPoint responsável por listar SMS enviados")
	@GetMapping(name = "/opersms/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OperSMS> OperSMSTodos() {
		List<OperSMS> operSMSEnviados = operSMSService.findAll();
		return operSMSEnviados;
	}

	@ApiOperation(value = "EndPoint responsável por salvar SMS enviado")
	@PostMapping(name = "/opersms", produces = MediaType.APPLICATION_JSON_VALUE)
	public OperSMS saveOperSMS(@Valid @RequestBody OperSMS operSMS) throws ParseException {
		Boolean dataSMS = OperSMSUtils.validaData(operSMS.getDatasms());
		OperSMS oper = null;
		if (dataSMS == true) {
			oper = operSMSService.save(operSMS);
		}else {
			
		}
		return oper;
	}

}
