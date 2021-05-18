public class City {

    String name;
    String region;
    String district;
    int population;
    String foundation;
    
    public City(String name,
                String region,
                String district,
                int population,
                String foundation){

        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public City(String infoRow){
        String[] info = infoRow.split(";");
        this.name = info[1];
        this.region = info[2];
        this.district = info[3];
        this.population = Integer.parseInt(info[4]);
        this.foundation = info[5];
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }


}


