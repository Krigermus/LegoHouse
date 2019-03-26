package Model.Models;

/**
 *
 * @author Martin Frederiksen
 */
public class User {

    private int id;
    private String email;
    private String password;
    private RoleEnum role;

    public User(String email, String password, RoleEnum role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public RoleEnum getRole() {
        return role;
    }

}
