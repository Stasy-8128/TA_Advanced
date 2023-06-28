import com.epam.tamentoring.bo.DiscountUtility;
import com.epam.tamentoring.bo.OrderService;
import com.epam.tamentoring.bo.Product;
import com.epam.tamentoring.bo.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TestClass {
    @InjectMocks
    OrderService orderService;
    @Mock
    DiscountUtility discountUtility;


    //User can add products to the shopping cart
    @Test
    public void addToCartTest() {
        List<Product> products = new ArrayList<>();
        ShoppingCart shoppingCart = new ShoppingCart(products);
        shoppingCart.addProductToCart(new Product(111,"Test Product",10.5,1));
        shoppingCart.addProductToCart(new Product(222,"Test Product 2",10.5,1));
        assertThat(products.size()).isEqualTo(2);
    }

    //User can remove products from the shopping cart
    @Test
    public void removeFromCartTest() {
        List<Product> products = new ArrayList<>();
        Product testProduct = new Product(111, "Test Product", 10.5, 1);
        products.add(testProduct);
        ShoppingCart shoppingCart = new ShoppingCart(products);
        shoppingCart.removeProductFromCart(testProduct);
        assertThat(products.size()).isZero();
    }

    //User can get the total price of the shopping cart
    @Test
    public void getTotalPriceTest() {
        List<Product> products = new ArrayList<>();
        ShoppingCart shoppingCart = new ShoppingCart(products);
        Product testProduct1 = new Product(111, "Test Product 1", 10.5, 1);
        Product testProduct2 = new Product(112, "Test Product 2", 20.5, 1);
        shoppingCart.addProductToCart(testProduct1);
        shoppingCart.addProductToCart(testProduct2);
        assertThat(shoppingCart.getCartTotalPrice()).isEqualTo(31);
    }

    //TestMockito
    @Test
    public void mockitoTest() {

    }
}
