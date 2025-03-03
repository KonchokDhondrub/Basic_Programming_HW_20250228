import java.util.*;

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

        System.out.println("Full Names: " + getPersonInfo(people, p -> p.getfName() + " " + p.getlName()));
        System.out.println("Emails: " + getPersonInfo(people, p -> p.getEmail()));
        System.out.println("Phones: " + getPersonInfo(people, p -> p.getPhone()));
        System.out.println("Addresses: " + getPersonInfo(people, p -> p.getAddress().toString()));
    }

    public static <E extends Person> Set<String> getPersonInfo(List<E> people, PersonToString converter) {
        Set<String> result = new HashSet<>();
        if (people==null) return result;

        for (E person : people) {
            result.add(converter.personToString(person));
        }
        return result;
    }
}
