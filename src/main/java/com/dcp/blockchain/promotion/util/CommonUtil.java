package com.dcp.blockchain.promotion.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dcp.blockchain.promotion.model.Block;
import com.dcp.blockchain.promotion.model.PromotionVo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CommonUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class.getName());
	
	private CommonUtil()
	{
		
	}
	public static Map<String, Object> convertJsonToMap(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> mapObj = null;
		try {
			mapObj = objectMapper.readValue(json, new TypeReference<HashMap<String, Object>>() {
			});
		} catch (IOException e) {
			LOGGER.error(" --" + e);
		}

		return mapObj;
	}

	public static String containsKeyandValue(String key, Map<String, Object> map) {
		if (map.containsKey(key)) {
			return getValue(map.get(key).toString());
		}
		return null;
	}

	public static String convertTostring(PromotionVo request) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;

		try {
			// get Employee object as a json string
			jsonStr = mapper.writeValueAsString(request);
			return jsonStr;
		} catch (IOException e) {
			LOGGER.error(" --" + e);
		}
		return null;
	}
	
	// method to check value
	public static String getValue(String string) {
		return (string!= null ? string : "");
	}
	
	

}
