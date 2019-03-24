package View.Commands;

import Controller.Exceptions.CommandException;
import Controller.Exceptions.OrderException;
import Controller.OrderFacade;
import Controller.UserFacade;
import Model.Models.Order;
import Model.Models.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin Frederiksen
 */
public class ShowOrders implements Command{
    private String target;

    public ShowOrders(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) throws CommandException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> orders = new ArrayList<>();
        
        try {
            orders = (user.getRole().toString().equals("CUSTOMER")) ? of.getOrdersByUser(user.getId()) : of.getOrders();
            session.setAttribute("orders", orders);
        } catch (SQLException | OrderException ex) {
            request.setAttribute("message", ex.getMessage());
        }
        
        return target;
    }

}
