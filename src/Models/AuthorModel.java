package Models;

import java.time.LocalDateTime;

public class AuthorModel extends BaseModel {
	private int AuthorID;
	private String AuthorName;

	public int getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public AuthorModel() {
		// TODO Auto-generated constructor stub
	}

	public AuthorModel(int authorID, String authorName, String description, LocalDateTime createdDate, String createdBy,
			LocalDateTime modifiedDate, String modifiedBy) {
		super(createdDate, createdBy, modifiedDate, modifiedBy, description);
		AuthorID = authorID;
		AuthorName = authorName;
	}

}
