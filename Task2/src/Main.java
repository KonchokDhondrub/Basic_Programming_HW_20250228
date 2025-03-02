import java.util.List;
import java.util.ArrayList;

@FunctionalInterface
interface PersonToString {
    String personToString(Person p);
}

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("12345", "Moscow", "Red Square", "1");
        Address address2 = new Address("67890", "Saint Petersburg", "Nevsky", "10");

        Person person1 = new Person("John", "Doe", "john.doe@email.com", "123456789", address1);
        Person person2 = new Person("Jane", "Smith", "jane.smith@email.com", "987654321", address2);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        List<String> fullNames = getPersonInfo(people, p -> p.fName + " " + p.lName);
        System.out.println("Full Names: " + fullNames);

        List<String> emails = getPersonInfo(people, p -> p.email);
        System.out.println("Emails: " + emails);

        List<String> phones = getPersonInfo(people, p -> p.phone);
        System.out.println("Phones: " + phones);

        List<String> addresses = getPersonInfo(people, p -> p.address.toString());
        System.out.println("Addresses: " + addresses);
    }

    public static List<String> getPersonInfo(List<Person> people, PersonToString converter) {
        List<String> result = new ArrayList<>();
        for (Person person : people) {
            result.add(converter.personToString(person));
        }
        return result;
    }
}
