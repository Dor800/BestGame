import java.util.Random;

public abstract class Unit extends Tile implements Visitor{
    private String name;
    private Integer healthPool;
    private Integer healthAmount;
    private Integer attackPoints;
    private Integer defensePoints;
    private GetTileCallback tileCallback;


    protected Unit(char tile, String name, Integer healthPool, Integer healthAmount, Integer attackPoints, Integer defensePoints) {
        super(tile);
        this.name = name;
        this.healthPool = healthPool;
        this.healthAmount = healthAmount;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;

    }

    public void attack(Unit unit) { //this is the attacker
        Random rnd = new Random();
        Integer attackRoll = rnd.nextInt(this.getAttackPoints() + 1);
        Integer defenseRoll = rnd.nextInt(unit.getDefensePoints() + 1);
        if(attackRoll - defenseRoll > 0){
            unit.setHealthAmount(unit.getHealthAmount() - (attackRoll - defenseRoll));
            if(unit.getHealthAmount() <= 0) {
                Position temp = new Position(this.getPosition());
                this.setPosition(unit.getPosition());
                unit.setPosition(temp);
                this.handleKill(unit.handleDeath());
            }
        }
    }


    protected void moveLeft(){
        Position newPosition = new Position(this.getPosition());
        newPosition.setyAxis(newPosition.getyAxis()-1);
        this.getTileCallback().getTile(newPosition).accept(this);
    }
    protected void moveRight(){
        Position newPosition = new Position(this.getPosition());
        newPosition.setyAxis(newPosition.getyAxis()+1);
        this.getTileCallback().getTile(newPosition).accept(this);
    }
    protected void moveUp(){
        Position newPosition = new Position(this.getPosition());
        newPosition.setxAxis(newPosition.getxAxis()-1);
        this.getTileCallback().getTile(newPosition).accept(this);
    }
    protected void moveDown(){
        Position newPosition = new Position(this.getPosition());
        newPosition.setxAxis(newPosition.getxAxis()+1);
        this.getTileCallback().getTile(newPosition).accept(this);
    }


    public abstract void visit(Empty empty);
    public abstract void visit(Enemy enemy);
    public abstract void visit(Wall wall);
    public abstract void visit(Player player);


    public abstract void handleKill(int experienceValue);

    public abstract int handleDeath();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealthPool() {
        return healthPool;
    }

    public void setHealthPool(Integer healthPool) {
        this.healthPool = healthPool;
    }


    public Integer getHealthAmount() {
        return healthAmount;
    }

    public void setHealthAmount(Integer healthAmount) {
        this.healthAmount = healthAmount;
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

    public void setName(String name) {
        this.name = name;
    }

    public GetTileCallback getTileCallback() {
        return tileCallback;
    }

    public void setTileCallback(GetTileCallback tileCallback) {
        this.tileCallback = tileCallback;
    }
}
