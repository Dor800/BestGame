public class Enemy extends Unit {
    private Integer experienceValue;

    public Enemy(char tile, String name, Integer healthPool, Integer healthAmount, Integer attackPoints, Integer defensePoints, Integer experienceValue) {
        super(tile, name, healthPool, healthAmount, attackPoints, defensePoints);
        this.experienceValue = experienceValue;
    }


    @Override
    public void accept(Unit unit) {
        //need to implement
    }
}
