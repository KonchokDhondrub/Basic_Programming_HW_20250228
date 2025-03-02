import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SortTest {
    private List<Cars> carsList;

    @BeforeEach
    void setUp() {
        carsList = new ArrayList<>();
        carsList.add(new Cars("Mercedes", "AA 0111", 2002, 15000.95));
        carsList.add(new Cars("VW", "BB 20382", 2014, 25000.5));
        carsList.add(new Cars("Opel", "CC 4622", 2020, 32000));
        carsList.add(new Cars("ZAZ", "DD 3621", 1984, 5000.50));
    }

    @Nested
    public class SortingTests {
        @Test
        @DisplayName("Sorting by Brand")
        void valueOf_BrandSort() {
            List<Cars> actual = Main.sort(carsList, (c1, c2) -> c1.getBrand().compareTo(c2.getBrand()));
            List<Cars> expected = new ArrayList<>();
            expected.add(new Cars("Mercedes", "AA 0111", 2002, 15000.95));
            expected.add(new Cars("Opel", "CC 4622", 2020, 32000));
            expected.add(new Cars("VW", "BB 20382", 2014, 25000.5));
            expected.add(new Cars("ZAZ", "DD 3621", 1984, 5000.50));

            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Sorting by ID")
        void valueOf_IdSort() {
            List<Cars> actual = Main.sort(carsList, Comparator.comparing(Cars::getId));
            List<Cars> expected = new ArrayList<>();
            expected.add(new Cars("Mercedes", "AA 0111", 2002, 15000.95));
            expected.add(new Cars("VW", "BB 20382", 2014, 25000.5));
            expected.add(new Cars("Opel", "CC 4622", 2020, 32000));
            expected.add(new Cars("ZAZ", "DD 3621", 1984, 5000.50));

            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Sorting by Year")
        void valueOf_YearSort() {
            List<Cars> actual = Main.sort(carsList, (c1, c2) -> c1.getYear() - c2.getYear());
            List<Cars> expected = new ArrayList<>();
            expected.add(new Cars("ZAZ", "DD 3621", 1984, 5000.50));
            expected.add(new Cars("Mercedes", "AA 0111", 2002, 15000.95));
            expected.add(new Cars("VW", "BB 20382", 2014, 25000.5));
            expected.add(new Cars("Opel", "CC 4622", 2020, 32000));

            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Sorting by Price")
        void valueOf_PriceSort() {
            List<Cars> actual = Main.sort(carsList, (c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()));
            List<Cars> expected = new ArrayList<>();
            expected.add(new Cars("ZAZ", "DD 3621", 1984, 5000.50));
            expected.add(new Cars("Mercedes", "AA 0111", 2002, 15000.95));
            expected.add(new Cars("VW", "BB 20382", 2014, 25000.5));
            expected.add(new Cars("Opel", "CC 4622", 2020, 32000));

            Assertions.assertEquals(expected, actual);
        }
    }
    @Test
    @DisplayName("If get empty or null List")
    void testSortWithEmptyList() {
        List<Cars> emptyList = new ArrayList<>();
        List<Cars> sortedList = Main.sort(emptyList, (c1, c2) -> c1.getBrand().compareTo(c2.getBrand()));

        Assertions.assertNotNull(sortedList, "Return empty list");
        Assertions.assertTrue(sortedList.isEmpty(), "Sorted list is empty");
    }
}