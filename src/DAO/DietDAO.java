package DAO;

public class DietDAO {
    private int d_id;
    private String d_name;
    private String d_desc;
    public DietDAO(int d_id,String d_name,String d_desc){
        this.d_id=d_id;
        this.d_name=d_name;
        this.d_desc=d_desc;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_desc(String d_desc) {
        this.d_desc = d_desc;
    }

    public String getD_desc() {
        return d_desc;
    }
    public void setD_name(String d_name){
        this.d_name=d_name;
    }

    public String getD_name() {
        return d_name;
    }
}
