import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {
    private List<Tile> tiles;

    public GameBoard(Tile[][] board){
        tiles = new ArrayList<>();
        for(Tile[] line : board){
            tiles.addAll(Arrays.asList(line));
        }
    }

    public Tile get(int x, int y) throws Exception {
        for(Tile t : tiles){
            if (t.getPosition().equals(new Position(x, y))){
                return t;
            }
        }
        throw new Exception("no such tile");
        // Throw an exception if no such tile.
    }

    public void remove(Enemy e) {
        tiles.remove(e);
        Position p = e.getPosition();
        tiles.add(new Empty(p));
    }

    @Override
    public String toString() {
        tiles = tiles.stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Tile tile : tiles) {
            sb.append(tile.toString()).append("\n");
        }
        return sb.toString();
    }
}
