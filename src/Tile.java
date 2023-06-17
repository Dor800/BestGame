public abstract class Tile implements Comparable<Tile>,Visited {
    protected char tile;
    protected Position position;

    protected Tile(char tile){
        this.tile = tile;
    }

    protected void initialize(Position position){
        this.position = position;
    }

    protected double Range(Position position){
        return Math.sqrt(Math.pow(position.getxAxis() - this.getPosition().getxAxis(),2) + Math.pow(position.getyAxis() - this.getPosition().getyAxis(),2));
    }
    public char getTile() {
        return tile;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void accept(Unit unit);

    @Override
    public int compareTo(Tile tile) {
        return getPosition().compareTo(tile.getPosition());
    }

    @Override
    public String toString() {
        return String.valueOf(tile);
    }

    public void setTile(char tile) {
        this.tile = tile;
    }

}

