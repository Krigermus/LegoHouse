package View.Commands;

import Controller.Exceptions.CommandException;
import Controller.OrderFacade;
import Controller.UserFacade;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin Frederiksen
 */
public class Unknown implements Command {

    @Override
    public String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) throws CommandException {
        String msg = "Unknown command. Contact IT";
        throw new CommandException(msg);
    }

}
