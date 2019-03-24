package Model.Interfaces;

import Controller.Exceptions.UserException;
import Model.Models.User;
import java.sql.SQLException;

/**
 *
 * @author Martin Frederiksen
 */
public interface IUserFacade {

    void addUser(User user) throws UserException, SQLException;

    User getUser(String email) throws UserException, SQLException;

    User validateUser(String email, String password) throws UserException, SQLException;
}
