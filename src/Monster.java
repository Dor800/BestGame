import java.util.Random;

public class Monster extends Enemy{
    private final Integer visionRange;

    public Monster(char tile, String name, Integer healthPool, Integer attackPoints, Integer defensePoints, Integer experienceValue, Integer visionRange) {
        super(tile, name, healthPool, healthPool, attackPoints, defensePoints, experienceValue);
        this.visionRange = visionRange;
    }


    public void tick(Player player) {
        if(!ChasePlayer(player.position))
            moveRandomly();
    }

    public void moveRandomly(){
        Random rand = new Random();
        int direction = rand.nextInt(4);  // Generate a random number between 0 and 3

        switch (direction) {
            case 0:
                moveUp();
                break;
            case 1:
                moveDown();
                break;
            case 2:
                moveLeft();
                break;
            case 3:
                moveRight();
                break;
        }
    }

    public boolean ChasePlayer(Position playerP){
        if(this.Range(playerP) < visionRange){
            Integer Mx = this.getPosition().getxAxis();
            Integer My = this.getPosition().getyAxis();
            Integer dx = Mx - playerP.getxAxis();
            Integer dy = My - playerP.getyAxis();
            if(Math.abs(dy) > Math.abs(dx)) {
                if (dy > 0)
                    this.moveLeft();
                else
                    this.moveRight();
            }
            else if (dy > 0)
                this.getPosition().setyAxis(My+1); // Move up
            else
                this.moveDown();
            return true;
        }
        return false;
    }


}
