package Model.Mappers;

import Controller.Exceptions.UserException;
import Model.DBConnector;
import Model.Interfaces.IUserMapper;
import Model.Models.RoleEnum;
import Model.Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Martin Frederiksen
 */
public class UserMapper implements IUserMapper {

    private Connection connection;

    @Override
    public void addUser(User user) throws UserException, SQLException {
        try {
            connection = DBConnector.getInstance().getConnection();
            String quary = "INSERT INTO users (email, password, role) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(quary, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole().toString());

            connection.setAutoCommit(false);
            ps.executeUpdate();
            ResultSet userId = ps.getGeneratedKeys();
            userId.next();
            int id = userId.getInt(1);

            if (id > 0) {
                connection.commit();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            if (connection != null) {
                connection.rollback();
            }
            throw new UserException(ex.getMessage());
        } finally {
            connection.close();
        }
    }
    
    @Override
    public User getUser(String email) throws UserException, SQLException {
        try {
            connection = DBConnector.getInstance().getConnection();
            String quary = "SELECT id, email, role FROM users WHERE email = ?";
            PreparedStatement ps = connection.prepareStatement(quary);
            
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                User u = new User(rs.getString("email"), rs.getString("email"), RoleEnum.valueOf(rs.getString("role")));
                u.setId(rs.getInt("id"));
                return u;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException(ex.getMessage());
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public User validateUser(String email, String password) throws UserException, SQLException {
        try {
            connection = DBConnector.getInstance().getConnection();
            String quary = "SELECT id, role FROM users WHERE email=? AND password=?;";
            PreparedStatement ps = connection.prepareStatement(quary);
            
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                User user = new User(email, password, RoleEnum.valueOf(rs.getString("role")));
                user.setId(rs.getInt("id"));
                return user;
            } else {
                throw new UserException("Could not validate user!");
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException(ex.getMessage());
        } finally {
            connection.close();
        }
    }

    
    /*
    public static void main(String[] args) {
        UserMapper um = new UserMapper();
        try {
            //um.addUser(new User("test2", "12", RoleEnum.CUSTOMER));
            //um.addUser(new User("test1", "12", RoleEnum.EMPLOYEE));    
            //System.out.println(um.getUser("test").getId());
            //User user = um.validateUser("test", "12");
            //System.out.println(user.getId());
        } catch (Exception ex) {
            System.out.println("Could not add or validate user!");
        }
    }*/

}
