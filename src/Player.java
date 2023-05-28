public class Player extends Unit{

    private static final Integer LEVELUP = 50;
    private static final Integer HEALTHPOOLUP = 10;
    private static final Integer ATTACKUP = 4;
    private static final Integer DEFENSEUP = 1;


    private Integer experience;
    private Integer level;

    private String specialAbility;

    public Player(char tile, String name, Integer healthPool, Integer healthAmount , Integer attackPoints, Integer defensePoints, Integer experience, Integer level, String specialAbility) {
        super(tile, name, healthPool, healthAmount, attackPoints, defensePoints);
        this.experience = 0;
        this.level = 1;
        this.specialAbility = specialAbility;
    }

    public void levelUp(){
    this.experience = this.experience - (level*LEVELUP);
    this.level = level + 1;
    setHealthPool((getHealthPool() + (level*HEALTHPOOLUP)));
    setHealthAmount(getHealthPool());
    setAttackPoints(getAttackPoints() + (level*ATTACKUP));
    setDefensePoints(getDefensePoints() + (level*DEFENSEUP));
    }


    public void abilityCast() {
    }



    @Override
    public void accept(Unit unit) {

    }
}
