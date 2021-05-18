import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CityTest {

    City testCity1 = new City("Самара", "Самарская область", "Поволжский округ", 1500000, "1863");
    City testCity2 = new City("Москва", "Московская область", "Центральный округ", 25000000, "1840");
    @Test
    void testToString() {
        String expected = "City{name='Самара', region='Самарская область', district='Поволжский округ', population=1500000, foundation='1863'}";


        String actual = testCity1.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getName() {
        String expected = "Самара";

        String actual = testCity1.getName();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getRegion() {
        String expected = "Самарская область";

        String actual = testCity1.getRegion();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getDistrict() {
        String expected = "Поволжский округ";

        String actual = testCity1.getDistrict();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getPopulation() {
        int expected = 1500000;

        int actual = testCity1.getPopulation();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getFoundation() {
        String expected = "1863";

        String actual = testCity1.getFoundation();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void infoRowConstructorTest(){
        City expected = testCity1;
        City actual = new City("1;Самара;Самарская область;Поволжский округ;1500000;1863");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEquals_Hash(){
        City testCity1Clone = new City(testCity1.getName(),
                                       testCity1.getRegion(),
                                       testCity1.getDistrict(),
                                       testCity1.getPopulation(),
                                       testCity1.getFoundation());
        Assertions.assertTrue(testCity1.equals(testCity1Clone) && testCity1Clone.equals(testCity1));
        Assertions.assertTrue(testCity1.hashCode() == testCity1Clone.hashCode());
    }
}