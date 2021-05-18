import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CitiesControllerTest {

    City testCity1 = new City("Самара", "Самарская область", "Поволжский округ", 1500000, "1863");
    City testCity2 = new City("Москва", "Московская область", "Центральный округ", 25000000, "1830");
    City testCity3 = new City("3;Владимир;Владимирская область;Центральный округ;350000;1680;");
    List<City> testCities = new ArrayList<>();
    {
        testCities.add(testCity1);
        testCities.add(testCity2);
        testCities.add(testCity3);
    }
    CitiesController cc = new CitiesController(testCities);

    final String TEST_CITIES_PATH = "src/test/java/testCitiesFile.txt";
    @Test
    void getCities() {
        List<City> expected = testCities;
        CitiesController cc = new CitiesController(testCities);
        List<City> actual = cc.getCities();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void print() {


    }

    @Test
    void sortByName() {
        List<City> expected = new ArrayList<>();
        expected.add(testCity3);
        expected.add(testCity2);
        expected.add(testCity1);

        CitiesController cc = new CitiesController(testCities);
        cc.sortByName();

        List<City> actual = cc.getCities();

        Assertions.assertEquals(actual,expected);
    }

    @Test
    void sortByDistrictAndName() {
        List<City> expected = new ArrayList<>();
        expected.add(testCity1);
        expected.add(testCity3);
        expected.add(testCity2);

        CitiesController cc = new CitiesController(testCities);
        cc.sortByDistrictAndName();

        List<City> actual = cc.getCities();

        Assertions.assertEquals(actual,expected);

    }

    @Test
    void getMostPopulatedCity(){
        int expected = 1;

        int actual = cc.getMostPopulatedCityIndex();

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getCity() {
        City expected = testCity1;

        City actual = cc.getCity(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void CitiesController() throws IOException {
        List<City> expected = testCities;

        List<City> actual = new CitiesController(TEST_CITIES_PATH).getCities();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printRegionSlice() {
        String expected = "Поволжский округ - 1\nЦентральный округ - 2\n";
        String actual = cc.regionalSlice();

        Assertions.assertEquals(expected, actual);
    }
}