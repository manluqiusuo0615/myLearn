package learn.jdbc.mybatis.modal;

/**
 * @Description
 * @Author 肖长路
 * @Date 2017年12月04日 11:33
 */
public class Test {
    private String rybh;
    private String name;
    private String IDcard;
    private String address;
    private int qx;
    private String password;
    private String email;
    private int tel;

    public String getRybh() {
        return rybh;
    }

    public void setRybh(String rybh) {
        this.rybh = rybh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQx() {
        return qx;
    }

    public void setQx(int qx) {
        this.qx = qx;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Test{" +
                "rybh='" + rybh + '\'' +
                ", name='" + name + '\'' +
                ", IDcard='" + IDcard + '\'' +
                ", address='" + address + '\'' +
                ", qx=" + qx +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                '}';
    }
}
