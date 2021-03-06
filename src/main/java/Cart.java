import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    int cartID;
    double totalCost;
    double totalItemCost;
    double discount;
    int invalidCodes;
    String address;
    Map<Integer, Integer> itemQuantityMap; //mapping item ID to amount in cart
    ArrayList<Item> itemList;
    ArrayList<Discount> discountList;

    public Cart(int ID) {
        this.cartID = ID;
        totalCost = 0;
        totalItemCost = 0;
        discount = 0;
        invalidCodes = 0;
        itemQuantityMap = new HashMap<>();
        itemList = new ArrayList<>();
        discountList = new ArrayList<>();
    }


    public double computeTotalCost() {
        totalItemCost = computeTotalItemCost();
        discount = computeTotalDiscount();
        totalCost = totalItemCost - discount + computeTaxes();
        return totalCost;
    }

    double computeTotalItemCost() {
        double itemCost = 0;
        for (int i = 0; i < itemList.size(); i++) {
            itemCost += itemList.get(i).price;
        }
        return itemCost;
    }

    double computeTotalDiscount() {
        double discountTotal = 0;
        for (int i = 0; i < discountList.size(); i++) {
            discountTotal += discountList.get(i).percentage * totalItemCost;
        }
        return discountTotal;
    }

    private double computeTaxes() {
        return TaxCalculator.calculateBasedOnLocation(address, totalItemCost);
    }

    public void addItem(int itemID, double price) {
        Item item = new Item();
        item.itemID = itemID;
        item.price = price;
        itemQuantityMap.put(itemID, 1);
        item.numberInStock = 100;
        itemList.add(item);
    }

    public void applyDiscount(String discountCode, double percentage, String expirationDate) {
        Discount discount = new Discount();
        discount.discountCode = discountCode;
        discount.percentage = percentage;
        discount.expirationDate = expirationDate;
        discountList.add(discount);
    }

    public Item getItemByID(int ID)  {
        for (Item item : itemList) {
            if (item.itemID == ID) {
                return item;
            }
        }
        return null;
    }
}
