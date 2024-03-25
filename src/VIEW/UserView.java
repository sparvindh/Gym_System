package VIEW;

import CONTROLLER.UserController;
import DAO.UserDAO;
import MODEL.UserModel;

import java.util.Scanner;
import java.util.Random;

public class UserView {
    public static int User(int choice){
        Scanner sc = new Scanner(System.in);
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Random r = new Random();

            switch (choice) {
                case 1:
                    int u_id = r.nextInt(Integer.MAX_VALUE); // Generate positive random integer
                    String email;
                    do {
                        System.out.println("ENTER YOUR GMAIL:");
                        email = sc.nextLine();
                        if (!email.matches(emailPattern)) {
                            System.out.println("Invalid Email. Please enter a valid email address.");
                        }
                    } while (!email.matches(emailPattern));

                    String u_password;
                    do {
                        System.out.println("SET YOUR PASSWORD (at least 8 characters, including 1 uppercase, 1 lowercase, 1 digit, and 1 special character):");
                        u_password = sc.nextLine();
                        if (!u_password.matches(passwordPattern)) {
                            System.out.println("Invalid Password. Password must contain at least 8 characters, including 1 uppercase, 1 lowercase, 1 digit, and 1 special character.");
                        }
                    } while (!u_password.matches(passwordPattern));

                    System.out.println("ENTER YOUR USER NAME");
                    String u_name = sc.nextLine();
                    System.out.println("ENTER YOUR AGE");
                    int age = sc.nextInt();
                    System.out.println("ENTER YOUR HEIGHT");
                    int height = sc.nextInt();
                    System.out.println("ENTER YOUR WEIGHT");
                    int weight = sc.nextInt();
                    System.out.println("weightloss session enter 1");
                    System.out.println("weightgain session enter 2");
                    int d_id= sc.nextInt();
                    UserDAO user = new UserDAO(u_id, u_name, age, height, weight,d_id,email, u_password);
                    if (UserController.adduser(user)) {
                        System.out.println("User created successfully!");
                    } else {
                        System.out.println("Failed to create user.");
                    }
                    break;
                case 2:
                    System.exit(0); // Exiting the application
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        return choice;
    }
    public static void showUser() {
        UserModel.showUser();
    }
}
