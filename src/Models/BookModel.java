package Models;

import java.time.LocalDateTime;

public class BookModel extends BaseModel {
	private int BookID;
	private String BookName;
	private int CategoryID;
	private int AuthorID;
	private int PublisherID;
	private LocalDateTime PublishDate;
	private double Price;
	private int Quantity;
	private String CategoryName;
	private String AuthorName;
	private String PublisherName;

	public BookModel() {
		// TODO Auto-generated constructor stub
	}
	
	public BookModel(int bookID, String bookName, String description, int categoryID, String categoryName, int authorID, String authorName, int publisherID,
			String publisherName, LocalDateTime publishDate, double price, int quantity, LocalDateTime createdDate, String createdBy,
			LocalDateTime modifiedDate, String modifiedBy) {
		super(createdDate, createdBy, modifiedDate, modifiedBy, description);
		BookID = bookID;
		BookName = bookName;
		CategoryID = categoryID;
		AuthorID = authorID;
		PublisherID = publisherID;
		PublishDate = publishDate;
		Price = price;
		Quantity = quantity;
		CategoryName = categoryName;
		AuthorName = authorName;
		PublisherName = publisherName;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public String getPublisherName() {
		return PublisherName;
	}

	public void setPublisherName(String publisherName) {
		PublisherName = publisherName;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public int getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}

	public int getPublisherID() {
		return PublisherID;
	}

	public void setPublisherID(int publisherID) {
		PublisherID = publisherID;
	}

	public LocalDateTime getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		PublishDate = publishDate;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
