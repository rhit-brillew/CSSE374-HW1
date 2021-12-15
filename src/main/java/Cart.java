import java.util.ArrayList;
import java.util.Map;

public class Cart {
    int cartID;
    double totalCost;
    double itemCost;
    String address;
    Map<Integer, Integer> itemQuantityMap;
    ArrayList<Item> itemList;
    ArrayList<Discount> discountList;


    public double computeTotalCost() {
        return 0.0;
    }

    public double computeTotalDiscount() {
        return 0.0;
    }

    public void computeTaxes(String address) {

    }

    public Item getItemByID(int ID) {
        return new Item();
    }

    public Discount getDiscountCode(String discountCode) {
        return new Discount();
    }
}
