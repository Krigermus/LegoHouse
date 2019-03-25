package View.Commands;

import View.Exceptions.CommandException;
import Controller.OrderFacade;
import Controller.UserFacade;
import javax.servlet.http.HttpServletRequest;

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
