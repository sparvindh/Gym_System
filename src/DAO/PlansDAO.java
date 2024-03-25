package DAO;

public class PlansDAO {
    public int pl_id;
    public String pl_name;
    public int pl_price;
    public int pl_duration;

    public PlansDAO(int pl_id, int pl_duration, String pl_name, int pl_price) {
        this.pl_id=pl_id;
        this.pl_name=pl_name;
        this.pl_price=pl_price;
        this.pl_duration=pl_duration;
    }
    public void setPl_id(int pl_id) {
        this.pl_id = pl_id;
    }

    public int getPl_id() {
        return pl_id;
    }

    public void setPl_name(String pl_name) {
        this.pl_name = pl_name;
    }

    public String getPl_name() {
        return pl_name;
    }

    public void setPl_price(int pl_price) {
        this.pl_price = pl_price;
    }

    public int getPl_price() {
        return pl_price;
    }

    public void setPl_duration(int pl_duration) {
        this.pl_duration = pl_duration;
    }

    public int getPl_duration() {
        return pl_duration;
    }
}
