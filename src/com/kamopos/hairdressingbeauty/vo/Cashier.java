package com.kamopos.hairdressingbeauty.vo;

/**
 * ��ӪԱ
 * 
 * @author
 * 
 */
public class Cashier {

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getStaffWork() {
		return staffWork;
	}

	public void setStaffWork(String staffWork) {
		this.staffWork = staffWork;
	}

	public String getEmployeeRow() {
		return employeeRow;
	}

	public void setEmployeeRow(String employeeRow) {
		this.employeeRow = employeeRow;
	}

	public String getEmployeeRights() {
		return employeeRights;
	}

	public void setEmployeeRights(String employeeRights) {
		this.employeeRights = employeeRights;
	}

	/**
	 * �˺�
	 */
	String account;
	/**
	 * Ա������
	 */
	String userName;
	/**
	 * ����
	 */
	String passWord;
	/**
	 * Ա������
	 */
	String staffWork;
	/**
	 * Ա���Ա�
	 */
	String employeeRow;
	/**
	 * Ա��Ȩ��
	 */
	String employeeRights;
}
