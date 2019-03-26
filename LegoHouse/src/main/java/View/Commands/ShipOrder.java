package View.Commands;

import View.Exceptions.CommandException;
import Controller.Exceptions.OrderException;
import Controller.OrderFacade;
import Controller.UserFacade;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin Frederiksen
 */
public class ShipOrder implements Command {

    private String target;

    public ShipOrder(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) throws CommandException {
        HttpSession session = request.getSession();
        try {
            of.shipOrder(Integer.parseInt(request.getParameter("orderId")));
            session.setAttribute("orders", of.getOrders());
        } catch (SQLException | OrderException ex) {
            request.setAttribute("message", ex.getMessage());
        } 
        return target;
    }

}
