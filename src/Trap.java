public class Trap extends Enemy{
    private Integer visibilityTime;
    private Integer invisibilityTime;
    private Integer ticksCount;
    private Boolean visible;

    public Trap(char tile, String name, Integer healthPool, Integer healthAmount,  Integer attackPoints, Integer defensePoints,
                Integer experienceValue, Integer visibilityTime, Integer invisibilityTime) {

        super(tile, name, healthPool, healthAmount, attackPoints, defensePoints, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visible = true;
    }

    public void stateTrap(Player player){
        visible = (ticksCount < visibilityTime);
        if(ticksCount == (visibilityTime + invisibilityTime))
            this.ticksCount = 0;
        else
            this.ticksCount = ticksCount + 1;
        if((range(this,player)) < 2)
            attack(player);
    }

    public void attack(Player p){
        //how much it reduces from healthAmount?????
        //setHealthAmount();
    }

}
