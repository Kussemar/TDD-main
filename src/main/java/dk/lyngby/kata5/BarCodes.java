package dk.lyngby.kata5;

import java.util.List;
import java.util.Locale;

public class BarCodes {


    public String getPrice(String barcode) {
        if(barcode.equals("12345")){
            return "Price: 7.25";
        }
        if(barcode.equals("23456")){
            return "Price: 12.50";
        }
        if(barcode.equals("9999")){
            return "Error: barcode not found";
        }

        return "Error: empty barcode";
    }

    // GPT

    public String getTotalPrice(List<String> barcodes) {
        double total = 0.0;
        for (String barcode : barcodes) {
            String priceString = getPrice(barcode);
            if (priceString.startsWith("Price: ")) {
                total += convertPriceToDouble(priceString);
            }
        }
        return "Total Price: " + String.format(Locale.US, "%.2f", total);
    }

    private double convertPriceToDouble(String priceString) {
        return Double.parseDouble(priceString.replace("Price: ", ""));
    }

}
