package br.com.apirest.opersms.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public ResponseEntity<List<OperSMS>> operSMSTodos() {
		List<OperSMS> operSMSEnviados = operSMSService.findAll();
		if(operSMSEnviados.equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum SMS registrado.");
		}
		return ResponseEntity.ok(operSMSEnviados);
	}
	@ApiOperation(value = "Endpoint responsável por exibir um SMS enviado por Id")
	@GetMapping(value = "/opersms/{id}")
	public ResponseEntity<Optional<OperSMS>> operSMSId(@Valid @PathVariable Long id){
		Optional<OperSMS> operSMS = operSMSService.findById(id);
		return ResponseEntity.ok(operSMS);
	}

	@ApiOperation(value = "EndPoint responsável por salvar SMS enviado")
	@PostMapping(value = "/opersms")
	public ResponseEntity<OperSMS> saveOperSMS(@Valid @RequestBody OperSMS operSMS) throws ParseException {
		Boolean data = OperSMSUtils.validaData(operSMS.getDatasms());
		OperSMS oper = null;
		if (!data == true) {
			return null;
		}
		oper = operSMSService.save(operSMS);
		return ResponseEntity.ok(oper);
	}

}
