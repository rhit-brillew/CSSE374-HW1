import org.junit.Assert;
import org.junit.Test;

public class TestCart {

    Cart cart;
    public void setupCart() {
        cart = new Cart(1);
        cart.address = "Indiana";

        Item item = new Item();
        item.price = 2.99;
        item.itemID = 1;
        item.numberInStock = 10;

        Item item2 = new Item();
        item2.price = 1.99;
        item2.itemID = 2;
        item2.numberInStock = 10;

        Discount discount = new Discount();
        discount.discountCode = "CODE1";
        discount.expirationDate = "11/22";
        discount.percentage = .05;

        cart.itemList.add(item);
        cart.itemList.add(item2);
        cart.discountList.add(discount);
    }

    @Test
    public void testComputeTotalCost() {
        setupCart();
        cart.computeTotalCost();
        Assert.assertEquals(5.0796, cart.totalCost, .01);
    }

    @Test
    public void testComputeTotalItemCost() {
        setupCart();
        cart.computeTotalItemCost();
        Assert.assertEquals(4.98, cart.computeTotalItemCost(), .01);
    }

    @Test
    public void testComputeTotalDiscount() {
        setupCart();
        cart.computeTotalCost();
        cart.computeTotalDiscount();
        Assert.assertEquals(.249, cart.computeTotalDiscount(), .01);
    }

    @Test
    public void testAddItem() {
        setupCart();
        cart.addItem(3, 4.00);
        Assert.assertEquals(3, cart.itemList.get(2).itemID);
        Assert.assertEquals(3, cart.itemList.size());
        cart.computeTotalCost();
        Assert.assertEquals(8.98, cart.totalItemCost, .01);
    }

    @Test
    public void testApplyDiscount() {
        setupCart();
        cart.applyDiscount("CODE2", .05, "11/22");
        Assert.assertEquals(2, cart.discountList.size());
        Assert.assertEquals("CODE2", cart.discountList.get(1).discountCode);
    }
}
