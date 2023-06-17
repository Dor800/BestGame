import java.util.Random;

public class Warrior extends Player{
    private Integer abilityCooldown;
    private Integer remainingCooldown;

    public Warrior(String name, Integer healthAmount, Integer attackPoints, Integer defensePoints, Integer abilityCooldown) {
        super(name, healthAmount, healthAmount, attackPoints, defensePoints,"Avenger’s Shield");
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = abilityCooldown;
    }

    public void roleLevelUp(){
        super.levelUp();
        this.remainingCooldown = 0;
        this.setHealthPool(this.getHealthPool() + (this.getLevel()*5));
        this.setAttackPoints(this.getAttackPoints() + (this.getLevel())*2);
        this.setDefensePoints(this.getDefensePoints() + (this.getLevel()));
    }

    //on game tick
    public void handleTick(){
        if(this.remainingCooldown > 0)
            this.remainingCooldown = this.remainingCooldown - 1;
    }

    public void abilityCast(){
        if(this.remainingCooldown == 0){
            this.remainingCooldown = this.abilityCooldown;
            this.setAttackPoints(Math.min(this.getHealthAmount() + (10 * this.getDefensePoints()),this.getHealthPool()));
            Random rnd = new Random();
            Enemy enemy = getEnemies().get(rnd.nextInt(getEnemies().size()));
            enemy.setHealthAmount(enemy.getHealthAmount() - (this.getHealthPool()/10));
        }
        else
            System.out.println("Ability is not ready yet");
    }

    @Override
    public String getPlayerDetails() {
        return super.getPlayerDetails() + String.format("\tCooldown: %d/%d", this.remainingCooldown, this.abilityCooldown);
    }
}
