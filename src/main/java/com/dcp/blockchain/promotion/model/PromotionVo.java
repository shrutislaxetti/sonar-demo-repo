package com.dcp.blockchain.promotion.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PromotionVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String promoName;
	private String promoLongDescription;
	private String businessBenefit;
	private String tc;
	private String startDate;
	private String endDate;
	private Map<String, Object> rules;
	private String reminderNotificationDays;
	private String enrollmentDeadlineDays;
	private String benefit;
	private String status;
	/**
	 * 
	 */
	public PromotionVo() {
		super();
	}
	/**
	 * @param promoName
	 * @param promoLongDescription
	 * @param businessBenefit
	 * @param tc
	 * @param startDate
	 * @param endDate
	 * @param rules
	 * @param reminderNotificationDays
	 * @param enrollmentDeadlineDays
	 * @param benefit
	 * @param status
	 */
	public PromotionVo(String promoName, String promoLongDescription, String businessBenefit, String tc,
			String startDate, String endDate, Map<String, Object> rules, String reminderNotificationDays,
			String enrollmentDeadlineDays, String benefit, String status) {
		super();
		this.promoName = promoName;
		this.promoLongDescription = promoLongDescription;
		this.businessBenefit = businessBenefit;
		this.tc = tc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rules = rules;
		this.reminderNotificationDays = reminderNotificationDays;
		this.enrollmentDeadlineDays = enrollmentDeadlineDays;
		this.benefit = benefit;
		this.status = status;
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
	 * @return the promoLongDescription
	 */
	public String getPromoLongDescription() {
		return promoLongDescription;
	}
	/**
	 * @param promoLongDescription the promoLongDescription to set
	 */
	public void setPromoLongDescription(String promoLongDescription) {
		this.promoLongDescription = promoLongDescription;
	}
	/**
	 * @return the businessBenefit
	 */
	public String getBusinessBenefit() {
		return businessBenefit;
	}
	/**
	 * @param businessBenefit the businessBenefit to set
	 */
	public void setBusinessBenefit(String businessBenefit) {
		this.businessBenefit = businessBenefit;
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
	 * @return the rules
	 */
	public Map<String, Object> getRules() {
		return rules;
	}
	/**
	 * @param rules the rules to set
	 */
	public void setRules(Map<String, Object> rules) {
		this.rules = rules;
	}
	/**
	 * @return the reminderNotificationDays
	 */
	public String getReminderNotificationDays() {
		return reminderNotificationDays;
	}
	/**
	 * @param reminderNotificationDays the reminderNotificationDays to set
	 */
	public void setReminderNotificationDays(String reminderNotificationDays) {
		this.reminderNotificationDays = reminderNotificationDays;
	}
	/**
	 * @return the enrollmentDeadlineDays
	 */
	public String getEnrollmentDeadlineDays() {
		return enrollmentDeadlineDays;
	}
	/**
	 * @param enrollmentDeadlineDays the enrollmentDeadlineDays to set
	 */
	public void setEnrollmentDeadlineDays(String enrollmentDeadlineDays) {
		this.enrollmentDeadlineDays = enrollmentDeadlineDays;
	}
	/**
	 * @return the benefit
	 */
	public String getBenefit() {
		return benefit;
	}
	/**
	 * @param benefit the benefit to set
	 */
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
