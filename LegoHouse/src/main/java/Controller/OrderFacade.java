package Controller;

import Controller.Exceptions.OrderException;
import Controller.Exceptions.UserException;
import Model.Interfaces.IOrderFacade;
import Model.Mappers.OrderMapper;
import Model.Mappers.UserMapper;
import Model.Models.Order;
import Model.Models.User;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Martin Frederiksen
 */
public class OrderFacade implements IOrderFacade {

    OrderMapper om = new OrderMapper();

    @Override
    public void addOrder(Order order) throws OrderException, SQLException {
        om.addOrder(order);
    }

    @Override
    public Order getOrderById(int OrderId) throws OrderException, SQLException {
        return om.getOrderById(OrderId);
    }

    @Override
    public List<Order> getOrdersByUser(int userId) throws OrderException, SQLException {
        return om.getOrdersByUser(userId);
    }

    @Override
    public List<Order> getOrders() throws OrderException, SQLException {
        return om.getOrders();
    }

    @Override
    public void shipOrder(int orderId) throws OrderException, SQLException {
        om.shipOrder(orderId);
    }

    public static void main(String[] args) {
        try {
            OrderFacade of = new OrderFacade();
            UserFacade uf = new UserFacade();
            User user = uf.getUser("test");
            //of.addOrder(new Order(user.getId(), 13, 9, 5, Date.valueOf(LocalDate.MAX), false));
            //System.out.println(of.getOrderById(3).getUserId());
            /*for(Order o : of.getOrdersByUser(7)){
                System.out.println(o.getOrderId());
            }*/
            /*for (Order o : of.getOrders()) {
                System.out.println(o.getOrderId());
            }*/
            of.shipOrder(1);

        } catch (SQLException | OrderException | UserException ex) {
            System.out.println("Could not add order!");
            System.out.println(ex.getMessage());
        }

    }

}
