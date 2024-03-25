package CONTROLLER;

import DAO.OfferDAO;
import MODEL.OfferModel;

public class OfferController {
    public static boolean addOffer(OfferDAO offer) {
        return OfferModel.addOffer(offer);
    }

    public static boolean modifyOffer(OfferDAO offer) {
        return OfferModel.modifyOffer(offer);
    }

    public static boolean deleteOffer(int offerId) {
        return OfferModel.deleteOffer(offerId);
    }
}
