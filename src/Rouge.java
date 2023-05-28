public class Rouge extends Player{
    private Integer cost;
    private Integer currentEnergy;

    public Rouge(char tile, String name, Integer healthPool, Integer healthAmount, Integer attackPoints, Integer defensePoints, Integer experience,
                 Integer level, String specialAbility, Integer cost, Integer currentEnergy) {
        super(tile, name, healthPool, healthAmount, attackPoints, defensePoints, experience, level, specialAbility);
        this.cost = cost;
        this.currentEnergy = currentEnergy;
    }


}
