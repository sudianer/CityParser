import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    void testToString() {
        String expected = "City{name='Самара', region='Самарская область', district='Поволжский округ', population=1500000, foundation='1863'}";


        String actual = new City("Самара", "Самарская область", "Поволжский округ", 1500000, "1863").toString();

        Assertions.assertEquals(expected, actual);
    }
}