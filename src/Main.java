import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {

        final String CITIES_PATH = "src/Cities.txt";
        List<City> cities = readCities(CITIES_PATH);

        for (City x: cities) {
            System.out.println(x.toString());
        }
    }

    public static List<City> readCities(String path) throws IOException {

        List<City> cities = new ArrayList<>();
        Scanner scanner = new Scanner(Paths.get(path)).useDelimiter(";");

        while(scanner.hasNext()){
            cities.add(new City(scanner.nextLine()));
        }

        return cities;
    }

}
