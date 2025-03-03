import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cars> carsList = new ArrayList<>();
                carsList.add(new Cars("Mercedes", "AA 0111", 2002, 15000.95));
                carsList.add(new Cars("VW", "BB 20382", 2014, 25000.5));
                carsList.add(new Cars("Opel", "CC 4622", 2020, 32000));
                carsList.add(new Cars("ZAZ", "DD 3621", 1984, 5000.50));

        System.out.println("---------------- Sort by Brand ----------------");
        print(sort(carsList, (c1, c2) -> c1.getBrand().compareTo(c2.getBrand())));
        System.out.println("---------------- Sort by ID ----------------");
        print(sort(carsList, Comparator.comparing(Cars::getId)));
        System.out.println("---------------- Sort by Year ----------------");
        print(sort(carsList, (c1, c2) -> c1.getYear() - c2.getYear()));
        System.out.println("---------------- Sort by Price ----------------");
        print(sort(carsList, (c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice())));
    }

    public static void print(List<?> list){
        if (list == null || list.isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        for (var element:list){
            System.out.println(element);
        }
    }

    public static <E> List<E> sort(Collection<E> list, Comparator<E> comparator) {
        if (list == null || list.isEmpty() || comparator == null) return new ArrayList<>();
        List<E> result = new ArrayList<>(list);
        result.sort(comparator);
        return result;
    }
}
