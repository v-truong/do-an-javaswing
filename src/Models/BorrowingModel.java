package Models;

import java.time.LocalDateTime;

public class BorrowingModel extends BaseModel {
	private int BookID;
	private String BookName;
	private int AccountID;
	private String AccountName;
	private LocalDateTime BorrowedDate;
	private int Status;
	private LocalDateTime ReturnDate;

	public BorrowingModel(int bookID, String bookName, int accountID, String accountName, String description,
			LocalDateTime borrowedDate, int status, LocalDateTime returnDate, LocalDateTime createdDate,
			String createdBy, LocalDateTime modifiedDate, String modifiedBy) {
		super(createdDate, createdBy, modifiedDate, modifiedBy, description);
		BookID = bookID;
		BookName = bookName;
		AccountID = accountID;
		AccountName = accountName;
		BorrowedDate = borrowedDate;
		Status = status;
		ReturnDate = returnDate;
	}

	public BorrowingModel() {
		// TODO Auto-generated constructor stub
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public LocalDateTime getBorrowedDate() {
		return BorrowedDate;
	}

	public void setBorrowedDate(LocalDateTime borrowedDate) {
		BorrowedDate = borrowedDate;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public LocalDateTime getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		ReturnDate = returnDate;
	}

}
