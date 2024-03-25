package MODEL;

import DAO.PlansDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanModel {
    private static DbConnection db = new DbConnection();
    private static Connection conn = DbConnection.getConnection();

    public static boolean createPlan(PlansDAO plan) {
        String query = "INSERT INTO plans (pl_id, pl_duration, pl_name, pl_price) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, plan.getPl_id());
            ps.setInt(2, plan.getPl_duration());
            ps.setString(3, plan.getPl_name());
            ps.setInt(4, plan.getPl_price());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean modifyPlan(PlansDAO plan) {
        String query = "UPDATE plans SET pl_duration = ?, pl_name = ?, pl_price = ? WHERE pl_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, plan.getPl_duration());
            ps.setString(2, plan.getPl_name());
            ps.setInt(3, plan.getPl_price());
            ps.setInt(4, plan.getPl_id());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deletePlan(int planId) {
        String query = "DELETE FROM plans WHERE pl_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, planId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void showPlans() {
        String query = "SELECT * FROM plans";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("+------------+------------+------------------------+-------+");
                System.out.println("| Plan ID    | Duration   | Name                   | Price |");
                System.out.println("+------------+------------+------------------------+-------+");

                while (rs.next()) {
                    int planId = rs.getInt("pl_id");
                    int duration = rs.getInt("pl_duration");
                    String name = rs.getString("pl_name");
                    int price = rs.getInt("pl_price");

                    String formattedRow = String.format("| %-10d | %-10d | %-23s | %-5d |", planId, duration, name, price);
                    System.out.println(formattedRow);
                }
                System.out.println("+------------+------------+------------------------+-------+");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
