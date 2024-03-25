package MODEL;

import DAO.OfferDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferModel {
    private static DbConnection db = new DbConnection();
    private static Connection conn = DbConnection.getConnection();

    public static boolean addOffer(OfferDAO offer) {
        String query = "INSERT INTO offers (o_id, o_percentage, o_description) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, offer.getO_id());
            ps.setInt(2, offer.getPercentage());
            ps.setString(3, offer.getO_description());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean modifyOffer(OfferDAO offer) {
        String query = "UPDATE offers SET o_percentage = ?, o_description = ? WHERE o_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, offer.getPercentage());
            ps.setString(2, offer.getO_description());
            ps.setInt(3, offer.getO_id());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteOffer(int offerId) {
        String query = "DELETE FROM offers WHERE o_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, offerId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void showOffers() {
        String query = "SELECT * FROM offers";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("+------------+--------------+---------------+");
                System.out.println("| O_ID       | O_PERCENTAGE | O_DESCRIPTION |");
                System.out.println("+------------+--------------+---------------+");

                while (rs.next()) {
                    int offerId = rs.getInt("O_ID");
                    int percentage = rs.getInt("O_PERCENTAGE");
                    String description = rs.getString("O_DESCRIPTION");

                    String formattedRow = String.format("| %-10d | %-12d | %-13s |", offerId, percentage, description);
                    System.out.println(formattedRow);
                }

                System.out.println("+------------+--------------+---------------+");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
