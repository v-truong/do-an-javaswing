package Models;

import java.time.LocalDateTime;

public class AccountModel extends BaseModel {
	private int AccountID;
	private String AccountName;
	private String Username;
	private String Password;
	private String PhoneNo;
	private int RoleID;
	
	

	public AccountModel(int accountID, String accountName, String username, String password, String phoneNo, int roleID) {
		AccountID = accountID;
		AccountName = accountName;
		Username = username;
		Password = password;
		PhoneNo = phoneNo;
		RoleID = roleID;
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public int getRoleID() {
		return RoleID;
	}

	public void setRoleID(int roleID) {
		RoleID = roleID;
	}

	public AccountModel() {
		// TODO Auto-generated constructor stub
	}

	public AccountModel(int accountID, String accountName, String username, String password, String phoneNo, int roleID,
			String description, LocalDateTime createdDate, String createdBy, LocalDateTime modifiedDate,
			String modifiedBy) {
		super(createdDate, createdBy, modifiedDate, modifiedBy, description);
		AccountID = accountID;
		AccountName = accountName;
		Username = username;
		Password = password;
		PhoneNo = phoneNo;
		RoleID = roleID;
	}
}
