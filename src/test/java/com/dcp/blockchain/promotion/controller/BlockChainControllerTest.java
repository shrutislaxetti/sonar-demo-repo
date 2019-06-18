package com.dcp.blockchain.promotion.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.dcp.blockchain.promotion.service.BlockChainService;
import com.dcp.blockchain.promotion.util.Messages;
import com.dcp.blockchain.promotion.util.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
public class BlockChainControllerTest {

	@InjectMocks
	BlockChainController blockChainController;

	@Mock
	BlockChainService service;

	@Mock
	Messages messages;

	

	@Test
	public void savePromotionChainTest() throws Exception {
		String model = "model";
		when(service.savePromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.savePromotionChain(model));
		
	}
	
	@Test
	public void savePromotionChainTestException() throws MyException {
		String model = "";
		when(service.savePromotionBlock(model)).thenReturn("21");
	
		ResponseEntity<String> response = new ResponseEntity<String>(messages.get("1"), HttpStatus.BAD_REQUEST);

		assertEquals(response, blockChainController.savePromotionChain(model));
		
	}
	
	@Test
	public void approvePromotionTest() throws Exception {
		String model = "model";
		when(service.savePromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.approvePromotionChain(model));
	
	}
	
	@Test
	public void approvePromotionTestException() throws Exception {
		String model = "";
		when(service.savePromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>(messages.get("1"), HttpStatus.BAD_REQUEST);
		assertEquals(response, blockChainController.approvePromotionChain(model));
	
	}

	@Test
	public void denyPromotionTest() throws Exception {
		String model = "model";
		when(service.denyPromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.denyPromotion(model));
	
	}
	@Test
	public void denyPromotionTestException() throws Exception {
		String model = "";
		when(service.denyPromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>(messages.get("1"), HttpStatus.BAD_REQUEST);
		assertEquals(response, blockChainController.denyPromotion(model));
	
	}

	@Test
	public void getApprovedPromotionsTest() throws Exception {

		when(service.getAllApprovedPromotions()).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.getApprovedPromotions());
	}
	
	
	@Test
	public void getSavedPromotionsTest() throws Exception {
		when(service.getAllSavedPromotions()).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.getSavedPromotions());
	}

	@Test
	public void getBlockByHashCodeTest() throws Exception {
		String model = "model";
		when(service.getBlockByHashCode(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.getBlockByHashCode(model));
	}
	
	@Test
	public void getBlockByHashCodeTestException() throws Exception {
		String model = "";
		when(service.getBlockByHashCode(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>(messages.get("1"), HttpStatus.BAD_REQUEST);
		assertEquals(response, blockChainController.getBlockByHashCode(model));
	}

	@Test
	public void getAllPromotionsTest() throws Exception {
         
		when(service.getAllPromotions()).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.getAllPromotions());
	}

	@Test
	public void applyForPromotionTest() throws Exception {
		String model = "model";
		when(service.applyPromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.applyForPromotion(model));
	}
	
	@Test
	public void applyForPromotionTestException() throws Exception {
		String model = "";
		when(service.applyPromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>(messages.get("1"), HttpStatus.BAD_REQUEST);
		assertEquals(response, blockChainController.applyForPromotion(model));
	}

	@Test
	public void getCustomerBlockByHashCodeTest() throws Exception {
		String model = "model";
		when(service.getCustomerBlockByHashCode(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.getCustomerBlockByHashCode(model));
	}
	@Test
	public void getCustomerBlockByHashCodeTestException() throws Exception {
		String model = "";
		when(service.getCustomerBlockByHashCode(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>(messages.get("1"), HttpStatus.BAD_REQUEST);
		assertEquals(response, blockChainController.getCustomerBlockByHashCode(model));
	}
	@Test
	public void approveCustomerForPromotionTest() throws Exception {
		String model = "model";
		when(service.approveCustomerForPromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>("21", HttpStatus.OK);
		assertEquals(response, blockChainController.approveCustomerForPromotion(model));
	}
	@Test
	public void approveCustomerForPromotionTestException() throws Exception {
		String model = "";
		when(service.approveCustomerForPromotionBlock(model)).thenReturn("21");
		ResponseEntity<String> response = new ResponseEntity<String>(messages.get("1"), HttpStatus.BAD_REQUEST);
		assertEquals(response, blockChainController.approveCustomerForPromotion(model));
	}


}
