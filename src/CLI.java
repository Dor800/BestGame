import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CLI {
    private MessageCallback m;
    private InputReader r;

    private TileFactory factory = new TileFactory();

    public CLI(){
        this.m = (s) -> displayMessage(s);
        this.r = () -> getInput();
    }
    private void displayMessage(String s) {
        System.out.println(s);
    }
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Player getPlayer(){
        System.out.println("Choose player type:");
        int i = printPlayers();
        Player p = factory.producePlayer(i);
        p.initialize(m,r);
        return p;
    }

    private int printPlayers() {
        List<Player> playerList = factory.listPlayers();
        int index = 1;
        for (Player player : playerList) {
            System.out.println(index + "." + player.getName() + "\t" + player.getPlayerDetails());
            index++;
        }

        String input = getInput();
        List<String> numbers = IntStream.rangeClosed(1, index)
                .mapToObj(Integer::toString)
                .collect(Collectors.toList());
        if(!numbers.contains(input)){
            System.out.println("You need to enter a number between 1 and " + index);
            printPlayers();
        }
        return numbers.indexOf(input);
    }



}
