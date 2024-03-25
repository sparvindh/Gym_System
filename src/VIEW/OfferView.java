package VIEW;

import CONTROLLER.OfferController;
import DAO.OfferDAO;
import MODEL.DietModel;
import MODEL.OfferModel;

import java.util.Random;
import java.util.Scanner;

public class OfferView {
    public static int Offer(int choice) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        switch (choice) {
            case 1:
                // Code for adding a new offer
                int o_id = r.nextInt(Integer.MAX_VALUE);
                System.out.println("Enter percentage:");
                int percentage = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Enter description:");
                String description = sc.nextLine();

                OfferDAO offer = new OfferDAO(o_id, percentage, description);
                if (OfferController.addOffer(offer)) {
                    System.out.println("Offer created successfully!");
                } else {
                    System.out.println("Failed to create offer.");
                }
                break;
            case 2:
                // Code for modifying an offer
                System.out.println("Enter the ID of the offer to modify:");
                int offerIdToModify = sc.nextInt();
                sc.nextLine(); // Consume newline

                System.out.println("Enter new percentage:");
                int newPercentage = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Enter new description:");
                String newDescription = sc.nextLine();

                OfferDAO modifiedOffer = new OfferDAO(offerIdToModify, newPercentage, newDescription);
                if (OfferController.modifyOffer(modifiedOffer)) {
                    System.out.println("Offer modified successfully!");
                } else {
                    System.out.println("Failed to modify offer.");
                }
                break;
            case 3:
                // Code for deleting an offer
                System.out.println("Enter the ID of the offer to delete:");
                int offerIdToDelete = sc.nextInt();
                sc.nextLine(); // Consume newline

                if (OfferController.deleteOffer(offerIdToDelete)) {
                    System.out.println("Offer deleted successfully!");
                } else {
                    System.out.println("Failed to delete offer.");
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
    public static void showOffers(){
        OfferModel.showOffers();
    }
}
