package CONTROLLER;

import DAO.EquipmentDAO;
import MODEL.EquipmentModel;


public class EquipmentController {
    public static boolean addEquip(EquipmentDAO equip){
        return EquipmentModel.addEquip(equip);
    }
    public static boolean modifyEquip(EquipmentDAO equip) {
        return EquipmentModel.modifyEquip(equip);
    }

    public static boolean deleteEquip(int idToDelete) {
        return EquipmentModel.deleteEquip(idToDelete);
    }

}
