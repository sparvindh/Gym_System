package DAO;

public class OfferDAO {

        private int o_id;
        private int percentage;
        private String o_description;
        public OfferDAO(int o_id,int percentage,String o_description){
            this.o_id=o_id;
            this.percentage=percentage;
            this.o_description=o_description;
        }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setPercentage(int percentage){
            this.percentage=percentage;
        }

        public int getPercentage() {
        return percentage;
        }

    public void setO_description(String o_description) {
        this.o_description = o_description;
    }

    public String getO_description() {
        return o_description;
    }
}
