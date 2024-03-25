package VIEW;

import CONTROLLER.PaymentController;
import DAO.PaymentDAO;

import java.util.Random;
import java.util.Scanner;
import java.sql.Date;

public class PaymentView {
    public static int paymentAdd(int choice) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

            switch (choice) {
                case 1:
                    int P_id = r.nextInt(Integer.MAX_VALUE);
                    System.out.println("Enter User Id:");
                    int u_id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter payment method:");
                    String p_method = sc.nextLine();
                    System.out.println("Enter payment amount:");
                    int paymentAmount = sc.nextInt();
                    System.out.println("Enter plan Id:");
                    int planId = sc.nextInt();
                    // Get the payment date
                    System.out.println("Enter payment date (YYYY-MM-DD):");
                    String date = sc.next();
                    Date paymentDate = Date.valueOf(date);

                    PaymentDAO paymentInfo = new PaymentDAO(P_id, u_id, p_method, paymentAmount, planId);
                    if (PaymentController.addPayment(paymentInfo, paymentDate)) {
                        System.out.println("Payment recorded successfully!");
                    } else {
                        System.out.println("Failed to record payment.");
                    }
                    break;

                case 2:
                    sc.close(); // Close scanner
                    System.exit(0); // Exiting the application
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        return choice;
    }

}
