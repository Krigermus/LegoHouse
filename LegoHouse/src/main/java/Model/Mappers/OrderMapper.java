package Model.Mappers;

import Controller.Exceptions.OrderException;
import Model.DBConnector;
import Model.Interfaces.IOrderMapper;
import Model.Models.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Frederiksen
 */
public class OrderMapper implements IOrderMapper {

    private Connection connection = null;

    @Override
    public void addOrder(Order order) throws OrderException, SQLException {
        try {
            connection = DBConnector.getInstance().getConnection();

            String quary = "INSERT INTO orders(userId, width, length, height, connectedPattern, withDoor, withWindow) VALUES(?,?,?,?,?,?,?);";
            PreparedStatement ps = connection.prepareStatement(quary, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getHeight());
            ps.setBoolean(5, order.isConnected());
            ps.setBoolean(6, order.isDoor());
            ps.setBoolean(7, order.isWindow());
            
            connection.setAutoCommit(false);
            ps.executeUpdate();
            ResultSet orderId = ps.getGeneratedKeys();
            orderId.next();
            int id = orderId.getInt(1);

            if (id > 0) {
                connection.commit();
            }
        } catch (ClassNotFoundException ex) {
            if (connection != null) {
                connection.rollback();
            }
            throw new OrderException(ex.getMessage());
        } finally {
            connection.close();
        }
    }

    @Override
    public Order getOrderById(int OrderId) throws OrderException, SQLException {
        try {
            connection = DBConnector.getInstance().getConnection();
            String quary = "SELECT * FROM orders WHERE id =?;";
            PreparedStatement ps = connection.prepareStatement(quary);

            ps.setInt(1, OrderId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Order order = new Order(rs.getInt("userId"), rs.getInt("length"), rs.getInt("width"), rs.getInt("height"), rs.getDate("shippingDate"), rs.getBoolean("shipped"), rs.getBoolean("connectedPattern"), rs.getBoolean("withDoor"), rs.getBoolean("withWindow"));
                order.setOrderId(rs.getInt("id"));
                return order;
            }

        } catch (ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByUser(int userId) throws OrderException, SQLException {
        try {
            List<Order> orders = new ArrayList<>();
            connection = DBConnector.getInstance().getConnection();
            String quary = "SELECT * FROM orders WHERE userId =?;";
            PreparedStatement ps = connection.prepareStatement(quary);

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt("userId"), rs.getInt("length"), rs.getInt("width"), rs.getInt("height"), rs.getDate("shippingDate"), rs.getBoolean("shipped"), rs.getBoolean("connectedPattern"), rs.getBoolean("withDoor"), rs.getBoolean("withWindow"));
                o.setOrderId(rs.getInt("id"));
                orders.add(o);
            }
            return orders;
        } catch (ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        } finally {
            connection.close();
        }
    }

    @Override
    public List<Order> getOrders() throws OrderException, SQLException {
        try {
            List<Order> orders = new ArrayList<>();
            connection = DBConnector.getInstance().getConnection();
            String quary = "SELECT * FROM orders;";
            PreparedStatement ps = connection.prepareStatement(quary);
            ResultSet rs = ps.executeQuery(quary);
            while (rs.next()) {
                Order o = new Order(rs.getInt("userId"), rs.getInt("length"), rs.getInt("width"), rs.getInt("height"), rs.getDate("shippingDate"), rs.getBoolean("shipped"), rs.getBoolean("connectedPattern"), rs.getBoolean("withDoor"), rs.getBoolean("withWindow"));
                o.setOrderId(rs.getInt("id"));
                orders.add(o);
            }
            return orders;
        } catch (ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        } finally {
            connection.close();
        }
    }

    @Override
    public void shipOrder(int orderId) throws OrderException, SQLException {
        try {
            connection = DBConnector.getInstance().getConnection();
            String quary = "UPDATE orders SET shippingDate = curdate(), shipped = true WHERE id = ?;";
            PreparedStatement ps = connection.prepareStatement(quary);
            
            ps.setInt(1, orderId);
            ps.executeUpdate();
  
        } catch (ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        } finally {
            connection.close();
        }
    }

    /*
    public static void main(String[] args) {
        try {
            OrderMapper om = new OrderMapper();
            UserMapper um = new UserMapper();
            User user = um.getUser("test");
            om.addOrder(new Order(user.getId(), 13, 9, 5, null, false, true, false ,false));
            //System.out.println(om.getOrderById(3).getUserId());
            /*for(Order o : om.getOrdersByUser(7)){
                System.out.println(o.getOrderId());
            }*/
            /*for (Order o : om.getOrders()) {
                System.out.println(o.getOrderId());
            }
            //om.shipOrder(3);
            System.out.println(om.getOrderById(3).getShippingDate());

        } catch (SQLException | OrderException | UserException ex) {
            System.out.println("Could not add order!");
            System.out.println(ex.getMessage());
        }

    }*/

}
