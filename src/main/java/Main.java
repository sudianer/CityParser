import com.sun.tools.javac.util.Assert;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        final String CITIES_PATH = "src/main/java/Cities.txt";
        CitiesController cities = new CitiesController(readCities(CITIES_PATH));
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
                    cities.print();
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

    public static List<City> readCities(String path) throws IOException {

        Assert.checkNonNull(path);
        List<City> cities = new ArrayList<>();
        Scanner scanner = new Scanner(Paths.get(path));

        while(scanner.hasNext()){
            cities.add(new City(scanner.nextLine()));
        }

        return cities;
    }

    public static void printCities(List<City> cities){
        for (City x: cities) {
            System.out.println(x.toString());
        }
    }

    public static void showMenu(){
        System.out.println("Меню:");
        System.out.println("0: Показать меню снова");
        System.out.println("1: Вывести список городов");
        System.out.println("2: Сортировать по названию");
        System.out.println("3: Сортировать по федеральному округу(пока не реализовано)");
        System.out.println("9: Выйти из приложения");
    }


}
