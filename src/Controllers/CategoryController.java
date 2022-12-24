package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.CategoryModel;
import Utilities.DBUtility;

public class CategoryController {
	private static CategoryController instance;

	public CategoryController() {
		// TODO Auto-generated constructor stub
	}

	public static CategoryController getInstance() {
		return instance;
	}

	public static void setInstance(CategoryController instance) {
		CategoryController.instance = instance;
	}

	public List<CategoryModel> GetCategories() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		Connection con = DBUtility.openConnection();

		try {
			PreparedStatement cmd = con.prepareStatement("SELECT * FROM category");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				CategoryModel cate = new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getString(5), rs.getTimestamp(6).toLocalDateTime(),
						rs.getString(7));

				list.add(cate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public CategoryModel GetCategoryDetail(int categoryID) {
		CategoryModel category = new CategoryModel();
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("SELECT * from category WHERE CategoryID = ?");
			cmd.setInt(1, categoryID);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				category.setCategoryID(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setDescription(rs.getString(3));
				category.setCreatedBy(rs.getString(4));
				category.setCreatedDate(rs.getTimestamp(5).toLocalDateTime());
				category.setModifiedBy(rs.getString(6));
				category.setCreatedDate(rs.getTimestamp(7).toLocalDateTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return category;
	}

	public Boolean CreateCategory(String categoryName, String description) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"INSERT INTO category (CategoryName, Description, CreatedDate, CreatedBy, ModifiedDate, ModifiedBy)\r\n"
							+ "  VALUES (?, ?, NOW(), 'Admin', NOW(), 'Admin');");
			cmd.setString(1, categoryName);
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

	public Boolean UpdateCategory(int categoryID, String categoryName, String description) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement(
					"UPDATE category a SET CategoryName = ?, Description = ?, ModifiedDate = NOW() WHERE CategoryID = ?;");
			cmd.setString(1, categoryName);
			cmd.setString(2, description);
			cmd.setInt(3, categoryID);
			int rs = cmd.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Boolean DeleteCategory(int categoryID) {
		Connection con = DBUtility.openConnection();
		try {
			PreparedStatement cmd = con.prepareStatement("DELETE FROM category WHERE CategoryID = ?");
			cmd.setInt(1, categoryID);
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
