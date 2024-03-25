package DAO;

public class PaymentDAO {

    private int p_id;
    private int u_id;
    private String p_method;
    private int payment;
    private int pl_id;

    public PaymentDAO(int p_id, int u_id, String p_method, int payment, int pl_id) {
        this.p_id = p_id;
        this.u_id = u_id;
        this.p_method = p_method;
        this.payment = payment;
        this.pl_id = pl_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_method(String p_method) {
        this.p_method = p_method;
    }

    public String getP_method() {
        return p_method;
    }
    public void setPayment(int payment){
        this.payment=payment;
    }

    public int getPayment() {
        return payment;
    }

    public void setPl_id(int pl_id) {
        this.pl_id = pl_id;
    }

    public int getPl_id() {
        return pl_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}



