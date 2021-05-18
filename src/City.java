import java.util.Scanner;

public class City {

    String title;
    String region;
    String federalRegion;
    int population;
    int foundation;
    
    public City(String title,
                String region,
                String federalRegion,
                int population,
                int foundation){

        this.title = title;
        this.region = region;
        this.federalRegion = federalRegion;
        this.population = population;
        this.foundation = foundation;
    }

    public City(String infoRow){
        String[] info = infoRow.split(";");
        this.title = info[1];
        this.region = info[2];
        this.federalRegion = info[3];
        this.population = Integer.parseInt(info[4]);
        this.foundation = Integer.parseInt(info[5]);
    }

    @Override
    public String toString() {
        return "City{" +
                "title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", federalRegion='" + federalRegion + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}


