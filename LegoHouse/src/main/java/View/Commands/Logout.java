package View.Commands;

import View.Exceptions.CommandException;
import Controller.OrderFacade;
import Controller.UserFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin Frederiksen
 */
public class Logout implements Command{
    private String target;

    public Logout(String target) {
        this.target = target;
    }
    
    
    @Override
    public String execute(HttpServletRequest request, UserFacade uf, OrderFacade of) throws CommandException {
        HttpSession session = request.getSession();
        session.invalidate();
        return target;
    }

}
