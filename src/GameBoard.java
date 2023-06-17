import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {
    private List<Tile> tiles;
    private Player player;
    private List<Enemy> enemies;
    private int height;
    private int width;

    public GameBoard(Tile[][] board, Player player, List<Enemy> enemies){
        tiles = new ArrayList<>();
        height = board.length;
        width = board[0].length;
        for(Tile[] line : board){
            tiles.addAll(Arrays.asList(line));
        }
        this.player = player;
        this.enemies = enemies;
        player.setEnemies(enemies);

        for (Enemy enemy: enemies) {
            enemy.setDeathCallback(e -> {
                enemies.remove(e);
                tiles.set(tiles.indexOf(enemy), new Empty(enemy.getPosition()));
            });
            enemy.setTileCallback(this::getTile);
        }

        player.setTileCallback(this::getTile);
    }

    public Tile getTile(Position position) {
        try {
            return get(position.getxAxis(), position.getyAxis());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Tile get(int x, int y) throws Exception {
        for(Tile t : tiles){
            if (t.getPosition().compareTo(new Position(x, y)) == 0){
                return t;
            }
        }
        throw new Exception("no such tile " + x + " " + y); // Throw an exception if no such tile.
    }

    public Player getPlayer(){
        return player;
    }

    public List<Enemy> getEnemies(){
        return enemies;
    }

    public void remove(Enemy e) {
        tiles.remove(e);
        Position p = e.getPosition();
        tiles.add(new Empty(p));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                try {
                    sb.append(get(i, j).getTile());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            sb.append('\n'); // Start a new line for each row
        }
        return sb.toString();

    }
}
