package MODEL;

import DAO.DietDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DietModel {
    private static DbConnection db = new DbConnection();
    private static Connection conn = DbConnection.getConnection();

    public static boolean addDiet(DietDAO diet) {
        String query = "INSERT INTO diet (D_ID, D_NAME, D_DESCRIPTION) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, diet.getD_id());
            ps.setString(2, diet.getD_name());
            ps.setString(3, diet.getD_desc());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modifyDiet(DietDAO diet) {
        String query = "UPDATE diet SET D_NAME = ?, D_DESCRIPTION = ? WHERE D_ID = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, diet.getD_name());
            ps.setString(2, diet.getD_desc());
            ps.setInt(3, diet.getD_id());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean deleteDietValues(int idToDelete) {
        String query = "DELETE FROM diet WHERE D_ID = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idToDelete);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                System.out.println("No values found matching criteria.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while deleting values:");
            e.printStackTrace();
            return false;
        }
    }
    public static void showDiet() {
        String query = "SELECT * FROM diet";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("+-----------+-------------+-----------------------------------------------------------------------------------------+");
                System.out.println("| D_ID      | D_NAME      | D_DESCRIPTION                                                                           |");
                System.out.println("+-----------+-------------+-----------------------------------------------------------------------------------------+");

                while (rs.next()) {
                    int dietId = rs.getInt("D_ID");
                    String dietName = rs.getString("D_NAME");
                    String description = rs.getString("D_DESCRIPTION");

                    // Adjust the format to align columns properly
                    String formattedId = String.format("| %-9s", dietId);
                    String formattedName = String.format("| %-11s", dietName);
                    String formattedDescription = String.format("| %-83s |", description);

                    String formattedRow = formattedId + formattedName + formattedDescription;
                    System.out.println(formattedRow);
                }

                System.out.println("+-----------+-------------+-----------------------------------------------------------------------------------------+");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
