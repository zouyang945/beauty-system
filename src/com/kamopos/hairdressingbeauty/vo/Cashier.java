package com.kamopos.hairdressingbeauty.vo;

/**
 * 收营员
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
	 * 账号
	 */
	String account;
	/**
	 * 员工姓名
	 */
	String userName;
	/**
	 * 密码
	 */
	String passWord;
	/**
	 * 员工工种
	 */
	String staffWork;
	/**
	 * 员工性别
	 */
	String employeeRow;
	/**
	 * 员工权限
	 */
	String employeeRights;
}
