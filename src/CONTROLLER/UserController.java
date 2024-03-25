package CONTROLLER;

import DAO.UserDAO;
import MODEL.UserModel;

public class UserController {
    public static boolean adduser(UserDAO user){
            return UserModel.createUser(user);
    }

    public static boolean loginUser(String loginEmail, String loginPassword) {
        return UserModel.loginUser(loginEmail,loginPassword);
    }
    public static boolean loginAdmin(String loginEmail, String loginPassword) {
        return UserModel.loginAdmin(loginEmail,loginPassword);
    }

}
