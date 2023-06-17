public class Enemy extends Unit {
    private Integer experienceValue;
    private EnemyDeathCallback deathCallback;



    public Enemy(char tile, String name, Integer healthPool, Integer healthAmount, Integer attackPoints, Integer defensePoints, Integer experienceValue) {
        super(tile, name, healthPool, healthAmount, attackPoints, defensePoints);
        this.experienceValue = experienceValue;
    }

    public abstract void tick(Player player);


    public void visit(Empty empty){
        empty.accept(this);
    }
    public void visit(Enemy enemy){
        enemy.accept(this);
    }
    public void visit(Wall wall){
        wall.accept(this);
    }
    public void visit(Player player){
        player.accept(player);
    }


    public int handleDeath(){ //need to remove enemy from board
        if (deathCallback != null) {
            deathCallback.call(this);
        }
        return experienceValue;
    }

    public void handleKill(int experienceValue){}
    @Override
    public void accept(Unit unit) {
        unit.attack(this);
        this.attack(unit);
    }

    public void setDeathCallback(EnemyDeathCallback deathCallback) {
        this.deathCallback = deathCallback;
    }

}
