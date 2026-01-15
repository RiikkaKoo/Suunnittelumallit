public class Game {
    private static Map createMap() {
        return new CityMap(6, 6);
    }

    public static void main(String[] args) {
        Map map = createMap();
        map.display();
    }
}
