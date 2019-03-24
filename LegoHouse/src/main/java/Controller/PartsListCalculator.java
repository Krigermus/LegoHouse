package Controller;
import Model.Models.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Martin Frederiksen
 */
public class PartsListCalculator {
    private HashMap<String, Integer> bricks;

    public PartsListCalculator(Order order) {
       bricks = new HashMap<>();
       int fourA = order.getLength() / 4;
       int remainderA = order.getLength() % 4;
       int twoA = remainderA / 2;
       remainderA %= 2;
       
       int fourB = (order.getWidth()-4)/ 4;
       int remainderB = (order.getWidth()-4)% 4;
       int twoB = remainderB / 2;
       remainderB %= 2;
       
       int fourTotal = fourA*2 + fourB*2;
       int twoTotal = twoA*2 + twoB*2;
       int remainderTotal = remainderA*2 + remainderB*2;
       
       int fourHeight = fourTotal * order.getHeight();
       int twoHeight = twoTotal * order.getHeight();
       int remainderHeight = remainderTotal * order.getHeight();
       
       bricks.put("4x2A", fourA);
       bricks.put("2x2A", twoA);
       bricks.put("1x2A", remainderA);
       bricks.put("4x2B", fourB);
       bricks.put("2x2B", twoB);
       bricks.put("1x2B", remainderB);
       bricks.put("4x2Total", fourTotal);
       bricks.put("2x2Total", twoTotal);
       bricks.put("1x2Total", remainderTotal);
       bricks.put("4x2Height", fourHeight);
       bricks.put("2x2Height", twoHeight);
       bricks.put("1x2Height", remainderHeight); 
    }
    public HashMap<String, Integer> getBricks(){
        return bricks;
    }
}
