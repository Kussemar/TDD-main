package dk.lyngby.kata3;



public class Password {


    public String validateLength(String number) {
        if (number.length() >= 8) {
            return "is valid";
        }
        return "Password must be at least 8 characters";
    }

    public boolean validateHasTwoDigits(String input) {
        return input.matches(".*\\d{2}.*");
    }

    public boolean validateHasOneCapitalLetter(String s) {
        return s.matches(".*[A-Z].*");
    }


}

