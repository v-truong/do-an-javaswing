package Controllers;

import Utilities.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.AuthorModel;

public class AuthorController {
	private static AuthorController instance;

	public AuthorController() {
		// TODO Auto-generated constructor stub
	}

	public static AuthorController getInstance() {
		return instance;
	}

	public static void setInstance(AuthorController instance) {
		AuthorController.instance = instance;
	}

	public List<AuthorModel> GetAuthors() {
		List<AuthorModel> list = new ArrayList<AuthorModel>();
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("SELECT * FROM author");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				AuthorModel acc = new AuthorModel(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getString(5), rs.getTimestamp(6).toLocalDateTime(),
						rs.getString(7));

				list.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public AuthorModel GetAuthorDetail(int authorID) {
		AuthorModel author = new AuthorModel();
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("SELECT * from author WHERE AuthorID = ?");
			cmd.setInt(1, authorID);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				author.setAuthorID(rs.getInt(1));
				author.setAuthorName(rs.getString(2));
				author.setDescription(rs.getString(3));
				author.setCreatedBy(rs.getString(4));
				author.setCreatedDate(rs.getTimestamp(5).toLocalDateTime());
				author.setModifiedBy(rs.getString(6));
				author.setCreatedDate(rs.getTimestamp(7).toLocalDateTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return author;
	}

	public Boolean CreateAuthor(String authorName, String description) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"INSERT INTO author (AuthorName, Description, CreatedDate, CreatedBy, ModifiedDate, ModifiedBy)\r\n"
							+ "  VALUES (?, ?, NOW(), 'Admin', NOW(), 'Admin');");
			cmd.setString(1, authorName);
			cmd.setString(2, description);
			int rs = cmd.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Boolean UpdateAuthor(int authorID, String authorName, String description) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"UPDATE author a SET AuthorName = ?, Description = ?, ModifiedDate = NOW() WHERE AuthorID = ?;");
			cmd.setString(1, authorName);
			cmd.setString(2, description);
			cmd.setInt(3, authorID);
			int rs = cmd.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Boolean DeleteAuthor(int authorID) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("DELETE FROM author WHERE AuthorID = ?");
			cmd.setInt(1, authorID);
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
