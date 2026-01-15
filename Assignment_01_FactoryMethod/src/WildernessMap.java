public class WildernessMap extends Map {

    public WildernessMap(int height, int width) {
        super(height, width);
        for (int i = 0; i < super.h; i++) {
            for (int j = 0; j < super.w; j++) {
                super.tiles[i][j] = createTile();
            }
        }
    }

    @Override
    public Tile createTile() {
        Tile newTile = null;
        int randNum = (int) (Math.random() * 3) + 1;
        switch (randNum) {
            case 1:
                newTile = new SwampTile();
                break;
            case 2:
                newTile = new WaterTile();
                break;
            case 3:
                newTile = new ForestTile();
                break;
        }
        return newTile;
    }

    @Override
    public void display() {
        for (int i = 0; i < super.h; i++) {
            for (int j = 0; j < super.w; j++) {
                System.out.print(" " + super.tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
