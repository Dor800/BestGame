import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.IOException;

public class GameManager {
    private CLI cli;
    private TileFactory factory;
    private List<Tile[][]> levelsList;
    private Player player;
    private Position playerPos;
    private List<Enemy> enemies;
    private List<String> paths;


    public GameManager(){
        this.factory = new TileFactory();
        this.cli = new CLI();
        this.levelsList = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    public List<String> readAllLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void buildLevel(String path) {
        List<String> lines = readAllLines(path);
        int rows = lines.size();
        int cols = lines.get(0).length();

        List<Character> trapsCharacters = Arrays.asList('B', 'Q', 'D'); // Characters associated with traps.

        Tile[][] level = new Tile[rows][cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++){
                Position pos = new Position(i, j);
                char c = lines.get(i).charAt(j);

                switch(c) {
                    case '#':
                        level[i][j] = factory.produceWall(pos);
                        break;
                    case '.':
                        level[i][j] = factory.produceEmpty(pos);
                        break;
                    case '@':
                        playerPos = pos;
                        break;
                    default:
                        Enemy enemy = factory.produceEnemy(c, pos);
                        if (!trapsCharacters.contains(c)) { // If it's not a trap, add to enemies list.
                            enemies.add(enemy);
                        }
                        level[i][j] = enemy;
                }
            }
        }
        levelsList.add(level);
    }


    public void buildLevels(List<String> paths) {
        for(String path:paths){
            buildLevel(path);
        }
    }


    public void playGame(){
        List<String> example = new ArrayList<>();
        example.add("level1.txt");

        setPaths(example);
        buildLevels(this.paths);
        this.player = cli.getPlayer();
        System.out.println("Selected player: " + player.getName());
        int index = 1;
        for (Tile[][] map: levelsList) {
            if(!player.isAlive()){
                System.out.println("Game Over");
                return;
            }
            player.setPosition(playerPos);
            map[playerPos.getxAxis()][playerPos.getyAxis()] = player;
            Level level = new Level(new GameBoard(map,player,enemies));
            System.out.println("level " + index);
            level.start();
        }
        System.out.println("You completed the game!");
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}




