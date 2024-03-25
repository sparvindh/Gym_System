package VIEW;

import CONTROLLER.EquipmentController;
import DAO.EquipmentDAO;
import MODEL.EquipmentModel;
import MODEL.PlanModel;

import java.util.Random;
import java.util.Scanner;

public class EquipmentView {
    public static int Equipment(int choice){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        switch (choice) {
            case 1 -> {
                int e_id = r.nextInt(Integer.MAX_VALUE);
                System.out.println("Enter name:");
                String e_name = sc.nextLine();
                System.out.println("Enter model:");
                int e_model = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Enter type:");
                String e_type = sc.nextLine();
                EquipmentDAO equip = new EquipmentDAO(e_id, e_name, e_model, e_type);
                if (EquipmentController.addEquip(equip)) {
                    System.out.println("Equipment created successfully!");
                } else {
                    System.out.println("Failed to create equipment.");
                }
            }
            case 2 -> {
                System.out.println("Enter the ID of the equipment to modify:");
                int idToModify = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Enter new name:");
                String newName = sc.nextLine();
                System.out.println("Enter new model:");
                int newModel = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Enter new type:");
                String newType = sc.nextLine();
                EquipmentDAO modifiedEquip = new EquipmentDAO(idToModify, newName, newModel, newType);
                if (EquipmentController.modifyEquip(modifiedEquip)) {
                    System.out.println("Equipment modified successfully!");
                } else {
                    System.out.println("Failed to modify equipment.");
                }
            }
            case 3 -> {
                System.out.println("Enter the ID of the equipment to delete:");
                int idToDelete = sc.nextInt();
                sc.nextLine(); // Consume newline
                if (EquipmentController.deleteEquip(idToDelete)) {
                    System.out.println("Equipment deleted successfully!");
                } else {
                    System.out.println("Failed to delete equipment.");
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
    public static void showEquipment() {
        EquipmentModel.showEquipment();
    }
}
