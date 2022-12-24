package Models;

import java.time.LocalDateTime;

public class PublisherModel extends BaseModel {
	private int PublisherID;
	private String PublisherName;

	public PublisherModel() {
		// TODO Auto-generated constructor stub
	}

	public PublisherModel(int publisherID, String publisherName, String description, LocalDateTime createdDate,
			String createdBy, LocalDateTime modifiedDate, String modifiedBy) {
		super(createdDate, createdBy, modifiedDate, modifiedBy, description);
		PublisherID = publisherID;
		PublisherName = publisherName;
	}

	public int getPublisherID() {
		return PublisherID;
	}

	public void setPublisherID(int publisherID) {
		PublisherID = publisherID;
	}

	public String getPublisherName() {
		return PublisherName;
	}

	public void setPublisherName(String publisherName) {
		PublisherName = publisherName;
	}

}
