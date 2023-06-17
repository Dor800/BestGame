import java.util.Random;

public class Rogue extends Player{
    private Integer cost;
    private Integer currentEnergy;
    private static final Integer ENERGY = 100;

    public Rogue(String name, Integer healthAmount, Integer attackPoints, Integer defensePoints, Integer cost) {
        super(name, healthAmount, healthAmount, attackPoints, defensePoints,"Fan of Knives");
        this.cost = cost;
        this.currentEnergy = ENERGY;
    }

    public void roleLevelUp(){
        super.levelUp();

        this.currentEnergy = ENERGY;
        this.setAttackPoints(this.getAttackPoints() + (this.getLevel()*3));
    }

    //on game tick
    public void handleTick(){
        this.currentEnergy = Math.min(this.currentEnergy + 10, 100);
    }

    public void abilityCast(){
        if(this.currentEnergy >= this.cost){
            this.currentEnergy = this.currentEnergy - this.cost;
            for (Enemy enemy: getEnemies()) {
                if (enemy.Range(this.position) < 2) {
                    Random rnd = new Random();
                    Integer defenseRoll = rnd.nextInt(enemy.getDefensePoints() + 1);
                    if (this.getAttackPoints() - defenseRoll > 0)
                        enemy.setHealthAmount(enemy.getHealthAmount() - this.getAttackPoints());
                }
            }
        }
        else
            System.out.println("Not enough energy");
    }

    @Override
    public String getPlayerDetails() {
        return super.getPlayerDetails() + String.format("\tEnergy: %d/%d", this.currentEnergy, ENERGY);
    }
}
