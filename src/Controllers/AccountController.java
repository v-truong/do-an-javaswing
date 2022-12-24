package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.AccountModel;
import Utilities.DBUtility;

public class AccountController {
	private static AccountController instance;
	AccountModel account = new AccountModel();

	public AccountController() {
		// TODO Auto-generated constructor stub
	}

	public static AccountController getInstance() {
		if (instance == null) {
			instance = new AccountController();
		}

		return instance;
	}

	public static void setInstance(AccountController instance) {
		AccountController.instance = instance;
	}

	public Boolean Login(String username, String pwd) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"SELECT a.AccountID, a.AccountName, a.Username, a.Password, a.Description, a.PhoneNo, a.RoleID FROM account a LEFT JOIN role r ON a.RoleID = r.RoleID WHERE a.Username = ? AND a.Password = ? AND r.RoleName = 'Admin'");
			cmd.setString(1, username);
			cmd.setString(2, pwd);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				account.setAccountID(rs.getInt(1));
				account.setAccountName(rs.getString(2));
				account.setUsername(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setDescription(rs.getString(5));
				account.setPhoneNo(rs.getString(6));
				account.setRoleID(rs.getInt(7));
//				Account account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(7));
//				System.out.println(account);
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<AccountModel> GetAccounts() {
		List<AccountModel> list = new ArrayList<AccountModel>();

		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"SELECT a.AccountID, a.AccountName, a.Username, a.Password, a.Description, a.PhoneNo, a.RoleID, a.CreatedDate, a.CreatedBy, a.ModifiedDate, a.ModifiedBy FROM account a LEFT JOIN role r ON a.RoleID = r.RoleID WHERE r.RoleName = 'User'");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				AccountModel acc = new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(6), rs.getInt(7), rs.getString(5), rs.getTimestamp(8).toLocalDateTime(),
						rs.getString(9), rs.getTimestamp(10).toLocalDateTime(), rs.getString(11));

				list.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
        
        public AccountModel GetAccountDetail(int accountID){
            AccountModel account = new AccountModel();
            Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("SELECT * from account WHERE AccountID = ?");
			cmd.setInt(1, accountID);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				account.setAccountID(rs.getInt(1));
				account.setAccountName(rs.getString(2));				
                                account.setUsername(rs.getString(3));
				account.setPassword(rs.getString(4));
                                account.setDescription(rs.getString(5));
				account.setPhoneNo(rs.getString(6));
                                account.setRoleID(rs.getInt(7));
				account.setCreatedBy(rs.getString(9));
				account.setCreatedDate(rs.getTimestamp(8).toLocalDateTime());
				account.setModifiedBy(rs.getString(11));
				account.setCreatedDate(rs.getTimestamp(10).toLocalDateTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
        }

	public Boolean CreateAccount(String accountName, String username, String password, String phoneNo,
			int roleID, String description) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"INSERT INTO account (AccountName, Username, Password, Description, PhoneNo, RoleID, CreatedDate, CreatedBy, ModifiedDate, ModifiedBy)\r\n"
							+ "  VALUES (?, ?, ?, ?, ?, ?, NOW(), 'Admin', NOW(), 'Admin');");
			cmd.setString(1, accountName);
			cmd.setString(2, username);
			cmd.setString(3, password);
			cmd.setString(4, description);
			cmd.setString(5, phoneNo);
			cmd.setInt(6, roleID);
			int rs = cmd.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Boolean UpdateAccount(int accountID, String accountName, String username, String password, String phoneNo,
			int roleID, String description) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"UPDATE account a SET AccountName = ?, Username = ?, Password = ?, Description = ?, \r\n"
							+ "PhoneNo = ?, RoleID = ?, ModifiedDate = NOW() WHERE AccountID = ?;");
			cmd.setString(1, accountName);
			cmd.setString(2, username);
			cmd.setString(3, password);
			cmd.setString(4, description);
			cmd.setString(5, phoneNo);
			cmd.setInt(6, roleID);
			cmd.setInt(7, accountID);
			int rs = cmd.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Boolean DeleteAccount(int accountID) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("DELETE FROM account WHERE AccountID = ?");
			cmd.setInt(1, accountID);
			int rs = cmd.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
