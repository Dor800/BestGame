public class Empty extends Tile{
    public Empty(Position position){
        super('.');
        this.setPosition(position);
    }

    @Override
    public void accept(Unit unit) {
        //need to do
    }
}
