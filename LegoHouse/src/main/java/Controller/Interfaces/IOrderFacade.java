package Controller.Interfaces;

import Controller.Exceptions.OrderException;
import Model.Models.Order;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Martin Frederiksen
 */
public interface IOrderFacade {

    void addOrder(Order order) throws OrderException, SQLException;

    Order getOrderById(int OrderId) throws OrderException, SQLException;

    List<Order> getOrdersByUser(int userId) throws OrderException, SQLException;

    List<Order> getOrders() throws OrderException, SQLException;
    
    void shipOrder(int orderId) throws OrderException, SQLException;
}
