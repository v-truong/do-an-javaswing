package Models;

import java.time.LocalDateTime;

public class RoleModel extends BaseModel {
	private int RoleID;
	private String RoleName;

	public RoleModel(int roleID, String roleName, String description, LocalDateTime createdDate, String createdBy,
			LocalDateTime modifiedDate, String modifiedBy) {
		super(createdDate, createdBy, modifiedDate, modifiedBy, description);
		RoleID = roleID;
		RoleName = roleName;
	}

	public RoleModel() {
		// TODO Auto-generated constructor stub
	}

	public int getRoleID() {
		return RoleID;
	}

	public void setRoleID(int roleID) {
		RoleID = roleID;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

}
