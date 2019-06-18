package com.dcp.blockchain.promotion.service.impl;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcp.blockchain.promotion.model.Block;
import com.dcp.blockchain.promotion.model.CustomerModel;
import com.dcp.blockchain.promotion.model.PromotionVo;
import com.dcp.blockchain.promotion.service.BlockChainService;
import com.dcp.blockchain.promotion.util.CommonUtil;
import com.dcp.blockchain.promotion.util.Messages;
import com.dcp.blockchain.promotion.util.MyException;
import com.dcp.blockchain.promotion.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BlockChainServiceImpl implements BlockChainService {

	protected static final Map<String, Block> savedPromotions = new HashMap<>();
	protected static Map<String, Block> approvedPromotions = new HashMap<>();
	protected static final Map<String, Block> denyPromotions = new HashMap<>();
	protected static final Map<String, Block> appliedPromotionMap = new HashMap<>();
	protected static final Map<String, Block> customerApprovedPromotionMap = new HashMap<>();

	private static final Logger LOGGER = LoggerFactory.getLogger(BlockChainServiceImpl.class.getName());

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private Messages messages;

	@Override
	public String savePromotionBlock(String request) {
		
		
		String blockchainJson = null;
		try {
			if( (request == null)){
				
				 throw new MyException("Error occured while processing request");
			}
			
			Map<String, Object> requestMapList = CommonUtil.convertJsonToMap(request);

			requestMapList.values();
			PromotionVo promo = mapper.convertValue(requestMapList.get("data"), PromotionVo.class);
			Block saveBlock = new Block(promo, CommonUtil.containsKeyandValue("previousHash", requestMapList));
			addBlock(saveBlock, savedPromotions);

			 blockchainJson = StringUtil.getJson(savedPromotions.get(saveBlock.getHash()));
		} catch (MyException e) {
			return "Error occured while processing request";
		}
		return blockchainJson;
	}
	
	
	/**
	 * Method used for Approving the Promotion!.
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public String approvedPromotionBlock(String request) {
		String json = null;
		try {
			if( (request == null)){
				
				 throw new MyException("Error occured while processing request");
			}
			Map<String, Object> requestMap = CommonUtil.convertJsonToMap(request);
			PromotionVo promo = mapper.convertValue(requestMap.get("data"), PromotionVo.class);
			Block approvedBlock = new Block(promo, CommonUtil.containsKeyandValue("hash", requestMap));
			addBlock(approvedBlock, approvedPromotions);
			removeBlock(requestMap.get("hash").toString(), savedPromotions);
			json = StringUtil.getJson(approvedPromotions.get(approvedBlock.getHash()));
		} catch (MyException e) {
			return "Error occured while processing request";
		}
		return json;
	}

	/**
	 * This method is used to deny promotions.
	 * 
	 * @param request json
	 * @return
	 */
	@Override
	public String denyPromotionBlock(String request) {
		String json = null;
		try {
			Map<String, Object> requestMap = CommonUtil.convertJsonToMap(request);
			PromotionVo promo = mapper.convertValue(requestMap.get("data"), PromotionVo.class);
			removeBlock(requestMap.get("hash").toString(), savedPromotions);
			Block denyBlock = new Block(promo, CommonUtil.containsKeyandValue("previousHash", requestMap));
			addBlock(denyBlock, denyPromotions);

		} catch (Exception e) {
			LOGGER.error("denying promotions --" + e);

		}
		return json;
	}

	/**
	 * Method used for Fetching the Saved Promotion By Hashcode!
	 * 
	 * @param hashCode
	 * @return
	 */
	@Override
	public String getBlockByHashCode(String request) {
		Map<String, Object> requestMap = null;
		Block block = null;
		try {
			requestMap = CommonUtil.convertJsonToMap(request);
			String hashCode = requestMap.get("hash").toString();
			block = savedPromotions.get(hashCode) == null ? null : savedPromotions.get(hashCode);
			if (block == null) {
				block = approvedPromotions.get(hashCode) == null ? null : approvedPromotions.get(hashCode);
			}
		} catch (Exception e) {
			LOGGER.error("error while getting hash code --" + e);
		}

		return StringUtil.getJson(block);
	}

	/**
	 * Method used for Fetching the Saved Promotion By Hashcode!
	 * 
	 * @param hashCode
	 * @return
	 */
	public String getAllApprovedPromotions() {
		return StringUtil.getJson(approvedPromotions.values());
	}

	/**
	 * Method used for Fetching the Saved Promotion By Hashcode!
	 * 
	 * @param hashCode
	 * @return
	 */
	public String getAllSavedPromotions() {
		return StringUtil.getJson(savedPromotions.values());
	}

	// private methods
	private void addBlock(Block newBlock, Map<String, Block> map) {

		map.put(newBlock.getHash(), newBlock);
	}

	private void removeBlock(String hash, Map<String, Block> map) {
		if (hash != null) {
			map.remove(hash);
		}
	}

	public String getAllPromotions()  {
		List<Block> list = null;
		list = new ArrayList<>(savedPromotions.values());
		list.addAll(approvedPromotions.values());
		return StringUtil.getJson(list);
	}

	@Override
	public String applyPromotionBlock(String request)  {
		String blockchainJson = null;
		Map<String, Object> requestMapList = CommonUtil.convertJsonToMap(request);
		CustomerModel model = mapper.convertValue(requestMapList.get("hash"), CustomerModel.class);
		Block saveBlock = new Block(model, CommonUtil.containsKeyandValue("previousHash", requestMapList));
		addBlock(saveBlock, appliedPromotionMap);
		blockchainJson = StringUtil.getJson(appliedPromotionMap.get(saveBlock.getHash()));
		return blockchainJson;
	}

	/**
	 * Method used for Fetching the Saved Promotion By Hashcode!
	 * 
	 * @param hashCode
	 * @return
	 */
	@Override
	public String getCustomerBlockByHashCode(String request)  {
		try {
		if( (request == null)){
			
			 throw new MyException("Error occured while processing request");
		}
		Map<String, Object> requestMap = null;
		Block block = null;
		requestMap = CommonUtil.convertJsonToMap(request);
		String hashCode = requestMap.get("hash").toString();
		block = appliedPromotionMap.get(hashCode) == null ? null : appliedPromotionMap.get(hashCode);
		return StringUtil.getJson(block);
		}  
		catch (MyException e) {
			return "Error occured while processing request";
		}
	}

	/**
	 * Method used for Approved Promotion for a Customer!
	 */
	@Override
	public String approveCustomerForPromotionBlock(String request) {
		String json = null;
		try {
			if((request == null)){
				
				 throw new MyException("Error occured while processing request");
			}
			
			Map<String, Object> requestMap = CommonUtil.convertJsonToMap(request);
			CustomerModel customer = mapper.convertValue(requestMap.get("data"), CustomerModel.class);
			Block approvedBlock = new Block(customer, CommonUtil.containsKeyandValue("previousHash", requestMap));
			addBlock(approvedBlock, customerApprovedPromotionMap);
			json = StringUtil.getJson(customerApprovedPromotionMap.get(approvedBlock.getHash()));
		}  catch (MyException e) {
			return "Error occured while processing request";
		}

		return json;

	}
}
