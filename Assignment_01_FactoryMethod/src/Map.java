public abstract class Map {

    public int h;
    public int w;
    public Tile[][] tiles;

    public Map(int height, int width) {
        this.h = height;
        this.w = width;
        tiles = new Tile[height][width];
    }

    public abstract Tile createTile();
    public abstract void display();
}
