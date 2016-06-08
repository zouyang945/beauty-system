package com.kamopos.hairdressingbeauty.vo;

public class Member {
	
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}
	public String getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberMoney() {
		return memberMoney;
	}
	public void setMemberMoney(String memberMoney) {
		this.memberMoney = memberMoney;
	}
	/**
	 * 会员账号
	 */
	private String memberAccount;
	/**
	 * 会员姓名
	 */
	private String memberName;
	/**
	 * 会员性别
	 */
	private String memberSex;
	/**
	 * 会员生日
	 */
	private String memberBirthday;
	/**
	 * 会员等级
	 */
	private String memberLevel;
	/**
	 * 会员余额
	 */
	private String memberMoney;
}
