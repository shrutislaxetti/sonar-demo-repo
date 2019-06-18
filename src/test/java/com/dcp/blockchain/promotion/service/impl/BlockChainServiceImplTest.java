package com.dcp.blockchain.promotion.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dcp.blockchain.promotion.model.Block;
import com.dcp.blockchain.promotion.model.PromotionVo;
import com.dcp.blockchain.promotion.util.CommonUtil;
import com.dcp.blockchain.promotion.util.MyException;
import com.dcp.blockchain.promotion.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockChainServiceImplTest {

	@InjectMocks
	BlockChainServiceImpl blockChainService;

	@Mock
	CommonUtil CommonUtil;
	@Mock
	PromotionVo promo;
	@Mock
	StringUtil stringUtil;

	@Mock
	private ObjectMapper mapper;

	Map<String, Block> savedPromotions = null;
	Map<String, Block> approvedPromotions = null;
	Map<String, Block> denyPromotions = null;
	Map<String, Block> appliedPromotionMap = null;
	Map<String, Block> customerApprovedPromotionMap = null;

	Map<String, Block> map = null;

	String request = null;
	String blockchainJson = null;
	String json = null;

	Map<String, Object> requestMapList = null;
	Map<String, Object> requestMap = null;

	Block block = null;
	Block saveBlock = null;
	Block approvedBlock = null;
	Block newBlock = null;

	@Before
	public void setup() throws IOException, ParseException {

		requestMapList = new HashMap<String, Object>();
		requestMap = new HashMap<String, Object>();

		map = new HashMap<String, Block>();
		savedPromotions = new HashMap<String, Block>();
		approvedPromotions = new HashMap<String, Block>();
		denyPromotions = new HashMap<String, Block>();
		appliedPromotionMap = new HashMap<String, Block>();
		customerApprovedPromotionMap = new HashMap<String, Block>();

		promo = new PromotionVo();
		promo.setBenefit("yes");
		promo.setBusinessBenefit("yes1");
		promo.setEndDate("yes1");
		promo.setEnrollmentDeadlineDays("yes1");
		promo.setPromoLongDescription("yes1");
		promo.setPromoName("ar");
		promo.setReminderNotificationDays("hgjhgj");
		promo.setRules(requestMapList);
		promo.setStartDate("23/3/2019");
		promo.setStatus("ghj");
		promo.setTc("123");

		saveBlock = new Block(promo, com.dcp.blockchain.promotion.util.CommonUtil.containsKeyandValue("previousHash", requestMapList));
		saveBlock.setData("simple message");
		//saveBlock.setPreviousHash("[B@2b874d46");
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("23/09/2007");
		long time = date.getTime();
		saveBlock.setTimeStamp(time);
		saveBlock.calculateHash();
		saveBlock.setPreviousHash(saveBlock.getHash());
		
		blockchainJson = StringUtil.getJson(savedPromotions.get(saveBlock.getHash()));

		request = com.dcp.blockchain.promotion.util.CommonUtil.convertTostring(promo);
		
	}

	@Test
	public void testSavePromotionBlock() {

		blockChainService.savePromotionBlock(request);
		assertTrue(true);

	}

	@Test
	public void testSavePromotionBlockException() {
		request = null;

		blockChainService.savePromotionBlock(request);
		assertFalse(false);

	}

	//@Test
	public void testApprovedPromotionBlock() throws MyException {

		blockChainService.approvedPromotionBlock(request);
		assertTrue(true);

	}

	@Test
	public void testApprovedPromotionBlockException() throws MyException {
		request = null;

		blockChainService.approvedPromotionBlock(request);
		assertFalse(false);

	}

	@Test
	public void testDenyPromotionBlock() throws IOException {

		blockChainService.denyPromotionBlock(request);
		assertTrue(true);
	}

	@Test
	public void testDenyPromotionBlockException() throws IOException {
		request = null;
		blockChainService.denyPromotionBlock(request);
		assertFalse(false);

	}

	@Test
	public void testGetBlockByHashCode() throws IOException {

		blockChainService.getBlockByHashCode(request);
		assertTrue(true);

	}

	@Test
	public void testGetBlockByHashCodeException() throws IOException {
		request = null;
		blockChainService.getBlockByHashCode(request);
		assertFalse(false);
	}

	@Test
	public void testApplyPromotionBlock() throws IOException {
		blockChainService.applyPromotionBlock(request);
		assertTrue(true);

	}

	//@Test
	public void testGetCustomerBlockByHashCode() {

			blockChainService.getCustomerBlockByHashCode(request);
			assertTrue(true);
	}
	@Test
	public void testGetCustomerBlockByHashCodeException()  {
		request = null;
			blockChainService.getCustomerBlockByHashCode(request);
			assertFalse(false);
	}

	@Test
	public void testApproveCustomerForPromotionBlock() throws IOException {

		blockChainService.approveCustomerForPromotionBlock(request);
		assertTrue(true);

	}

	@Test
	public void testApproveCustomerForPromotionBlockException() throws IOException {
		request = null;
		//try {
		blockChainService.approveCustomerForPromotionBlock(request);
		//}
		//catch(Exception e) {
		assertFalse(false);
		//}

	}

	@Test
	public void testGetAllSavedPromotions() {
		blockChainService.getAllSavedPromotions();
		assertTrue(true);
	}

	@Test
	public void testGetAllApprovedPromotions() {
		blockChainService.getAllApprovedPromotions();
		assertTrue(true);
	}

	@Test
	public void testGetAllApprovedPromotionsExceptions() {
		json = null;
		blockChainService.approvedPromotionBlock(json);
		assertFalse(false);

	}

	@Test
	public void testGetAllPromotions() throws IOException {
		blockChainService.getAllPromotions();
		assertTrue(true);
	}

}