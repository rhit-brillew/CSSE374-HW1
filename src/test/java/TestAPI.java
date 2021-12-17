import org.junit.Assert;
import org.junit.Test;

public class TestAPI {

    @Test
    public void testAPISendViewRequest() {
        API api = new API();
        Cart cart = api.sendViewRequest(1);
        Assert.assertEquals(1, cart.cartID);
        Assert.assertEquals(3, cart.itemList.size());
        Assert.assertEquals(3, cart.discountList.size());
    }

    @Test
    public void testAPISendAddItemRequest() {
        API api = new API();
        Cart cart = api.sendAddItemRequest(4, 1, 2.99);
        Assert.assertEquals(1, cart.itemList.size());
        Assert.assertEquals(2.99, cart.itemList.get(0).price, .01);
    }

    @Test
    public void testAPISendApplyDiscountRequest() {
        API api = new API();
        Cart cart = api.sendApplyDiscountRequest(4, "CODE1", .05, "11/22");
        Assert.assertEquals(1, cart.discountList.size());
        Assert.assertEquals("CODE1", cart.discountList.get(0).discountCode);
    }

    @Test
    public void testAPISendModifyQuantityRequest() {
        API api = new API();
        Cart cart = api.sendModifyQuantityRequest(2, 14, 5);
        Assert.assertEquals(3, cart.itemList.size());
        int quantity = cart.itemQuantityMap.get(14);
        Assert.assertEquals(5, quantity);
    }

    @Test
    public void testExpiredDiscount() {
        API api = new API();
        Cart cart = api.sendApplyDiscountRequest(5, "CODE2", .05, "10/21");
        Assert.assertEquals(1, cart.invalidCodes);
        Assert.assertEquals(0, cart.discountList.size());
    }

    @Test
    public void testAddNegativeQuantity() {
        API api = new API();
        Cart cart = api.sendModifyQuantityRequest(3, 88, -10);
        Assert.assertEquals(3, cart.itemList.size());
    }

    @Test
    public void testAddQuantityAboveStock() {
        API api = new API();
        Cart cart = api.sendModifyQuantityRequest(1, 39, 200);
        Assert.assertEquals(3, cart.itemList.size());
    }

}
