package DAO;

public class UserDAO {
    private int u_id;
    private String u_name;
    private int age;
    private int height;
    private int weight;
    private int d_id;
    private String email;
    private String password;

    public UserDAO(int u_id,String u_name, int height, int weight,int d_id,int age,String email,String password) {
        this.u_id=u_id;
        this.u_name = u_name;
        this.height = height;
        this.weight = weight;
        this.d_id=d_id;
        this.age = age;
        this.email=email;
        this.password=password;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_name() {
        return u_name;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getD_id() {
        return d_id;
    }
}
