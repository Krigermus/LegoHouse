package Controller;

import Model.Models.Order;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Martin Frederiksen
 */
public class PartsListCalculator {

    private HashMap<String, Integer> bricks;
    private boolean doorCheck;
    private boolean windowCheck;
    private boolean connected;

    public PartsListCalculator(Order order, boolean connectedPattern, boolean door, boolean window) {
        bricks = new HashMap<>();
        doorCheck = door;
        windowCheck = window;
        connected = connectedPattern;

        for (int i = 1; i <= order.getHeight(); i++) {
            calcLayer(order.getLength(), order.getWidth(), i);
        }
        calcTotalAndHeight(order.getHeight());
    }
    
    private void calcLayer(int length, int width, int layer){
        boolean doorLayer, windowLayer;
        
        // if layer is 1, 2 or 3 add door
        if(layer == 1 || layer == 2 || layer == 3)
            doorLayer = true;
        else
            doorLayer = false;
        
        // if Layer is 2 or 3 add window
        if(layer == 2 || layer == 3)
            windowLayer = true;
        else
            windowLayer = false;
        
        // Create 4 sides, 2 length and 2 width
        calcBricks(length, "A", layer, doorLayer, windowLayer, 1);
        calcBricks(length, "B", layer, doorLayer, windowLayer, 2);
        calcBricks(width, "C", layer, doorLayer, windowLayer, 0);
        calcBricks(width, "D", layer, doorLayer, windowLayer, 0);
    }
    

    private void calcBricks(int value, String side, int layer, boolean doorLayer, boolean windowLayer, int type) {
        if (layer % 2 > 0 && type != 0 && connected)
            value -= 4;
        else if (layer % 2 == 0 && type == 0 && connected)
            value -= 4;
        else if(!connected && type == 0)
            value -= 4;
         
        // Removes dots for door if door is checked
        if(doorLayer && doorCheck && type == 1)
            value -= 2;
        
        // Removes dots for window if door is checked
        if(windowLayer && windowCheck && type == 2)
            value -= 2;
        
        // Calculate brick amount
        int calc4x2 = value / 4;
        int calc2x2 = (value % 4) / 2;
        int calc1x2 = (value % 4) % 2;

        bricks.put("4x2"+side, calc4x2);
        bricks.put("2x2"+side, calc2x2);
        bricks.put("1x2"+side, calc1x2);
    }
    
    private void calcTotalAndHeight(int height){
        int total4x2 = bricks.get("4x2A") + bricks.get("4x2B") + bricks.get("4x2C") + bricks.get("4x2D");
        int total2x2 = bricks.get("2x2A") + bricks.get("2x2B") + bricks.get("2x2C") + bricks.get("2x2D");
        int total1x2 = bricks.get("1x2A") + bricks.get("1x2B") + bricks.get("1x2C") + bricks.get("1x2D");
        
        bricks.put("4x2Total", total4x2);
        bricks.put("2x2Total", total2x2);
        bricks.put("1x2Total", total1x2);
        
        bricks.put("4x2Height", total4x2*height);
        bricks.put("2x2Height", total2x2*height);
        bricks.put("1x2Height", total1x2*height);
        
    }
    
    public HashMap<String, Integer> getBricks(){
        return bricks;
    }
    
    public static void main(String[] args) {
        Order order = new Order(5, 13, 9, 4, null, false, false, true, false);
        PartsListCalculator plc = new PartsListCalculator(order, order.isConnected(), order.isDoor(), order.isWindow());
        System.out.println(order.isConnected());
        System.out.println(order.isDoor());
        System.out.println(order.isWindow());
        Map<String, Integer> bricks = plc.getBricks();
        
        System.out.println(bricks.get("4x2A") + " " + bricks.get("4x2B") + " " + bricks.get("4x2C") + " " + bricks.get("4x2D"));
        System.out.println(bricks.get("2x2A") + " " + bricks.get("2x2B") + " " + bricks.get("2x2C") + " " + bricks.get("2x2D"));
        System.out.println(bricks.get("1x2A") + " " + bricks.get("1x2B") + " " + bricks.get("1x2C") + " " + bricks.get("1x2D"));

    }
}
