package Controllers;

import Models.RoleModel;
import Utilities.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleController {
	private static RoleController instance;
	RoleModel role = new RoleModel();

	public RoleController() {
		// TODO Auto-generated constructor stub
	}

	public static RoleController getInstance() {
		return instance;
	}

	public static void setInstance(RoleController instance) {
		RoleController.instance = instance;
	}

	public List<RoleModel> GetRoles() {
		Connection con = DBUtility.openConnection();
		List<RoleModel> list = new ArrayList<RoleModel>();
		try {
			PreparedStatement cmd = con.prepareStatement("SELECT * FROM role");
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				RoleModel rl = new RoleModel(rs.getInt(1), rs.getString(2), rs.getString(2), rs.getTimestamp(3).toLocalDateTime(),
						rs.getString(4), rs.getTimestamp(5).toLocalDateTime(), rs.getString(6));
				list.add(rl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}

