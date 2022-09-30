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

```plaintext
Leslie,Knope,waffles with whipped cream
```

To implement the reading and writing of a CSV file, considering the following
instructions and tips:

- Write the method to write to a CSV file.
  - Add a method to the `FavoriteCustomer` class and call it `formatAsCSV()`
    that creates a comma-separated `String` object of the
    `firstName,lastName,mealChoice` of the favorite customer.
    - Refer back to the CSV lesson.
  - Use a `FileWriter` object to write the list of favorite customers to a CSV
    formatted file.
    - Refer back to the File Input Output (IO) lesson.
    - Refer back to the CSV lesson.
- Write the method to read from a CSV file.
  - Add a new constructor to the `FavoriteCustomer` class that takes a line of
    content from the CSV file to create a `FavoriteCustomer` object.
    - Refer back to the CSV lesson.
    - Make use of the `split()` method from the `String` class.
  - Use a `Scanner` object to read from the CSV formatted file.
    - Refer back to the File Input Output lesson.
    - Refer back to the CSV lesson.
  - Return a `String` to print out to the console the `FavoriteCustomer` objects
    that were read in from the CSV.
    - Refer back to the CSV lesson.
    - The output should look like:
      - `Leslie Knope always orders the waffles with whipped cream`
- Remove the `@Disable` annotation from the unit tests and ensure that the tests
  pass successfully still. Refactor as necessary.

## Unit Tests

Consider the following unit tests to help you implement the `writeFile()` and
`readFile()` methods:


12345678910111213141516171819202122232425262728293031323334353637383940404143454

