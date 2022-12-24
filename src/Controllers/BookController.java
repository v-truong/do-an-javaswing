package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Models.BookModel;
import Utilities.DBUtility;

public class BookController {

    private static BookController instance;

    public BookController() {
        // TODO Auto-generated constructor stub
    }

    public static BookController getInstance() {
        return instance;
    }

    public static void setInstance(BookController instance) {
        BookController.instance = instance;
    }

    public List<BookModel> GetBooks() {
        List<BookModel> list = new ArrayList<BookModel>();
        Connection con = DBUtility.openConnection();

        try {
            PreparedStatement cmd = con.prepareStatement(
                    "SELECT b.BookID, b.BookName, b.Description, b.CategoryID, b.AuthorID, b.PublisherID, b.PublishDate, b.Price, b.Quantity, b.CreatedDate, b.CreatedBy, b.ModifiedDate, b.ModifiedBy, a.AuthorName, c.CategoryName, p.PublisherName FROM book b, author a, category c, publisher p WHERE b.CategoryID = c.CategoryID AND b.AuthorID = a.AuthorID AND b.PublisherID = p.PublisherID");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                LocalDateTime publisheDate = rs.getTimestamp(7) != null ? rs.getTimestamp(7).toLocalDateTime() : null;
                LocalDateTime createdDate = rs.getTimestamp(10) != null ? rs.getTimestamp(10).toLocalDateTime() : null;
                LocalDateTime modifiedDate = rs.getTimestamp(12) != null ? rs.getTimestamp(12).toLocalDateTime() : null;
                BookModel bk = new BookModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(15), rs.getInt(5), rs.getString(14), rs.getInt(6), rs.getString(16), publisheDate,
                        rs.getDouble(8), rs.getInt(9), createdDate, rs.getString(11), modifiedDate, rs.getString(13));

                list.add(bk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public BookModel GetDetailBook(int bookID) {
        Connection con = DBUtility.openConnection();
        BookModel book = new BookModel();
        try {
            PreparedStatement cmd = con.prepareStatement(
                    "SELECT b.BookID, b.BookName, b.Description, b.CategoryID, b.AuthorID, b.PublisherID, b.PublishDate, b.Price, b.Quantity, b.CreatedDate, b.CreatedBy, b.ModifiedDate, b.ModifiedBy FROM book b WHERE B.BookID = ?");
            cmd.setInt(1, bookID);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                book.setBookID(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setDescription(rs.getString(3));
                book.setCategoryID(rs.getInt(4));
                book.setAuthorID(rs.getInt(5));
                book.setPublisherID(rs.getInt(6));
                book.setPublishDate(rs.getTimestamp(7).toLocalDateTime());
                book.setPrice(rs.getDouble(8));
                book.setQuantity(rs.getInt(9));
                book.setCreatedDate(rs.getTimestamp(10).toLocalDateTime());
                book.setCreatedBy(rs.getString(11));
                book.setModifiedDate(rs.getTimestamp(12).toLocalDateTime());
                book.setModifiedBy(rs.getString(13));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Boolean CreateBook(String bookName, String description, int categoryID, int authorID, int publisherID,
            LocalDateTime publishDate, double price, int quantity) {
        Connection con = DBUtility.openConnection();

        try {
            PreparedStatement cmd = con.prepareStatement(
                    "INSERT INTO book (BookName, Description, CategoryID, AuthorID, PublishierID, PublishDate, Price, Quantity, CreatedDate, CreatedBy, ModifiedDate, ModifiedBy)\r\n"
                    + "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), 'Admin', NOW(), 'Admin');");
            cmd.setString(1, bookName);
            cmd.setString(2, description);
            cmd.setInt(3, categoryID);
            cmd.setInt(4, authorID);
            cmd.setInt(5, publisherID);
            cmd.setObject(6, publishDate);
            cmd.setDouble(7, price);
            cmd.setInt(8, quantity);

            int rs = cmd.executeUpdate();
            if (rs > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateBook(int bookID, String bookName, String description, int categoryID, int authorID,
            int publisherID, LocalDateTime publishDate, double price, int quantity) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement cmd = con.prepareStatement("UPDATE book b \r\n" + "SET BookName = ?,\r\n"
                    + "    Description = ?,\r\n" + "    CategoryID = ?,\r\n" + "    AuthorID = ?,\r\n"
                    + "    PublishierID = ?,\r\n" + "    PublishDate = ?,\r\n" + "    Price = ?,\r\n"
                    + "    Quantity = ?,\r\n" + "    ModifiedDate = NOW(),\r\n" + "WHERE BookID = ?;");

            cmd.setString(1, bookName);
            cmd.setString(2, description);
            cmd.setInt(3, categoryID);
            cmd.setInt(4, authorID);
            cmd.setInt(5, publisherID);
            cmd.setObject(6, publishDate);
            cmd.setDouble(7, price);
            cmd.setInt(8, quantity);
            cmd.setInt(9, bookID);

            int rs = cmd.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean DeleteBook(int bookID) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement cmd = con.prepareStatement("DELETE FROM book WHERE BookID = ?");
            cmd.setInt(1, bookID);
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
