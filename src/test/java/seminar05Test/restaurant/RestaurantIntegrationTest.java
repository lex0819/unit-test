package seminar05Test.restaurant;

import org.junit.jupiter.api.Test;
import seminar05.restaurant.MenuItem;
import seminar05.restaurant.Order;
import seminar05.restaurant.kitchen;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantIntegrationTest {
    @Test
    public void testRestaurantIntegration(){
        MenuItem burger = new MenuItem("burger", 5.90);
        MenuItem pizza = new MenuItem("pizza", 7.99);

        Order order = new Order();
        order.addItem(burger);
        order.addItem(pizza);

        kitchen kitchen = new kitchen();

        kitchen.prepareOrder(order);

        List<MenuItem> preparedItems = order.getItems();

        assertEquals(2, preparedItems.size());
        assertEquals("burger", preparedItems.get(0).getName());
        assertEquals(5.90, preparedItems.get(0).getPrice(), 0.001);
        assertEquals("pizza", preparedItems.get(1).getName());
        assertEquals(7.99, preparedItems.get(1).getPrice(), 0.001);
    }
}
