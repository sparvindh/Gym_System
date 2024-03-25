package VIEW;

import CONTROLLER.DietController;
import DAO.DietDAO;
import MODEL.DietModel;

import java.util.Random;
import java.util.Scanner;

public class DietView {
    public static int Diet(int choice) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        switch (choice) {
            case 1 -> {
                int dietId = r.nextInt(Integer.MAX_VALUE);;
                System.out.println("Enter diet name:");
                String dietName = sc.nextLine();
                System.out.println("Enter description:");
                String description = sc.nextLine();
                DietDAO diet = new DietDAO(dietId, dietName, description);
                if (DietController.addDiet(diet)) {
                    System.out.println("Diet created successfully!");
                } else {
                    System.out.println("Failed to create diet.");
                }
            }
            case 2 -> {
                System.out.println("Enter diet ID to modify:");
                int dietIdToModify = sc.nextInt();
                sc.nextLine(); // Consume newline

                System.out.println("Enter new diet name:");
                String newDietName = sc.nextLine();
                System.out.println("Enter new description:");
                String newDescription = sc.nextLine();

                DietDAO dietToModify = new DietDAO(dietIdToModify, newDietName, newDescription);
                if (DietController.modifyDiet(dietToModify)) {
                    System.out.println("Diet modified successfully!");
                } else {
                    System.out.println("Failed to modify diet.");
                }
            }
            case 3 -> {
                System.out.println("Enter the ID of the record to delete:");
                int idToDelete = sc.nextInt();
                sc.nextLine(); // Consume newline

                if (DietController.deleteDietValues(idToDelete)) {
                    System.out.println("Values deleted successfully!");
                } else {
                    System.out.println("Failed to delete values.");
                }
            }

            case 4 -> {
                sc.close(); // Close scanner
                System.exit(0); // Exiting the application
            }
            default -> System.out.println("Invalid choice!");
        }

        return choice;
    }
    public static void showDiet(){
        DietModel.showDiet();
    }
}
