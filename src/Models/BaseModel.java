package Models;

import java.time.LocalDateTime;

public class BaseModel {
	private LocalDateTime CreatedDate;
	private String CreatedBy;
	private LocalDateTime ModifiedDate;
	private String ModifiedBy;
	private String Description;
	
	public BaseModel() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseModel(LocalDateTime createdDate, String createdBy, LocalDateTime modifiedDate, String modifiedBy,
			String description) {
		CreatedDate = createdDate;
		CreatedBy = createdBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
		Description = description;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDateTime getCreatedDate() {
		return CreatedDate;
	}
	
	public void setCreatedDate(LocalDateTime createdDate) {
		CreatedDate = createdDate;
	}
	
	public String getCreatedBy() {
		return CreatedBy;
	}
	
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	
	public LocalDateTime getModifiedDate() {
		return ModifiedDate;
	}
	
	public void setModifiedDate(LocalDateTime modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	
	public String getModifiedBy() {
		return ModifiedBy;
	}
	
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	
	
}
