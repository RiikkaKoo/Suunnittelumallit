package assignment;

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        try {
            System.out.println("\n" + facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "value"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            System.out.println("\n" + facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest", "rates.JPY"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
