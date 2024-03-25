package VIEW;

import CONTROLLER.PlanController;
import DAO.PlansDAO;
import MODEL.PlanModel;

import java.util.Random;
import java.util.Scanner;

public class PlanView {
    public static int Plan(int choice){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
            switch (choice) {
                case 1:
                    int pl_id = r.nextInt(Integer.MAX_VALUE);
                    System.out.println("Enter duration:");
                    int pl_duration = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter name:");
                    String pl_name = sc.nextLine();
                    System.out.println("Enter price:");
                    int pl_price = sc.nextInt();

                    PlansDAO plan = new PlansDAO(pl_id, pl_duration, pl_name, pl_price);
                    if (PlanController.addPlan(plan)) {
                        System.out.println("Plan created successfully!");
                    } else {
                        System.out.println("Failed to create plan.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the ID of the plan to modify:");
                    int planIdToModify = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    System.out.println("Enter new duration:");
                    int newDuration = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter new name:");
                    String newName = sc.nextLine();
                    System.out.println("Enter new price:");
                    int newPrice = sc.nextInt();

                    PlansDAO modifiedPlan = new PlansDAO(planIdToModify, newDuration, newName, newPrice);
                    if (PlanController.modifyPlan(modifiedPlan)) {
                        System.out.println("Plan modified successfully!");
                    } else {
                        System.out.println("Failed to modify plan.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the ID of the plan to delete:");
                    int planIdToDelete = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    if (PlanController.deletePlan(planIdToDelete)) {
                        System.out.println("Plan deleted successfully!");
                    } else {
                        System.out.println("Failed to delete plan.");
                    }
                    break;
                case 4:
                    sc.close(); // Close scanner
                    System.exit(0); // Exiting the application
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        return choice;
    }
    public static void showPlans() {
        PlanModel.showPlans();
    }
}
