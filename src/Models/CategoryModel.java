package Models;

import java.time.LocalDateTime;

public class CategoryModel extends BaseModel {
	private int CategoryID;
	private String CategoryName;

	public CategoryModel() {
		// TODO Auto-generated constructor stub
	}

	public CategoryModel(int categoryID, String categoryName, String description, LocalDateTime createdDate,
			String createdBy, LocalDateTime modifiedDate, String modifiedBy) {
		super(createdDate, createdBy, modifiedDate, modifiedBy, description);
		CategoryID = categoryID;
		CategoryName = categoryName;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

}
