package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {
    private AccountManager am;
    private Customer c;
    @BeforeEach public void init() {
        //Arrange
        am = new AccountManagerImpl();
        c = new Customer();
        c.setBalance(1000);
    }

    /// Tests
    /// Sufficient balance -> success (Done)
    /// Insufficient balance and credit not allowed -> insufficient account balance (Done)
    /// Insufficient balance and credit allowed and needed amount less than or equal credit limit -> success (Done)
    /// Insufficient balance and credit allowed and needed amount greater than credit and customer is vip -> success
    /// Insufficient balance and credit allowed and needed amount greater than credit and customer isn't vip -> maximum credit exceeded


    @Test
    void givenCustomerWithSufficientBalance_whenWithdraw_thenSucceed() {

        // Act
        String result = am.withdraw(c, 500);

        // Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(500, c.getBalance());
    }

    @Test void givenCustomerWithInsufficientBalanceAndCreditNotAllowed_whenWithdraw_thenInsufficientAccountBalance(){

        //Act
        String result = am.withdraw(c, 1500);

        //Assert
        Assertions.assertEquals("insufficient account balance", result);
        Assertions.assertEquals(1000, c.getBalance());
    }

    @Test void givenCustomerWithInsufficientBalanceAndCreditAllowedAndNeededAmountLessThanOrEqualCreditLimit_whenWithdraw_thenSuccess(){
        //Arrange
        c.setCreditAllowed(true);

        //Act
        String result = am.withdraw(c, 1500);

        //Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(-500, c.getBalance());
    }

    @Test void givenCustomerWithInsufficientBalanceAndCreditAllowedAndNeededAmountGreaterThanCreditLimitAndVip_whenWithdraw_thenSuccess(){
        //Arrange
        c.setCreditAllowed(true);
        c.setVip(true);

        //Act
        String result = am.withdraw(c, 3000);

        //Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(-2000, c.getBalance());
    }

    @Test void givenCustomerWithInsufficientBalanceAndCreditAllowedAndNeededAmountGreaterThanCreditLimitAndNotVip_whenWithdraw_thenSuccess(){
        //Arrange
        c.setCreditAllowed(true);

        //Act
        String result = am.withdraw(c, 3000);

        //Assert
        Assertions.assertEquals("maximum credit exceeded", result);
        Assertions.assertEquals(1000, c.getBalance());
    }

    @Test void testDeposit1(){
        am.deposit(c, 1000);
        Assertions.assertEquals(2000, c.getBalance());
    }
    @Test void testDeposit2(){
        am.deposit(c, -1000);
        Assertions.assertEquals(1000, c.getBalance());
    }

}
