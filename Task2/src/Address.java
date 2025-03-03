import java.util.Objects;

class Address {
    private String postcode;
    private String city;
    private String street;
    private String house;

    public Address(String postcode, String city, String street, String house) {
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getPostcode() {
        return postcode;
    }
    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public String getHouse() {
        return house;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;
        return Objects.equals(postcode, address.postcode) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house, address.house);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(postcode);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(street);
        result = 31 * result + Objects.hashCode(house);
        return result;
    }

    @Override
    public String toString() {
        return postcode + ", " + city + ", " + street + ", " + house;
    }
}