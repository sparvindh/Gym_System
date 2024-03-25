package MODEL;

import DAO.EquipmentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentModel {
    private static DbConnection db = new DbConnection();
    private static Connection conn = DbConnection.getConnection();

    public static boolean addEquip(EquipmentDAO equip) {
        String query = "INSERT INTO equipment (e_id, e_name, e_model, e_type) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, equip.getE_id());
            ps.setString(2, equip.getE_name());
            ps.setInt(3, equip.getE_model());
            ps.setString(4, equip.getE_type());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean modifyEquip(EquipmentDAO equip) {
        String query = "UPDATE equipment SET e_name = ?, e_model = ?, e_type = ? WHERE e_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, equip.getE_name());
            ps.setInt(2, equip.getE_model());
            ps.setString(3, equip.getE_type());
            ps.setInt(4, equip.getE_id());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteEquip(int idToDelete) {
        String query = "DELETE FROM equipment WHERE e_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idToDelete);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void showEquipment() {
        String query = "SELECT * FROM equipment";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("+------------+--------------+---------+---------------+");
                System.out.println("| E_ID       | E_NAME       | E_MODEL | E_TYPE        |");
                System.out.println("+------------+--------------+---------+---------------+");

                while (rs.next()) {
                    int equipmentId = rs.getInt("E_ID");
                    String name = rs.getString("E_NAME");
                    int model = rs.getInt("E_MODEL");
                    String type = rs.getString("E_TYPE");

                    String formattedRow = String.format("| %-11d | %-12s | %-7d | %-13s |", equipmentId, name, model, type);
                    System.out.println(formattedRow);
                }

                System.out.println("+------------+--------------+---------+---------------+");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
