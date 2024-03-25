package CONTROLLER;

import DAO.PaymentDAO;
import MODEL.PaymentModel;

import java.sql.Date;

public class PaymentController {
    public static boolean addPayment(PaymentDAO paymentInfo, Date paymentDate){
        return PaymentModel.addPayment(paymentInfo , paymentDate);
    }

}
