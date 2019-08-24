package br.com.apirest.opersms.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.opersms.model.OperSMS;
import br.com.apirest.opersms.service.OperSMSService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API de envio de SMS para clientes")
@RestController
@RequestMapping(value = "/sms")
public class OperSMSController {

	@Autowired
	private OperSMSService operSMSService;

	@ApiOperation(value = "EndPoint responsável por listar SMS enviados")
	@GetMapping(value = "/opersms/all")
	public List<OperSMS> OperSMSTodos() {
		List<OperSMS> operSMSEnviados = operSMSService.findAll();
		return operSMSEnviados;
	}

	@ApiOperation(value = "EndPoint responsável por salvar SMS enviado")
	@PostMapping(value = "/opersms")
	public OperSMS saveOperSMS(@Valid @RequestBody OperSMS operSMS) throws ParseException {
		Boolean data = OperSMSUtils.validaData(operSMS.getDatasms());
		OperSMS oper = null;
		if (data == true) {
			oper = operSMSService.save(operSMS);
		}
		return oper;
	}

}
