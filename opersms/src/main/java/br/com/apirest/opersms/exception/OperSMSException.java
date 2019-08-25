package br.com.apirest.opersms.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

//Captura exceções das API'S
@ControllerAdvice
public class OperSMSException extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	//Validar exceções vindas da requisição
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensagemUser = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemDesenv = ex.getCause().toString();
		List<Mensagem> mensagens = Arrays.asList(new Mensagem(mensagemUser, mensagemDesenv));
		return handleExceptionInternal(ex, mensagens, headers, HttpStatus.BAD_REQUEST, request);
	}
	//Validar os dados do BeanValidation
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Mensagem> mensagens = listaMensagens(ex.getBindingResult());
		return handleExceptionInternal(ex, mensagens, headers, HttpStatus.BAD_REQUEST, request);
	}
	//Lista de mensagens de erro 
	public List<Mensagem> listaMensagens(BindingResult binding){
		List<Mensagem> mensagens = new ArrayList<>();
		for(FieldError error : binding.getFieldErrors()) {
			String mensagemUser = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			String mensagemDesenv = error.toString();
			mensagens.add(new Mensagem(mensagemUser, mensagemDesenv));
		}
		return mensagens;
	}
	
	@AllArgsConstructor
	public static class Mensagem{
		@Getter
		private String mensagemUsuario;
		@Getter
		private String mensagemDesenvolvedor;
	}
	
	
}
