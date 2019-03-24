package View.Commands;

import Controller.Exceptions.UserException;
import Controller.OrderFacade;
import Controller.UserFacade;
import Model.Models.User;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin Frederiksen
 */
public class Login implements Command {

    private String target;

    public Login(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            User u = uf.validateUser(email, password);
            if (u != null) {
                session.setAttribute("user", u);
                return target;
            }
        } catch (SQLException | UserException ex) {
            request.setAttribute("message", ex.getMessage());
        }
        return "index.jsp";
    }
}
