package com.dcp.blockchain.promotion.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CustomerModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String customerName;
	private String billingInfo;
	private String promoName;
	private String promoHash;
	private String promoDesc;
	private String tc;
	private String startDate;
	private String endDate;
	private String enrollmentDeadlineDate;
	private String postPromoBillingInfo;
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the billingInfo
	 */
	public String getBillingInfo() {
		return billingInfo;
	}
	/**
	 * @param billingInfo the billingInfo to set
	 */
	public void setBillingInfo(String billingInfo) {
		this.billingInfo = billingInfo;
	}
	/**
	 * @return the promoName
	 */
	public String getPromoName() {
		return promoName;
	}
	/**
	 * @param promoName the promoName to set
	 */
	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
	/**
	 * @return the promoHash
	 */
	public String getPromoHash() {
		return promoHash;
	}
	/**
	 * @param promoHash the promoHash to set
	 */
	public void setPromoHash(String promoHash) {
		this.promoHash = promoHash;
	}
	/**
	 * @return the promoDesc
	 */
	public String getPromoDesc() {
		return promoDesc;
	}
	/**
	 * @param promoDesc the promoDesc to set
	 */
	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}
	/**
	 * @return the tc
	 */
	public String getTc() {
		return tc;
	}
	/**
	 * @param tc the tc to set
	 */
	public void setTc(String tc) {
		this.tc = tc;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the enrollmentDeadlineDate
	 */
	public String getEnrollmentDeadlineDate() {
		return enrollmentDeadlineDate;
	}
	/**
	 * @param enrollmentDeadlineDate the enrollmentDeadlineDate to set
	 */
	public void setEnrollmentDeadlineDate(String enrollmentDeadlineDate) {
		this.enrollmentDeadlineDate = enrollmentDeadlineDate;
	}
	/**
	 * @return the postPromoBillingInfo
	 */
	public String getPostPromoBillingInfo() {
		return postPromoBillingInfo;
	}
	/**
	 * @param postPromoBillingInfo the postPromoBillingInfo to set
	 */
	public void setPostPromoBillingInfo(String postPromoBillingInfo) {
		this.postPromoBillingInfo = postPromoBillingInfo;
	}
	/**
	 * @param customerName
	 * @param billingInfo
	 * @param promoName
	 * @param promoHash
	 * @param promoDesc
	 * @param tc
	 * @param startDate
	 * @param endDate
	 * @param enrollmentDeadlineDate
	 * @param postPromoBillingInfo
	 */
	public CustomerModel(String customerName, String billingInfo, String promoName, String promoHash, String promoDesc,
			String tc, String startDate, String endDate, String enrollmentDeadlineDate, String postPromoBillingInfo) {
		super();
		this.customerName = customerName;
		this.billingInfo = billingInfo;
		this.promoName = promoName;
		this.promoHash = promoHash;
		this.promoDesc = promoDesc;
		this.tc = tc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.enrollmentDeadlineDate = enrollmentDeadlineDate;
		this.postPromoBillingInfo = postPromoBillingInfo;
	}
	/**
	 * 
	 */
	public CustomerModel() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerModel [customerName=" + customerName + ", billingInfo=" + billingInfo + ", promoName="
				+ promoName + ", promoHash=" + promoHash + ", promoDesc=" + promoDesc + ", tc=" + tc + ", startDate="
				+ startDate + ", endDate=" + endDate + ", enrollmentDeadlineDate=" + enrollmentDeadlineDate
				+ ", postPromoBillingInfo=" + postPromoBillingInfo + "]";
	}
	
	
}
