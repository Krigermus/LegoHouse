package Controller;

import Controller.Exceptions.UserException;
import Controller.Interfaces.IUserFacade;
import Model.Mappers.UserMapper;
import Model.Models.RoleEnum;
import Model.Models.User;
import java.sql.SQLException;

/**
 *
 * @author Martin Frederiksen
 */
public class UserFacade implements IUserFacade{
    private UserMapper um = new UserMapper();
    
    
    @Override
    public void addUser(User user) throws UserException, SQLException {
        um.addUser(user);
    }

    @Override
    public User getUser(String email) throws UserException, SQLException {
        return um.getUser(email);
    }

    @Override
    public User validateUser(String email, String password) throws UserException, SQLException {
        return um.validateUser(email, password);
    }
    
    public static void main(String[] args) {
        UserFacade uf = new UserFacade();
        try {
            //uf.addUser(new User("test3", "12", RoleEnum.CUSTOMER));
            //uf.addUser(new User("test4", "12", RoleEnum.EMPLOYEE));    
            //System.out.println(uf.getUser("test").getId());
            User user = uf.validateUser("test", "12");
            System.out.println(user.getId());
        } catch (Exception ex) {
            System.out.println("Could not add or validate user!");
        }
    }
}
