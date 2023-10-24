package dk.lyngby.kata4;

import java.util.ArrayList;
import java.util.List;

public class Search {

    //Laver en constructor på Search, som fikser at this.cityNames var null.
    //Dette hjalp alle min tests (det her manglede)
    public Search() {
        cityNames = new ArrayList<>();
        addCityNames();
    }

    private List<String> cityNames;

    public static void main(String[] args) {

       Search search = new Search();
       //Det her fiksede mit static problem
        search.addCityNames();
        String searchText = "Paris";

        List<String> searchResults = search.searchCities(searchText);

        if (searchResults.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Search results:");
            for (String result : searchResults) {
                System.out.println(result);

            }
        }
    }

    // Laver vores ArrayListe med alle byerne
    public void addCityNames() {

        // cityNames = new ArrayList<>();
        cityNames.add("Paris");
        cityNames.add("Budapest");
        cityNames.add("Skopje");
        cityNames.add("Rotterdam");
        cityNames.add("Valencia");
        cityNames.add("Vancouver");
        cityNames.add("Amsterdam");
        cityNames.add("Vienna");
        cityNames.add("Sydney");
        cityNames.add("New York City");
        cityNames.add("London");
        cityNames.add("Bangkok");
        cityNames.add("Hong Kong");
        cityNames.add("Dubai");
        cityNames.add("Rome");
        cityNames.add("Istanbul");
    }

    public List<String> searchCities(String searchText) {

        List<String> results = new ArrayList<>();

        if (searchText.length() < 2) {
            // Hvis den har mindre end 2 bogstaver i søgningen, så returner her
            return results;
        }

        //Tjekker om den starter med "Pa", som sat i main metoden
        //Bruger contains, istedet for startsWith., da vi gerne vi gerne vil kunne søge på "ape" og få budAPEst frem
        //og da contains også dækker startsWith.
        for (String city : cityNames) {
            if (city.toLowerCase().contains(searchText.toLowerCase())) {
                results.add(city);
            }
        }

        return results;
    }

}