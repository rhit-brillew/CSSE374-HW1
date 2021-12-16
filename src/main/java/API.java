import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class API {

    Scanner sc;
    ArrayList<String[]> array = new ArrayList<>();
    {
        try {
            sc = new Scanner(new File("DB.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc.useDelimiter(",");
        sc.nextLine();
        while (sc.hasNext()) {
            String val = sc.nextLine();
            array.add(val.split(","));
        }
    }

    public void sendViewRequest(int cartID) {
        Cart cart = createCart(cartID);
        cart.computeTotalCost();
    }

    public void sendAddItemRequest(int cartID, int itemID, double price) {
        Cart cart = createCart(cartID);
        cart.addItem(itemID, price);
        updateFile(cart);
    }

    public void sendApplyDiscountRequest(int cartID, String discountCode) {

    }

    public void sendModifyQuantityRequest(int cartID, int itemID, int newQuantity) {

    }

    private Cart createCart(int cartID) {
        Cart cart = new Cart(cartID);
        String[] cartData = null;
        String[] items, quantities, stock, prices, discounts, discountPercent, discountExpiration;
        for (int i = 0; i < array.size(); i++) {
            cartData = array.get(i);
            if (Integer.parseInt(cartData[0]) == cartID) {
                break;
            }
        }
        items = cartData[1].split(":");
        quantities = cartData[2].split(":");
        stock = cartData[3].split(":");
        prices = cartData[4].split(":");
        discounts = cartData[5].split(":");
        discountPercent = cartData[6].split(":");
        discountExpiration = cartData[7].split(":");

        if (!items[0].equals("")) {
            cart.itemList = createItems(items, stock, prices);
            for (int i = 0; i < items.length; i++) {
                cart.itemQuantityMap.put(Integer.parseInt(items[i]), Integer.parseInt(quantities[i]));
            }
        }
        if (!discounts[0].equals("")) {
            cart.discountList = createDiscount(discounts, discountPercent, discountExpiration);
        }
        cart.address = cartData[8];

        return cart;
    }

    private ArrayList<Item> createItems(String[] items, String[] stock, String[] prices) {
        ArrayList<Item> itemList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            Item item = new Item();
            item.itemID = Integer.parseInt(items[i]);
            item.price = Double.parseDouble(prices[i]);
            item.numberInStock = Integer.parseInt(stock[i]);
            itemList.add(item);
        }
        return itemList;
    }

    private ArrayList<Discount> createDiscount(String[] discounts, String[] discountPercent, String[] discountExpiration) {
        ArrayList<Discount> discountList = new ArrayList<>();
        for (int i = 0; i < discounts.length; i++) {
            Discount discount = new Discount();
            discount.discountCode = discounts[i];
            discount.percentage = Double.parseDouble(discountPercent[i]);
            discount.expirationDate = discountExpiration[i];
            discountList.add(discount);
        }
        return discountList;
    }

    public String convertToCSV(String[] data) {
        return String.join(",", data);
    }

    public void outputToCSV() throws IOException {
        File csvOutputFile = new File("DB.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            array.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }

    private void updateFile(Cart cart) {
        String cartID = String.valueOf(cart.cartID);
        String itemListAsString = "";
        String itemQuantityAsString = "";
        String itemStockAsString = "";
        String itemPricesAsString = "";
        String discountsAsString = "";
        String discountPercentageAsString = "";
        String discountExpirationAsString = "";
        String address = "";
        for (int i = 0; i < cart.itemList.size(); i++) {
            itemListAsString += cart.itemList.get(i).itemID + ":";
            itemQuantityAsString += cart.itemQuantityMap.get(cart.itemList.get(i).itemID) + ":";
            itemStockAsString += cart.itemList.get(i).numberInStock + ":";
            itemPricesAsString += cart.itemList.get(i).price + ":";
        }
        for (int i = 0; i < cart.discountList.size(); i++) {
            discountsAsString += cart.discountList.get(i).discountCode + ":";
            discountPercentageAsString += cart.discountList.get(i).percentage + ":";
            discountExpirationAsString += cart.discountList.get(i).expirationDate + ":";
        }
        address = cart.address;
        String[] newLine = {cartID, itemListAsString, itemQuantityAsString, itemStockAsString, itemPricesAsString, discountsAsString,
        discountPercentageAsString, discountExpirationAsString, address};
        array.add(cart.cartID - 1, newLine);
        try {
            outputToCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
