import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class MainTest {

    @Test
    public void testGetFullNames() {
        Address address = new Address("12345", "Moscow", "Red Square", "1");
        Person person = new Person("John", "Doe", "john.doe@email.com", "123456789", address);
        List<Person> people = new ArrayList<>();
        people.add(person);

        List<String> result = Main.getPersonInfo(people, p -> p.fName + " " + p.lName);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("John Doe", result.get(0));
    }

    @Test
    public void testGetEmails() {
        Address address = new Address("12345", "Moscow", "Red Square", "1");
        Person person = new Person("John", "Doe", "john.doe@email.com", "123456789", address);
        List<Person> people = new ArrayList<>();
        people.add(person);

        List<String> result = Main.getPersonInfo(people, p -> p.email);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("john.doe@email.com", result.get(0));
    }

    @Test
    public void testGetPhones() {
        Address address = new Address("12345", "Moscow", "Red Square", "1");
        Person person = new Person("John", "Doe", "john.doe@email.com", "123456789", address);
        List<Person> people = new ArrayList<>();
        people.add(person);

        List<String> result = Main.getPersonInfo(people, p -> p.phone);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("123456789", result.get(0));
    }

    @Test
    public void testGetAddresses() {
        Address address = new Address("12345", "Moscow", "Red Square", "1");
        Person person = new Person("John", "Doe", "john.doe@email.com", "123456789", address);
        List<Person> people = new ArrayList<>();
        people.add(person);

        List<String> result = Main.getPersonInfo(people, p -> p.address.toString());

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("12345, Moscow, Red Square, 1", result.get(0));
    }

    @Test
    public void testEmptyList() {
        List<Person> people = new ArrayList<>();

        List<String> result = Main.getPersonInfo(people, p -> p.fName + " " + p.lName);

        Assertions.assertTrue(result.isEmpty());
    }
}
