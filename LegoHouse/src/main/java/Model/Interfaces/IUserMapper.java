/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Controller.Exceptions.UserException;
import Model.Models.User;
import java.sql.SQLException;

/**
 *
 * @author Martin Frederiksen
 */
public interface IUserMapper {

    void addUser(User user) throws UserException, SQLException;

    User getUser(String email) throws UserException, SQLException;

    User validateUser(String email, String password) throws UserException, SQLException;
}
