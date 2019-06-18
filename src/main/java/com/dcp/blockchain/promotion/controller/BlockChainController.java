package com.dcp.blockchain.promotion.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.blockchain.promotion.service.BlockChainService;
import com.dcp.blockchain.promotion.util.Messages;
import com.dcp.blockchain.promotion.util.MyException;

@SuppressWarnings(value = { "rawtypes", "unchecked" })
@RestController
public class BlockChainController {

	@Autowired
	private BlockChainService service;

	@Autowired
	Messages messages;;

	@PostMapping(value = "/api-service/v1/promotion/savePromotion", produces = "application/json", consumes = "application/json")
	public ResponseEntity savePromotionChain(@RequestBody(required = true) String model) {
		ResponseEntity response = null;
		try {
        System.out.println(model);
			if(model=="")  {

				throw new MyException(messages.get("1"));
			}
			response = new ResponseEntity(service.savePromotionBlock(model), HttpStatus.OK);
		} catch (MyException e) {
			return new ResponseEntity(messages.get("1"), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping(value = "/api-service/v1/promotion/approvePromotion", produces = "application/json", consumes = "application/json")
	public ResponseEntity approvePromotionChain(@RequestBody(required = true) String model) {

		ResponseEntity response = null;
		try {
			if(model == ""){

				throw new MyException(messages.get("1"));
			}
			response = new ResponseEntity(service.savePromotionBlock(model), HttpStatus.OK);
		} catch (MyException e) {
			return new ResponseEntity(messages.get("1"), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping(value = "/api-service/v1/promotion/denyPromotion", produces = "application/json", consumes = "application/json")
	public ResponseEntity denyPromotion(@RequestBody(required = true) String model) {
		ResponseEntity response = null;
		try {
			if(model == ""){

				throw new MyException(messages.get("1"));
			}
			response = new ResponseEntity(service.denyPromotionBlock(model), HttpStatus.OK);
		} catch (MyException e) {
			return new ResponseEntity(messages.get("1"), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping(value = "/api-service/v1/promotion/getApprovedPromotions", produces = "application/json")
	public ResponseEntity getApprovedPromotions() {
		ResponseEntity response = null;

		response = new ResponseEntity(service.getAllApprovedPromotions(), HttpStatus.OK);

		return response;
	}

	@GetMapping(value = "/api-service/v1/promotion/getSavedPromotions", produces = "application/json")
	public ResponseEntity getSavedPromotions() {
		ResponseEntity response = null;

		response = new ResponseEntity(service.getAllSavedPromotions(), HttpStatus.OK);

		return response;
	}

	@PutMapping(value = "/api-service/v1/promotion/getBlockByHashCode", produces = "application/json")
	public ResponseEntity getBlockByHashCode(@RequestBody(required = true) String model) {
		ResponseEntity response = null;
		try {
			if(model == ""){

				throw new MyException(messages.get("1"));
			}
			response = new ResponseEntity(service.getBlockByHashCode(model), HttpStatus.OK);
		} catch (MyException e) {
			return new ResponseEntity(messages.get("1"), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping(value = "/api-service/v1/promotion/getAllPromotions", produces = "application/json")
	public ResponseEntity getAllPromotions() {
		ResponseEntity response = null;

		response = new ResponseEntity(service.getAllPromotions(), HttpStatus.OK);

		return response;
	}

	@PostMapping(value = "/api-service/v1/promotion/applyForPromotion", produces = "application/json", consumes = "application/json")
	public ResponseEntity applyForPromotion(@RequestBody(required = true) String model) {
		ResponseEntity response = null;
		try {
			if(model == ""){

				throw new MyException(messages.get("1"));
			}
			response = new ResponseEntity(service.applyPromotionBlock(model), HttpStatus.OK);
		} catch (MyException e) {
			return new ResponseEntity(messages.get("1"), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PutMapping(value = "/api-service/v1/promotion/getCustomerBlockByHashCode", produces = "application/json")
	public ResponseEntity getCustomerBlockByHashCode(@RequestBody(required = true) String model) {
		ResponseEntity response = null;
		try {
			if(model == ""){

				throw new MyException(messages.get("1"));
			}
			response = new ResponseEntity(service.getCustomerBlockByHashCode(model), HttpStatus.OK);
		} catch (MyException e) {
			return new ResponseEntity(messages.get("1"), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping(value = "/api-service/v1/promotion/verifyCustomerStatus", produces = "application/json")
	public ResponseEntity approveCustomerForPromotion(@RequestBody(required = true) String model) {
		ResponseEntity response = null;
		try {
			if(model == ""){

				throw new MyException(messages.get("1"));
			}
			response = new ResponseEntity(service.approveCustomerForPromotionBlock(model), HttpStatus.OK);
		} catch (MyException e) {
			return new ResponseEntity(messages.get("1"), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
