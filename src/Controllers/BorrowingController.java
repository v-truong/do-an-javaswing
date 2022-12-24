package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Models.BorrowingModel;
import Utilities.DBUtility;

public class BorrowingController {

    private static BorrowingController instance;

    public static BorrowingController getInstance() {
        return instance;
    }

    public static void setInstance(BorrowingController instance) {
        BorrowingController.instance = instance;
    }

    public BorrowingController() {
        // TODO Auto-generated constructor stub
    }

//	Hàm lấy danh sách mượn sách theo người mượn
    public List<BorrowingModel> GetDetailBorrowingByAccount(int accountID) {
        List<BorrowingModel> list = new ArrayList<BorrowingModel>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement cmd = con.prepareStatement(
                    "SELECT b.BookID, b1.BookName, b.AccountID, a.AccountName, b.BorrowedDate, b.Status, b.ReturnTime, b.CreatedDate, b.CreatedBy, b.ModifiedDate, b.ModifiedBy FROM borrowing b left join book b1 on b.BookID = b1.BookID left join account a on b.AccountID = a.AccountID WHERE b.AccountID = ?");
            cmd.setInt(1, accountID);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                LocalDateTime borrowedDate = rs.getTimestamp(5) != null ? rs.getTimestamp(5).toLocalDateTime() : null;
                LocalDateTime returnTime = rs.getTimestamp(7) != null ? rs.getTimestamp(7).toLocalDateTime() : null;
                LocalDateTime createdDate = rs.getTimestamp(8) != null ? rs.getTimestamp(8).toLocalDateTime() : null;
                LocalDateTime modifiedDate = rs.getTimestamp(10) != null ? rs.getTimestamp(10).toLocalDateTime() : null;
                BorrowingModel bk = new BorrowingModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(4),
                        borrowedDate, rs.getInt(6), returnTime, createdDate, rs.getString(9), modifiedDate, rs.getString(11));

                list.add(bk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

//	Hàm lấy danh sách mượn sách theo sách được mượn
    public List<BorrowingModel> GetDetailBorrowingByBook(int bookID) {
        List<BorrowingModel> list = new ArrayList<BorrowingModel>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement cmd = con.prepareStatement(
                    "SELECT b.BookID, b1.BookName, b.AccountID, a.AccountName, b.BorrowedDate, b.Status, b.ReturnTime, b.CreatedDate, b.CreatedBy, b.ModifiedDate, b.ModifiedBy FROM borrowing b left join book b1 on b.BookID = b1.BookID left join account a on b.AccountID = a.AccountID WHERE b.BookID = ?");
            cmd.setInt(1, bookID);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                LocalDateTime borrowedDate = rs.getTimestamp(5) != null ? rs.getTimestamp(5).toLocalDateTime() : null;
                LocalDateTime returnTime = rs.getTimestamp(7) != null ? rs.getTimestamp(7).toLocalDateTime() : null;
                LocalDateTime createdDate = rs.getTimestamp(8) != null ? rs.getTimestamp(8).toLocalDateTime() : null;
                LocalDateTime modifiedDate = rs.getTimestamp(10) != null ? rs.getTimestamp(10).toLocalDateTime() : null;
                BorrowingModel bk = new BorrowingModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(4),
                        borrowedDate, rs.getInt(6), returnTime, createdDate, rs.getString(9), modifiedDate, rs.getString(11));

                list.add(bk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Boolean CreateBorrowing(int accountID, int bookID, LocalDateTime borrowedDate, LocalDateTime returnDate) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement cmd = con.prepareStatement(
                    "INSERT INTO borrowing (BookID, AccountID, BorrowedDate, Status, ReturnTime, CreatedDate, CreatedBy, ModifiedDate, ModifiedBy) VALUES (?, ?, ?, 1, ?, NOW(), 'Admin', NOW(), 'Admin');");
            cmd.setInt(1, accountID);
            cmd.setInt(2, bookID);
            cmd.setObject(3, borrowedDate);
            cmd.setObject(4, returnDate);
            System.out.println(cmd);
            int rs = cmd.executeUpdate();
      
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateBorrowing(int accountID, int bookID, LocalDateTime borrowedDate, int status, LocalDateTime returnDate) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement cmd = con.prepareStatement(
                    "UPDATE borrowing b \n"
                    + "SET BorrowedDate = ?,\n"
                    + "    Status = ?,\n"
                    + "    ReturnTime = ?,\n"
                    + "    ModifiedDate = NOW(),\n"
                    + "WHERE BookID = ?\n"
                    + "AND AccountID = ?;");
            cmd.setInt(4, accountID);
            cmd.setInt(5, bookID);
            cmd.setObject(1, borrowedDate);
            cmd.setInt(2, status);
            cmd.setObject(3, returnDate);
            int rs = cmd.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateStatusBorrowing(int accountID, int bookID, int status) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement cmd = con.prepareStatement(
                   "UPDATE borrowing b SET Status = ?,\n"
                    + "ModifiedDate = NOW()\n"
                    + "WHERE BookID = ?\n"
                    + "AND AccountID = ?;");
            cmd.setInt(3, accountID);
            cmd.setInt(2, bookID);
            cmd.setInt(1, status);

            int rs = cmd.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean DeleteBorrowing(int accountID, int bookID) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement cmd = con.prepareStatement(
                    "DELETE FROM borrowing WHERE BookID = ? AND AccountID = ?");
            cmd.setInt(1, bookID);
            cmd.setInt(2, accountID);

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
