package View.Commands;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Martin Frederiksen
 */
public class CommandList {
    private static CommandList instance = null;
    private final Map<String, Command> commands = new HashMap();
    
    private CommandList() {
        commands.put("login", new Login("FrontController?command=showOrders"));
        commands.put("register", new Register("register.jsp"));
        commands.put("showOrders", new ShowOrders("/WEB-INF/showOrders.jsp"));
        commands.put("createOrder", new CreateOrder("/WEB-INF/createOrder.jsp"));
        commands.put("shipOrder", new ShipOrder("/WEB-INF/showOrders.jsp"));
        commands.put("partList", new PartList("/WEB-INF/partList.jsp"));
        commands.put("logout", new Logout("index.jsp"));
    }
    
    public static synchronized Command commandForm(String key){
        if(key == null) key = "back";
        if(instance == null) instance = new CommandList();
        return instance.commands.get(key);
    }
    
}
