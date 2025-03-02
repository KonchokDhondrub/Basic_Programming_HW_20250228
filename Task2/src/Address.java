class Address {
    String postcode;
    String city;
    String street;
    String house;

    public Address(String postcode, String city, String street, String house) {
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return postcode + ", " + city + ", " + street + ", " + house;
    }
}