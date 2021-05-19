import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        final String CITIES_PATH = "src/main/java/Cities.txt";
        CitiesController cities = new CitiesController(CITIES_PATH);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        boolean isWorking = true;

        while(isWorking) {
            switch(choice){
                case 0:
                    showMenu();
                    choice = scanner.nextInt();
                    break;
                case 1:
                    System.out.println("Вывожу список городов");
                    System.out.println(listOfCities(cities.getCities()));
                    choice = scanner.nextInt();
                    break;
                case 2:
                    cities.sortByName();
                    System.out.println("Список отсортирован по имени");
                    choice = scanner.nextInt();
                    break;
                case 3:
                    cities.sortByDistrictAndName();
                    System.out.println("Список отсортирован по округу");
                    choice = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Самый населенный город:");
                    System.out.println(mostPopulatedCity(cities));
                    choice = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Срез по регионам:");
                    System.out.println(cities.regionalSlice());
                    choice = scanner.nextInt();
                    break;
                case 9:
                    System.out.println("Приложение закрывается");
                    isWorking = false;
                    break;
                default:
                    System.out.println("Что то пошло не так! Выберите снова");
                    choice = scanner.nextInt();
            }
        }
    }


    /**
     * Shows menu in console
     */
    private static void showMenu(){
        System.out.println("Меню:");
        System.out.println("0: Показать меню снова");
        System.out.println("1: Вывести список городов");
        System.out.println("2: Сортировать по названию");
        System.out.println("3: Сортировать по федеральному округу");
        System.out.println("4: Вывести самый населенный город");
        System.out.println("5: Вывести срез населения по регионам");
        System.out.println("9: Выйти из приложения");
    }

    /**
     * @return STRING of all cities
     */
    private static String listOfCities(List<City> cities){
        String result = "";
        for (City city: cities) {
            result += city.toString() + "\n";
        }
        return result;
    }

    /**
     * output example: 3 = 1500000
     * @param cities - CitiesController of this class
     * @return STRING of most populated city
     */
    private static String mostPopulatedCity(CitiesController cities){
        int index = cities.getMostPopulatedCityIndex();
        City mostPopulatedCity = cities.getCity(index);

        return index + " = " + mostPopulatedCity.getPopulation();
    }
}
