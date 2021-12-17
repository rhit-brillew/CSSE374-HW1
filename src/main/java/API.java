import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class API {
    FileIOHandler fileIOHandler = new FileIOHandler();

    public Cart sendViewRequest(int cartID) {
        Cart cart = fileIOHandler.createCart(cartID);
        cart.computeTotalCost();
        return cart;
    }

    public Cart sendAddItemRequest(int cartID, int itemID, double price) {
        Cart cart = fileIOHandler.createCart(cartID);
        cart.addItem(itemID, price);
        fileIOHandler.updateFile(cart);
        return cart;
    }

    public Cart sendApplyDiscountRequest(int cartID, String discountCode, double percentage, String expirationDate) {
        Cart cart = fileIOHandler.createCart(cartID);
        String dateString = new SimpleDateFormat("MM/yy").format(new Date());
        String[] dateStringAsArray = dateString.split("/");
        String[] expirationAsArray = expirationDate.split("/");
        if (Integer.parseInt(dateStringAsArray[1]) >= Integer.parseInt(expirationAsArray[1])) {
            if (Integer.parseInt(dateStringAsArray[0]) >= Integer.parseInt(expirationAsArray[0])) {
                cart.invalidCodes++;
                return cart;
            }
        }
        if (cart.invalidCodes >= 5) {
            return cart;
        }
        cart.applyDiscount(discountCode, percentage, expirationDate);
        fileIOHandler.updateFile(cart);
        return cart;
    }

    public Cart sendModifyQuantityRequest(int cartID, int itemID, int newQuantity) {
        Cart cart = fileIOHandler.createCart(cartID);
        if (newQuantity <= 0) {
            return cart;
        } else if (newQuantity > cart.getItemByID(itemID).numberInStock) {
            return cart;
        }
        cart.itemQuantityMap.put(itemID, newQuantity);
        fileIOHandler.updateFile(cart);
        return cart;
    }
}
