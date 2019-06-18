package com.dcp.blockchain.promotion.service;

import org.springframework.stereotype.Component;

import com.dcp.blockchain.promotion.util.MyException;

@Component
public interface BlockChainService {

	public String savePromotionBlock(String request) throws MyException;

	public String approvedPromotionBlock(String request);

	public String getAllApprovedPromotions();

	public String getAllSavedPromotions();

	public String getBlockByHashCode(String request);

	public String denyPromotionBlock(String request);

	public String getAllPromotions();

	public String applyPromotionBlock(String request);

	public String getCustomerBlockByHashCode(String request);
	
	public String approveCustomerForPromotionBlock(String request);
}
