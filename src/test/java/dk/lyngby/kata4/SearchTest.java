package dk.lyngby.kata4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {

    private Search search = new Search();

    //I denne test får vi en liste med alle byer, så snart vi søger på mere end 2 bogstaver, og intet hvis mindre
    @Test
    public void testSearchCitiesWithLessThan2Characters() {
        List<String> results = search.searchCities("A");
        assertTrue(results.isEmpty());
    }


    //I denne test tjekker min metode om den returnerer alle bynavne der starter med minimum 2 bogstaver, i dette tilfælde Va (Valencia, Vancouver)
    @Test
    public void testSearchCitiesExactMatch() {
        List<String> results = search.searchCities("Va");
        assertEquals(2, results.size());
        assertTrue(results.contains("Valencia"));
        assertTrue(results.contains("Vancouver"));
    }


    //Her tjekker testen om vi er case insensitive på søgningen
    @Test
    public void testSearchCitiesCaseInsensitive() {
        List<String> results = search.searchCities("lOn");
        assertEquals(1, results.size());
        assertTrue(results.contains("London"));
    }

    //Her tjekker testen om vi får en liste med alle byer der indeholder "ape" i navnet
    //Koblet op på contains fremfor startsWith.
    @Test
    public void testSearchCitiesContainsLettersMatch() {
        List<String> results = search.searchCities("ape");
        assertTrue(results.contains("Budapest"));
    }

    //Her tjekker testen om vi får en tom liste, hvis vi søger på en by der ikke findes i Array'et
    @Test
    public void testSearchCitiesNoMatch() {
        List<String> results = search.searchCities("Aalborg");
        assertTrue(results.isEmpty());
    }
}