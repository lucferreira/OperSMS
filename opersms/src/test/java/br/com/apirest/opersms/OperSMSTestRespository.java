package br.com.apirest.opersms;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.apirest.opersms.controller.OperSMSController;
import br.com.apirest.opersms.model.OperSMS;
import br.com.apirest.opersms.repository.OperSMSRepository;
import br.com.apirest.opersms.service.OperSMSServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OperSMSTestRespository {
	
	private MockMvc mockMvc;
	
	@Mock
	private OperSMSServiceImpl operServiceImpl;
	
	@Mock
	private OperSMSRepository OperSMSRepository;

	@InjectMocks
	private OperSMS operSMS;
	
	@InjectMocks 
	private OperSMSController operSMSController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(operSMSController).build();
	}
	@Before
	public void operSMSMock() {
		operSMS = new OperSMS();
		operSMS.setIdsms(4l);
		operSMS.setDatasms(LocalDateTime.now());
		operSMS.setTextosms("Texto SMS 4");
	}
		
	@Test
	public void endpointGetAll() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/sms/opersms/all"))
//		.andExpect(MockMvcResultMatchers.status().isOk());
		ResponseEntity<List<OperSMS>> response = operSMSController.operSMSTodos();
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode().ACCEPTED);
	}
	@Test
	public void endpointGetForId() throws Exception {
		ResponseEntity<OperSMS> response = operSMSController.saveOperSMS(operSMS);
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode().ACCEPTED);
	}
	@Test
	public void endpointPost() throws Exception {
		ResponseEntity<Optional<OperSMS>> response = operSMSController.operSMSId(operSMS.getIdsms());
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode().ACCEPTED);
	}
	
}
