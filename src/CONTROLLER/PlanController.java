package CONTROLLER;

import DAO.PlansDAO;
import MODEL.PlanModel;
public class PlanController {
    public static boolean addPlan(PlansDAO plan){
        return PlanModel.createPlan(plan);
    }
    public static boolean modifyPlan(PlansDAO plan) {
        return PlanModel.modifyPlan(plan);
    }

    public static boolean deletePlan(int planId) {
        return PlanModel.deletePlan(planId);
    }

}
