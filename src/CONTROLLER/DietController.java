package CONTROLLER;

import DAO.DietDAO;
import MODEL.DietModel;

public class DietController {
    public static boolean addDiet(DietDAO diet) {
        return DietModel.addDiet(diet);
    }

    public static boolean modifyDiet(DietDAO diete) {
        return DietModel.modifyDiet(diete);
    }
    public static boolean deleteDietValues(int idToDelete) {
        return DietModel.deleteDietValues(idToDelete);
    }

}
