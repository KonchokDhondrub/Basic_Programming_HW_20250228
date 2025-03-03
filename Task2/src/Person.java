import java.util.Objects;

class Person {
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private Address address;

    public Person(String fName, String lName, String email, String phone, Address address) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return Objects.equals(fName, person.fName) && Objects.equals(lName, person.lName) && Objects.equals(email, person.email) && Objects.equals(phone, person.phone) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(fName);
        result = 31 * result + Objects.hashCode(lName);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(phone);
        result = 31 * result + Objects.hashCode(address);
        return result;
    }

    @Override
    public String toString() {
        return fName + ", " + lName + ", " + email + ", " + phone + ", " + address;
    }
}