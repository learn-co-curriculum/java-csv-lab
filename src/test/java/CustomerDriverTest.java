import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDriverTest {

    FavoriteCustomer ron;
    FavoriteCustomer leslie;
    FavoriteCustomer ben;
    List<FavoriteCustomer> customers;

    @BeforeEach
    void setUp() {
        ron = new FavoriteCustomer(
                "Ron",
                "Swanson",
                "four-horse meals of the egg-pork-alypse"
        );
        leslie = new FavoriteCustomer(
                "Leslie",
                "Knope",
                "waffles with whipped cream"
        );
        ben = new FavoriteCustomer(
                "Ben",
                "Wyatt",
                "calzone"
        );

        customers = new ArrayList<FavoriteCustomer>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testOneCustomer() {
        String filename = "test-customer1.csv";
        customers.add(ron);
        CustomerDriver.writeFile(filename, customers);
        assertEquals(ron.toString(), CustomerDriver.readFile(filename));
    }

    @Test
    void testMultipleCustomers() {
        String filename = "test-customer2.csv";
        customers.add(ron);
        customers.add(leslie);
        customers.add(ben);
        CustomerDriver.writeFile(filename, customers);
        String expectedOutput = String.format("%s%n%s%n%s", ron.toString(), leslie.toString(), ben.toString());
        assertEquals(expectedOutput, CustomerDriver.readFile(filename));
    }

    @Test
    void testNoCustomers() {
        String filename = "test-customer3.csv";
        CustomerDriver.writeFile(filename, customers);
        assertEquals("", CustomerDriver.readFile(filename));
    }
}