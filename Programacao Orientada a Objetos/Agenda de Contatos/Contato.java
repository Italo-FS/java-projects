public class Contato {
    int id;
    String name;
    String phone;
    String birthday;

    public Contato(int id, String name, String phone, String birthday) {
        setId(id);
        setName(name);
        setPhone (phone);
        setBirthday(birthday);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    
}
