package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.PublisherModel;
import Utilities.DBUtility;

public class PublisherController {
	private static PublisherController instance;

	public PublisherController() {
		// TODO Auto-generated constructor stub
	}

	public static PublisherController getInstance() {
		return instance;
	}

	public static void setInstance(PublisherController instance) {
		PublisherController.instance = instance;
	}

	public List<PublisherModel> GetPublishers() {
		List<PublisherModel> list = new ArrayList<PublisherModel>();
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("SELECT * FROM publisher");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				PublisherModel pler = new PublisherModel(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getString(5), rs.getTimestamp(6).toLocalDateTime(),
						rs.getString(7));

				list.add(pler);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public PublisherModel GetPublisherDetail(int publisherID) {
		PublisherModel publisher = new PublisherModel();
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("SELECT * from publisher WHERE PublisherID = ?");
			cmd.setInt(1, publisherID);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				publisher.setPublisherID(rs.getInt(1));
				publisher.setPublisherName(rs.getString(2));
				publisher.setDescription(rs.getString(3));
				publisher.setCreatedBy(rs.getString(4));
				publisher.setCreatedDate(rs.getTimestamp(5).toLocalDateTime());
				publisher.setModifiedBy(rs.getString(6));
				publisher.setCreatedDate(rs.getTimestamp(7).toLocalDateTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return publisher;
	}

	public Boolean CreatePublisher(String publisherName, String description) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"INSERT INTO publisher (PublisherName, Description, CreatedDate, CreatedBy, ModifiedDate, ModifiedBy)\r\n"
							+ "  VALUES (?, ?, NOW(), 'Admin', NOW(), 'Admin');");
			cmd.setString(1, publisherName);
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

	public Boolean UpdatePublisher(int publisherID, String publisherName, String description) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"UPDATE publisher a SET PublisherName = ?, Description = ?, ModifiedDate = NOW() WHERE PublisherID = ?;");
			cmd.setString(1, publisherName);
			cmd.setString(2, description);
			cmd.setInt(3, publisherID);
			int rs = cmd.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Boolean DeletePublisher(int publisherID) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("DELETE FROM publisher WHERE PublisherID = ?");
			cmd.setInt(1, publisherID);
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
