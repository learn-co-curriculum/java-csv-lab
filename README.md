# CSV Lab

## Learning Goals

- Work with CSV files in Java.

## Introduction

JJ Lipscomb owns a diner, JJ's Diner, and is trying to keep track of his
favorite customers and their meal choices. Consider the`FavoriteCustomer` class:

```java
public class FavoriteCustomer {
    private String firstName;
    private String lastName;
    private String mealChoice;

    public FavoriteCustomer(String firstName, String lastName, String mealChoice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mealChoice = mealChoice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMealChoice() {
        return mealChoice;
    }

    public void setMealChoice(String mealChoice) {
        this.mealChoice = mealChoice;
    }

    @Override
    public String toString() {
        return String.format("%s %s always orders the %s",
                firstName,
                lastName,
                mealChoice);
    }
}
```

Consider the following `CustomerDriver` starter code for you:

```java
import java.util.ArrayList;
import java.util.List;

public class CustomerDriver {

  public static void main(String[] args) {
    List<FavoriteCustomer> customers = new ArrayList<FavoriteCustomer>();
    FavoriteCustomer leslie = new FavoriteCustomer("Leslie", "Knope", "waffles with whipped cream");
    customers.add(leslie);

    writeFile("customer.csv", customers);
    readFile("customer.csv");
  }

  public static void readFile(String filepath) {
    // Write your code here!
  }

  public static void writeFile(String filepath, List<FavoriteCustomer> customers) {
    // Write your code here!
  }
}
```

## Instructions

Modify a `CustomerDriver` class that will read and write a CSV file. The CSV
file format would look like this:

```text
Leslie,Knope,waffles with whipped cream
```

To implement the reading and writing of a CSV file, consider the following
instructions and tips:

- Write the method to write to a CSV file.
  - Add a method to the `FavoriteCustomer` class and call it `formatAsCSV()`
    that creates a comma-separated `String` object of the
    `firstName,lastName,mealChoice` of the favorite customer.
    - Refer back to the CSV lesson.
  - Use any of the solutions we learned on how to write to a file in Java to
    write the list of favorite customers to a CSV formatted file.
    - Refer back to the previous lessons.
- Write the method to read from a CSV file.
  - Add a new constructor to the `FavoriteCustomer` class that takes a line of
    content from the CSV file to create a `FavoriteCustomer` object.
    - Refer back to the CSV lesson.
    - Make use of the `split()` method from the `String` class.
  - Use any of the solutions we learned on how to read from a file in Java to
    read in the CSV formatted file.
    - Refer back to the previous lessons.
  - Return a `String` to print out to the console the `FavoriteCustomer` objects
    that were read in from the CSV.
    - Refer back to the CSV lesson.
    - The output should look like:
      - `Leslie Knope always orders the waffles with whipped cream`
- Remove the `@Disabled` annotation from the unit tests and ensure that the tests
  pass successfully still. Refactor as necessary.

## Unit Tests

Consider the following unit tests to help you implement the `writeFile()` and
`readFile()` methods:

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    @Disabled
    @Test
    void testReadOneCustomer() {
        String filename = "test-customer1.csv";
        assertEquals(ron.toString(), CustomerDriver.readFile(filename));
    }

    @Disabled
    @Test
    void testReadMultipleCustomers() {
        String filename = "test-customer2.csv";
        String expectedOutput = String.format("%s%n%s%n%s", ron.toString(), leslie.toString(), ben.toString());
        assertEquals(expectedOutput, CustomerDriver.readFile(filename));
    }

    @Disabled
    @Test
    void testReadNoCustomers() {
        String filename = "test-customer3.csv";
        assertEquals("", CustomerDriver.readFile(filename));
    }

    @Disabled
    @Test
    void testWriteOneCustomer() {
        Path path = Paths.get("test-customer4.csv");
        customers.add(ben);
        CustomerDriver.writeFile(path.toString(), customers);
        try {
            assertEquals("Ben,Wyatt,calzone", Files.readString(path));
        } catch (IOException ioException) {
            fail("Caught exception in testWriteOneCustomer - fail test.");
        }
    }

    @Disabled
    @Test
    void testWriteMultipleCustomers() {
        Path path = Paths.get("test-customer5.csv");
        customers.add(ben);
        customers.add(leslie);
        customers.add(ron);
        CustomerDriver.writeFile(path.toString(), customers);
        String expectedOutput = "Ben,Wyatt,calzone\n" +
                "Leslie,Knope,waffles with whipped cream\n" +
                "Ron,Swanson,four-horse meals of the egg-pork-alypse";
        try {
            assertEquals(expectedOutput, Files.readString(path));
        } catch (IOException ioException) {
            fail("Caught exception in testWriteMultipleCustomers - fail test.");
        }
    }

    @Disabled
    @Test
    void testWriteNoCustomers() {
        Path path = Paths.get("test-customer6.csv");
        CustomerDriver.writeFile(path.toString(), customers);
        try {
            assertEquals(0, Files.size(path));
        } catch (IOException ioException) {
            fail("Caught exception in testWriteNoCustomers - fail test.");
        }
    }
}
```

## Example Runs

Also consider the following example run to help you:

```text
What is the first name of the favorite customer?
Leslie
What is the last name of the favorite customer?
Knope
What is the meal choice of the favorite customer?
waffles with whipped cream
Add another customer? (type "no" to exit)
no

Leslie Knope always orders the waffles with whipped cream
```
