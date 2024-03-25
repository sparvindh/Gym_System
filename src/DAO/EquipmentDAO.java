package DAO;

public class EquipmentDAO {

    public  int e_id;
    public String e_name;
    public int e_model;
    public String e_type;
    public EquipmentDAO(int e_id,String e_name,int e_model,String e_type){
        this.e_id=e_id;
        this.e_name=e_name;
        this.e_model=e_model;
        this.e_type=e_type;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getE_id() {
        return e_id;
    }
    public void setE_model(int e_model) {
        this.e_model = e_model;
    }

    public int getE_model() {
        return e_model;
    }
    public void setE_type(String e_type) {
        this.e_type = e_type;
    }

    public String getE_type() {
        return e_type;
    }
    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_name() {
        return e_name;
    }
}
