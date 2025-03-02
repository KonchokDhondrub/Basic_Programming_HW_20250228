class Person {
    String fName;
    String lName;
    String email;
    String phone;
    Address address;

    public Person(String fName, String lName, String email, String phone, Address address) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    @Override
    public String toString() {
        return fName + ", " + lName + ", " + email + ", " + phone + ", " + address;
    }
}