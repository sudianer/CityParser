import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class CitiesController {
    private List<City> cities;
    
    public CitiesController(List<City> cities){
        this.cities = cities;
    }

    public CitiesController(String path) throws IOException {
        Scanner scan = new Scanner(Paths.get(path));
        List<City> cities = new ArrayList<>();

        while(scan.hasNext()){
            String[] infoRow = scan.nextLine().split(";");
            cities.add(new City(infoRow[1], infoRow[2], infoRow[3], Integer.parseInt(infoRow[4]), infoRow[5]));
        }
        this.cities = cities;
    }



    public List<City> getCities() {
        return cities;
    }

    public City getCity(int index){
        return cities.get(index);
    }
    
    public void sortByName(){
        cities.sort(Comparator.comparing(city -> city.getName().toLowerCase()));
    }
    
    public void sortByDistrictAndName(){
        cities.sort(Comparator.comparing(city -> city.getDistrict().toLowerCase() + city.getName().toLowerCase()));
    }

    public int getMostPopulatedCityIndex(){

        int population = 0;
        int index = 0;

        for (int i = 0; i < cities.size(); i++){
            if(cities.get(i).getPopulation() > population){
                population = cities.get(i).getPopulation();
                index = i;
            }
        }

        return index;
    }

    public String regionalSlice(){
        String district;
        Integer number;
        Map<String, Integer> slice = new HashMap<>();
        for (City city : cities) {
            district = city.getDistrict();

            if(!slice.containsKey(district)){
                slice.put(city.getDistrict(), 1);
                continue;
            }

            number = slice.get(district);
            slice.replace(district, number, number+1);

        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry entry: slice.entrySet()) {
            result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return result.toString();

    }

}
