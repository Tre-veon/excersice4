import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class CityTemperatures {
    static HashMap<String, ArrayList<Double>> cityTemperatures = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        getCityTemperatures();
        calculateAverageTemperatures();
        displayResults();
    }

     static void getCityTemperatures() {
        System.out.println("Enter the name of a city (or END to finish):");
        String city = sc.nextLine();

        while (!city.equals("END")) {
            ArrayList<Double> temperatures = new ArrayList<>();

            System.out.println("Enter the average daily temperature for the next five days:");
            for (int i = 0; i < 5; i++) {
                temperatures.add(sc.nextDouble());
                sc.nextLine();
            }

            cityTemperatures.put(city, temperatures);

            System.out.println("Enter the name of a city (or END to finish):");
            city = sc.nextLine();
        }
    }

     static void calculateAverageTemperatures() {
        for (String city : cityTemperatures.keySet()) {
            ArrayList<Double> temperatures = cityTemperatures.get(city);
            double sum = 0;
            for (double temperature : temperatures) {
                sum += temperature;
            }
            double average = sum / temperatures.size();
            cityTemperatures.put(city, temperatures);
        }
    }

     static void displayResults() {
        System.out.println("City Temperatures:");
        for (String city : cityTemperatures.keySet()) {
            ArrayList<Double> temperatures = cityTemperatures.get(city);
            double sum = 0;
            for (double temperature : temperatures) {
                sum += temperature;
            }
            double average = sum / temperatures.size();
            System.out.println(city + ": " + average);
        }
    }
}