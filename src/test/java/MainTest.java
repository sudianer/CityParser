import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.TextParsingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void readCities() throws IOException {
        List<City> expected = testCities;
        List<City> actual = Main.readCities("src/test/java/testCitiesFile.txt");

        Assertions.assertEquals(expected, actual);

    }
}