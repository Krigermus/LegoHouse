package View.Commands;

import View.Exceptions.CommandException;
import Controller.OrderFacade;
import Controller.UserFacade;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Martin Frederiksen
 */
public interface Command {

    String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) throws CommandException;
}
