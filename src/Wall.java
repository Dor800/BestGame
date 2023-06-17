public class Wall extends Tile{
    public Wall(Position position){
        super('#');
        this.setPosition(position);
    }

    @Override
    public void accept(Unit unit) {}
}
