import java.util.Random;

public class Mage extends Player {
    private Integer manaPool;
    private Integer currentMana;
    private Integer manaCost;
    private Integer spellPower;
    private Integer hitsCount;
    private Integer abilityRange;

    public Mage(String name, Integer healthAmount, Integer attackPoints, Integer defensePoints,
                Integer manaPool, Integer manaCost, Integer spellPower, Integer hitsCount, Integer abilityRange) {
        super(name, healthAmount, healthAmount, attackPoints, defensePoints, "Blizzard");
        this.manaPool = manaPool;
        this.currentMana = manaPool/4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
    }

    public void roleLevelUp() {
        super.levelUp();

        this.manaPool = this.manaPool + (25 * this.getLevel());
        this.currentMana = Math.min(this.currentMana + (this.manaPool / 4), this.manaPool);
        this.spellPower = this.spellPower + (10 * this.getLevel());
    }

    //on game tick
    public void handleTick() {
        this.currentMana = Math.min( this.manaPool , this.currentMana + (this.getLevel()));
    }

    public Enemy isExistEnemyInRange(){
        for (Enemy enemy: getEnemies()) {
            if(enemy.Range(this.position) < this.abilityRange)
                return enemy;
        }
        return null;
    }
    public void abilityCast(){
        if(this.currentMana >= this.manaCost){
            this.currentMana = this.currentMana - this.manaCost;
            Integer hits = 0;
            Enemy enemy = isExistEnemyInRange();
            while((hits < hitsCount) &&  enemy != null){
                Random rnd = new Random();
                Integer defenseRoll = rnd.nextInt(enemy.getDefensePoints() + 1);
                if (this.getAttackPoints() - defenseRoll > 0)
                    enemy.setHealthAmount(enemy.getHealthAmount() - this.spellPower);
                hits++;
            }
        }
        else
            System.out.println("Not enough mana");
    }

    @Override
    public String getPlayerDetails() {
        return super.getPlayerDetails() + String.format("\tMana: %d/%d\tSpell Power: %d", this.currentMana, this.manaPool, this.spellPower);
    }


}
