package View.Commands;

import Controller.Exceptions.UserException;
import Controller.OrderFacade;
import Controller.UserFacade;
import Model.Models.RoleEnum;
import Model.Models.User;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Martin Frederiksen
 */
public class Register implements Command {
    private String target;

    public Register(String target) {
        this.target = target;
    }


    @Override
    public String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) {
        String email = request.getParameter("email");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");

        if (pass1.equals(pass2)) {
            try {
                uf.addUser(new User(email, pass1, RoleEnum.CUSTOMER));

                return "index.jsp";
            } catch (SQLException | UserException ex) {
                request.setAttribute("message", ex.getMessage());

            }
        } else {
            String noMatch = "password did not match";
            request.setAttribute("message", noMatch);
        }
        return target;
    }
}
