package MAIN;
import CONTROLLER.UserController;
import VIEW.*;

import java.util.*;

import static VIEW.DietView.Diet;
import static VIEW.EquipmentView.Equipment;
import static VIEW.OfferView.Offer;
import static VIEW.PaymentView.paymentAdd;
import static VIEW.PlanView.Plan;
import static VIEW.UserView.User;

public class GymManagementSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("-----ENTER YOUR CHOICE------ ");
            System.out.println("-----1 Admin--------");
            System.out.println("-----2 user login--------");
            System.out.println("-----3 user signup--------");
            System.out.println("------4 EXIT-------");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("ENTER YOUR EMAIL:");
                    String AdminEmail = sc.nextLine();
                    System.out.println("ENTER YOUR PASSWORD:");
                    String AdminPassword = sc.nextLine();
                    if (UserController.loginAdmin(AdminEmail, AdminPassword)) {
                        System.out.println("Login successful!");
                        boolean adminLoop = true;
                        while (adminLoop) {
                            System.out.println("-----ENTER YOUR CHOICE------------- ");
                            System.out.println("------1 Modify the table------------");
                            System.out.println("------2 show the table--------------");
                            int achoice = sc.nextInt();
                            sc.nextLine(); // consume newline
                            switch (achoice) {
                                case 1 -> {
                                    System.out.println("---ENTER YOUR CHOICE----");
                                    System.out.println("------1 plan------------");
                                    System.out.println("------2 diet------------");
                                    System.out.println("------3 equipment-------");
                                    System.out.println("------4 offer-----------");
                                    System.out.println("------5 Exit------------");
                                    int secondchoice = sc.nextInt();
                                    switch (secondchoice) {
                                        case 1 -> {
                                            boolean planLoop = true;
                                            while (planLoop) {
                                                System.out.println("----- ENTER YOUR CHOICE -----");
                                                System.out.println("1. ADD NEW PLAN");
                                                System.out.println("2. MODIFY");
                                                System.out.println("3. DELETE");
                                                System.out.println("4. EXIT");
                                                int Adminchoice = Plan(sc.nextInt());
                                                if (Adminchoice == 4) {
                                                    planLoop = false;
                                                }
                                            }
                                        }
                                        case 2 -> {
                                            boolean dietLoop = true;
                                            while (dietLoop) {
                                                System.out.println("----- ENTER YOUR CHOICE -----");
                                                System.out.println("1. ADD NEW DIET");
                                                System.out.println("2. MODIFY");
                                                System.out.println("3. DELETE");
                                                System.out.println("4. EXIT");
                                                int Adminchoice = Diet(sc.nextInt());
                                                if (Adminchoice == 4) {
                                                    dietLoop = false;
                                                }
                                            }
                                        }
                                        case 3 -> {
                                            boolean equipmentLoop = true;
                                            while (equipmentLoop) {
                                                System.out.println("----- ENTER YOUR CHOICE -----");
                                                System.out.println("1. ADD NEW EQUIPMENT");
                                                System.out.println("2. MODIFY");
                                                System.out.println("3. DELETE");
                                                System.out.println("4. EXIT");
                                                int Adminchoice = Equipment(sc.nextInt());
                                                if (Adminchoice == 4) {
                                                    equipmentLoop = false;
                                                }
                                            }
                                        }
                                        case 4 -> {
                                            boolean offerLoop = true;
                                            while (offerLoop) {
                                                System.out.println("----- ENTER YOUR CHOICE -----");
                                                System.out.println("1. ADD NEW OFFER");
                                                System.out.println("2. MODIFY");
                                                System.out.println("3. DELETE");
                                                System.out.println("4. EXIT");
                                                int Adminchoice = Offer(sc.nextInt());
                                                if (Adminchoice == 4) {
                                                    offerLoop = false;
                                                }
                                            }
                                        }
                                        case 5 -> {
                                            sc.close(); // Close scanner
                                            System.exit(0); // Exiting the application
                                        }
                                    }
                                }
                                case 2-> {
                                    boolean showTableLoop = true;
                                    while (showTableLoop) {
                                        System.out.println("-----ENTER YOUR CHOICE------ ");
                                        System.out.println("-----1 plan view--------");
                                        System.out.println("------2 equipment view-------");
                                        System.out.println("-----3 diet view--------");
                                        System.out.println("------4 offer view-------");
                                        System.out.println("------5 User view-------");
                                        System.out.println("-------6 EXIT-------");
                                        int secondchoice = sc.nextInt();
                                        switch (secondchoice) {
                                            case 1:
                                                PlanView.showPlans();
                                                break;
                                            case 2:
                                                EquipmentView.showEquipment();
                                                break;
                                            case 3:
                                                DietView.showDiet();
                                                break;
                                            case 4:
                                                OfferView.showOffers();
                                                break;
                                            case 5:
                                                UserView.showUser();
                                                break;
                                            case 6:
                                                sc.close(); // Close scanner
                                                System.exit(0); // Exiting the application
                                                break;
                                        }
                                        System.out.println("Press 0 to exit, or any other number to continue: ");
                                        int exitChoice = sc.nextInt();
                                        if (exitChoice == 0) {
                                            showTableLoop = false;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Login failed. Please check your email and password.");
                    }
                    break;

                case 2:
                    System.out.println("ENTER YOUR EMAIL:");
                    String loginEmail = sc.nextLine();
                    System.out.println("ENTER YOUR PASSWORD:");
                    String loginPassword = sc.nextLine();
                    if (UserController.loginUser(loginEmail, loginPassword)) {
                        System.out.println("Login successful!");
                        boolean userLoop = true;
                        while (userLoop) {
                            System.out.println("-----ENTER YOUR CHOICE------ ");
                            System.out.println("-----1 plan view--------");
                            System.out.println("------2 equipment view-------");
                            System.out.println("-----3 diet view--------");
                            System.out.println("------4 offer view-------");
                            System.out.println("------5 make a payment-------");
                            System.out.println("-------6 EXIT-------");
                            int secondchoice = sc.nextInt();
                            switch (secondchoice) {
                                case 1:
                                    PlanView.showPlans();
                                    break;
                                case 2:
                                    EquipmentView.showEquipment();
                                    break;
                                case 3:
                                    DietView.showDiet();
                                    break;
                                case 4:
                                    OfferView.showOffers();
                                    break;
                                case 5:
                                    System.out.println("-----ENTER YOUR CHOICE------ ");
                                    System.out.println("-----1 PAYMENT--------");
                                    System.out.println("------2 EXIT-------");
                                    paymentAdd(sc.nextInt());
                                    break;
                                case 6:
                                    sc.close(); // Close scanner
                                    System.exit(0); // Exiting the application
                                    break;
                            }
                            System.out.println("Press 0 to exit, or any other number to continue: ");
                            int exitChoice = sc.nextInt();
                            if (exitChoice == 0) {
                                userLoop = false;
                            }
                        }
                    } else {
                        System.out.println("Login failed. Please check your email and password.");
                    }
                    break;

                case 3:
                    System.out.println("-----ENTER YOUR CHOICE------ ");
                    System.out.println("-----1 SIGN UP--------");
                    System.out.println("------2 EXIT-------");
                    User(sc.nextInt());
                    break;

                case 4:
                    sc.close(); // Close scanner
                    System.exit(0); // Exiting the application
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}



