import java.util.Random;

public class Trap extends Enemy{
    private Integer visibilityTime;
    private Integer invisibilityTime;
    private Integer ticksCount;
    private Boolean visible;
    private final char originalTile;

    public Trap(char tile, String name, Integer healthAmount,  Integer attackPoints, Integer defensePoints,
                Integer experienceValue, Integer visibilityTime, Integer invisibilityTime) {

        super(tile, name, healthAmount, healthAmount, attackPoints, defensePoints, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visible = true;
        this.originalTile = tile;
    }

    @Override
    public void tick(Player player) {
        stateTrap(player);
    }

    public void stateTrap(Player player){
        visible = (ticksCount < visibilityTime);
        if(visible)
            this.setTile(originalTile);
        else
            this.setTile('.');
        if(ticksCount == (visibilityTime + invisibilityTime))
            this.ticksCount = 0;
        else
            this.ticksCount = ticksCount + 1;
        if((range(this,player)) < 2)
            attack(player);
    }
    public void trapAttack(Player player) {
        Random rnd = new Random();
        Integer attackRoll = rnd.nextInt(this.getAttackPoints() + 1);
        Integer defenseRoll = rnd.nextInt(player.getDefensePoints() + 1);
        if(attackRoll - defenseRoll > 0){
            player.setHealthAmount(player.getHealthAmount() - (attackRoll - defenseRoll));
            if(player.getHealthAmount() <= 0) {
                player.handleDeath();
            }
        }
        this.handleDeath();
    }


    public void attack(Player p){
        //how much it reduces from healthAmount?????
        //setHealthAmount();
    }

}
