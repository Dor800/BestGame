public abstract class Unit extends Tile{
    private String name;
    private Integer healthPool;
    private Integer healthAmount;
    private Integer attackPoints;
    private Integer defensePoints;

    protected Unit(char tile, String name, Integer healthPool, Integer healthAmount, Integer attackPoints, Integer defensePoints) {
        super(tile);
        this.name = name;
        this.healthPool = healthPool;
        this.healthAmount = healthAmount;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }

    public double range(Enemy E, Player P){
        return (Math.sqrt(Math.pow(E.getPosition().getxAxis() - P.getPosition().getxAxis(),2) + Math.pow(E.getPosition().getyAxis() - P.getPosition().getyAxis(),2)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealthPool() {
        return healthPool;
    }

    public void setHealthPool(Integer healthAmount) {
        this.healthAmount = healthAmount;
    }


    public Integer getHealthAmount() {
        return healthAmount;
    }

    public void setHealthAmount(Integer healthPool) {
        this.healthPool = healthPool;
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(Integer attackPoints) {
        this.attackPoints = attackPoints;
    }

    public Integer getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(Integer defensePoints) {
        this.defensePoints = defensePoints;
    }
}
