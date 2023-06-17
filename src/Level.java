import java.util.ArrayList;
import java.util.List;

public class Level {
    private GameBoard board;
    private Player player;

    public Level(GameBoard board){
        this.board = board;
        this.player = board.getPlayer();
    }

    public void start(){
        while(!over()){
            System.out.println(board.toString());
            player.tick();
            List<Enemy> enemiesCopy = new ArrayList<>(board.getEnemies());
            for(Enemy e : enemiesCopy){
                e.tick(player);
            }
            System.out.println(player.getName() + "\t" + player.getPlayerDetails());
        }
    }


    public boolean over() {
        return !board.getPlayer().isAlive() || board.getEnemies().size() == 0;
    }


    public void setPlayer(Player player) {
        this.player = player;
    }
}
