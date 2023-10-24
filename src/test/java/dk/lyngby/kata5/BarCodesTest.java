package dk.lyngby.kata5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarCodesTest {
    BarCodes barCodes = new BarCodes();

    @Test
    public void shouldDisplay725ForBarcode1234(){
        String barcode = "12345";
        String expected = "Price: 7.25";

        String actual = barCodes.getPrice(barcode);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDisplay1250ForBarcode23456(){
        String barcode = "23456";
        String expected = "Price: 12.50";

        String actual = barCodes.getPrice(barcode);

        assertEquals(expected, actual);
    }
    @Test
    public void shouldDisplayErrorForBarcode9999(){
        String barcode = "9999";
        String expected = "Error: barcode not found";

        String actual = barCodes.getPrice(barcode);

        assertEquals(expected, actual);
    }
    @Test
    public void shouldDislayEmptyforEmptyBarcode(){
        String barcode = "";
        String expected = "Error: empty barcode";

        String actual = barCodes.getPrice(barcode);

        assertEquals(expected, actual);
    }




    @Test
    public void shouldDisplayTotalPriceForMultipleBarcodes() {
        String expected = "Total Price: 19.75";
        String actual = barCodes.getTotalPrice(Arrays.asList("12345", "23456"));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldHandleEmptyList() {
        String expected = "Total Price: 0.00";
        String actual = barCodes.getTotalPrice(Arrays.asList());
        assertEquals(expected, actual);
    }


}