package com.dcp.blockchain.promotion.util;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dcp.blockchain.promotion.service.impl.BlockChainServiceImpl;
import com.google.gson.GsonBuilder;

@Component
public class StringUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(BlockChainServiceImpl.class.getName());
	private StringUtil() {

	}

	// Applies Sha256 to a string and returns the result.
	public static String applySha256(String input)  {

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			Object has = digest.digest(input.getBytes("UTF-8"));
			// byte[] hash = digest.digest(input.getBytes("UTF-8"));
			return has.toString();
		} catch (Exception e) {
			LOGGER.error(" " + e);
			}
		return null;
	
	}

	// Short hand helper to turn Object into a json string
	public static String getJson(Object o) {
		if (o != null) {
			return new GsonBuilder().setPrettyPrinting().create().toJson(o);
		}
		return null;

	}

	// Returns difficulty string target, to compare to hash. eg difficulty of 5
	// will return "00000"
	public static String getDificultyString(int difficulty) {
		return new String(new char[difficulty]).replace('\0', '0');
	}

}
