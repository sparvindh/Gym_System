package MODEL;

import DAO.PaymentDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentModel {
    private static DbConnection db = new DbConnection();
    private static Connection conn = DbConnection.getConnection();

    public static boolean addPayment(PaymentDAO paymentInfo, Date paymentDate) {
        String query = "INSERT INTO payment (P_ID, U_ID, P_METHOD, PAYMENT, PAYMENT_DATE, PL_ID) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, paymentInfo.getP_id());
            ps.setInt(2, paymentInfo.getU_id());
            ps.setString(3, paymentInfo.getP_method());
            ps.setInt(4, paymentInfo.getPayment());
            ps.setInt(5, paymentInfo.getPl_id());
            ps.setDate(6, paymentDate);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
