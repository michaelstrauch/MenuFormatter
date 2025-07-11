import com.restaurant.Models.MenuModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MenuModelTest {

    @Test
    void testSetPrice () {
        MenuModel testMenu = new MenuModel("fakesoup","fakedish","fakedesc","3.");
        String testPrice = testMenu.setPrice();
        assertEquals("195,-", testPrice);
    }
}
