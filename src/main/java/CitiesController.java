import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CitiesController {
    List<City> cities;
    
    public CitiesController(List<City> cities){
        this.cities = cities;
    }

    public CitiesController(String path) throws IOException {
        Scanner scan = new Scanner(Paths.get(path));
        List<City> cities = new ArrayList<>();
        while(scan.hasNext()){
            cities.add(new City(scan.nextLine()));
        }
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
