package br.com.apirest.opersms;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
		mockMvc.perform(MockMvcRequestBuilders.get("/sms/opersms/all"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void endpointGetForId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/sms/operSMS/",operSMS.getIdsms()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void endpointPost() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/sms/operSMS",operSMS))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
