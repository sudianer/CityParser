import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class MainTest {
    City testCity1 = new City("Самара", "Самарская область", "Поволжский округ", 1500000, "1863");
    City testCity2 = new City("Москва", "Московская область", "Центральный округ", 25000000, "1830");
    List<City> testCities = new ArrayList<>();
    {
        testCities.add(testCity1);
        testCities.add(testCity2);
    }

    @Test
    void main() {

    }
}