import java.util.Objects;

public class Cars {
    private String brand;
    private String id;
    private int year;
    private double price;

    public Cars(String brand, String id, int year, double price) {
        this.brand = brand;
        this.id = id;
        this.year = year;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Cars cars = (Cars) o;
        return year == cars.year && Double.compare(price, cars.price) == 0 && Objects.equals(brand, cars.brand) && Objects.equals(id, cars.id);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(brand);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + year;
        result = 31 * result + Double.hashCode(price);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Brand: %-9s [ %-8s ] Year: %d, Price: %.2f EUR", brand, id, year, price);
    }
}
