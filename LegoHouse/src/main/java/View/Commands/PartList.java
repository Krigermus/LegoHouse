package View.Commands;

import View.Exceptions.CommandException;
import Controller.Exceptions.OrderException;
import Controller.OrderFacade;
import Controller.PartsListCalculator;
import Controller.UserFacade;
import Model.Models.Order;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin Frederiksen
 */
public class PartList implements Command {

    private String target;

    public PartList(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) throws CommandException {
        HttpSession session = request.getSession();
        try {
            Order o = of.getOrderById(Integer.parseInt(request.getParameter("orderId")));
            Map<String, Integer> bricks = new PartsListCalculator(o, o.isConnected(), o.isDoor(), o.isWindow()).getBricks();
            session.setAttribute("order", o);
            session.setAttribute("bricks", bricks);
        } catch (SQLException | OrderException ex) {
            request.setAttribute("message", ex.getMessage());
        }
        return target;
    }

}
