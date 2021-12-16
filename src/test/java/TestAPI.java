import org.junit.Test;

public class TestAPI {

    @Test
    public void testAPISetup() {
        API api = new API();

        api.sendViewRequest(1);

        api.sendAddItemRequest(4, 1, 3.99);

        api.sendApplyDiscountRequest(4, "CODE1", .05);

        api.sendModifyQuantityRequest(4, 1, 3);
        api.sendModifyQuantityRequest(4, 1, 1);
    }

}
