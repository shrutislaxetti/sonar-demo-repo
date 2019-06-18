package com.dcp.blockchain.promotion.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.dcp.blockchain.promotion.util.StringUtil;

@Component
public class Block implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hash;
	private String previousHash; 
	private Object data; //our data will be a simple message.
	private Long timeStamp; //as number of milliseconds since 1/1/1970.
	
	public Block(){
		
	}
	
	//Block Constructor.  
	public Block(Object data,String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	//Calculate new hash based on blocks contents
	public String calculateHash() {
		return StringUtil.applySha256(this.previousHash +this.timeStamp + this.data);
	}

	//Getters and Setters!
	public String getHash() {
		return hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}


}

