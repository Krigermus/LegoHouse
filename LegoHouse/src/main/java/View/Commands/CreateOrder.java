package View.Commands;

import View.Exceptions.CommandException;
import Controller.Exceptions.OrderException;
import Controller.OrderFacade;
import Controller.UserFacade;
import Model.Models.Order;
import Model.Models.User;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin Frederiksen
 */
public class CreateOrder implements Command {

    private String target;

    public CreateOrder(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) throws CommandException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        if (request.getParameter("length") != null && u != null) {
            int length = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int height = Integer.parseInt(request.getParameter("height"));
            boolean connectedPattern = Boolean.parseBoolean(request.getParameter("connected"));
            boolean door = Boolean.parseBoolean(request.getParameter("door"));
            boolean window = Boolean.parseBoolean(request.getParameter("window"));
            try {
                of.addOrder(new Order(u.getId(), length, width, height, null, false, connectedPattern, door, window));
            } catch (SQLException | OrderException ex) {
                String order = "Something went wrong. Use only integers as input!";
                request.setAttribute("message", order);
            }
        }
        return target;
    }

}
