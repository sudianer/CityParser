import sun.security.util.ConstraintsParameters;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class CitiesController {
    List<City> cities;
    
    public CitiesController(List<City> cities){
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }
    
    public void print(){
        for (City x: cities) {
            System.out.println(x.toString());
        }
    }
    
    public void sortByName(){
        cities.sort(Comparator.comparing(c -> c.getName().toLowerCase()));
    }
    
    public void sortByDistrictAndName(){
        cities.sort(Comparator.comparing(c -> c.getDistrict().toLowerCase() + c.getName().toLowerCase()));
    }
    
}
