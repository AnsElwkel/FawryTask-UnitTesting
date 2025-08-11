package example.store;

import example.account.AccountManager;
import example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class StoreV2Test {

    @Test
    void test1() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(3, product.getQuantity());
    }

    @Test
    void test2() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("failed");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();

        // Assert
        Assertions.assertThrows(RuntimeException.class , () -> store.buy(product, customer));
    }

    @Test
    void test3() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(0);
        Customer customer = new Customer();


        //Act & Assert
        Assertions.assertThrows(RuntimeException.class , () -> store.buy(product, customer));
    }

}
