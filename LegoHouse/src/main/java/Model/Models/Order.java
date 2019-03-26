package Model.Models;

import java.sql.Date;

/**
 *
 * @author Martin Frederiksen
 */
public class Order {
    private int orderId;
    private int userId;
    private int length;
    private int width;
    private int height;
    private Date shippingDate;
    private boolean shipped;
    private boolean connectedPattern;
    private boolean door;
    private boolean window;

    public Order(int userId, int length, int width, int height, Date shippingDate, boolean shipped, boolean connectedPattern, boolean door, boolean window) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.shippingDate = shippingDate;
        this.shipped = shipped;
        this.connectedPattern = connectedPattern;
        this.door = door;
        this.window = window;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public boolean isShipped() {
        return shipped;
    }
    public boolean isConnected() {
        return connectedPattern;
    }
    public boolean isDoor() {
        return door;
    }
    public boolean isWindow() {
        return window;
    }
}
