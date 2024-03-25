package MODEL;

import DAO.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    private static DbConnection db=new DbConnection();
    private static Connection conn= DbConnection.getConnection();
    public static boolean createUser(UserDAO user){
        String query = "INSERT INTO user (U_ID, U_NAME, AGE, HEIGHT, WEIGHT, D_ID, ROLE, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            String role="User";
            ps.setInt(1, user.getU_id());
            ps.setString(2, user.getU_name());
            ps.setInt(3, user.getAge());
            ps.setInt(4, user.getHeight());
            ps.setInt(5, user.getWeight());
            ps.setInt(6, user.getD_id());
//            ps.setNull(6, java.sql.Types.INTEGER); // Assuming D_ID is nullable
            ps.setString(7, role);
            ps.setString(8, user.getEmail());
            ps.setString(9, user.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean loginUser(String loginEmail, String loginPassword) {
        String query = "SELECT * FROM user WHERE EMAIL = ? AND PASSWORD = ? AND ROLE = 'User'";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, loginEmail);
            ps.setString(2, loginPassword);
            try (ResultSet rs = ps.executeQuery()) {
                // If no rows are returned, login failed
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean loginAdmin(String loginEmail, String loginPassword) {
        // SQL query to check if the provided credentials match an admin entry
        String query = "SELECT * FROM user WHERE EMAIL = ? AND PASSWORD = ? AND ROLE = 'Admin'";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, loginEmail);
            ps.setString(2, loginPassword);

            try (ResultSet rs = ps.executeQuery()) {
                // If a row is returned, the login credentials match an admin entry
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void showUser() {
        String query = "SELECT U_ID, U_NAME, AGE, HEIGHT, WEIGHT, D_ID, ROLE, EMAIL, PASSWORD FROM user";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("+------------+--------+------+--------+--------+------+-------+-----------------+--------------+");
                System.out.println("| U_ID       | U_NAME | AGE  | HEIGHT | WEIGHT | D_ID | ROLE  | EMAIL           | PASSWORD     |");
                System.out.println("+------------+--------+------+--------+--------+------+-------+-----------------+--------------+");

                while (rs.next()) {
                    System.out.printf("| %-11s| %-7s| %-5d| %-7d| %-7d| %-5d| %-6s| %-16s| %-12s|\n",
                            rs.getInt("U_ID"),
                            rs.getString("U_NAME"),
                            rs.getInt("AGE"),
                            rs.getInt("HEIGHT"),
                            rs.getInt("WEIGHT"),
                            rs.getInt("D_ID"),
                            rs.getString("ROLE"),
                            rs.getString("EMAIL"),
                            rs.getString("PASSWORD"));
                }

                System.out.println("+------------+--------+------+--------+--------+------+-------+-----------------+--------------+");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
