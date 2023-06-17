import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player extends Unit{

    private static final Integer LEVELUP = 50;
    private static final Integer HEALTHPOOLUP = 10;
    private static final Integer ATTACKUP = 4;
    private static final Integer DEFENSEUP = 1;

    private List<Enemy> enemies;
    private Integer experience;
    private Integer level;
    private String specialAbility;

    private MessageCallback m;
    private InputReader r;



    private final Map<String, Action> moves = new HashMap<>() {{
        put("d", new RightAction());
        put("s", new DownAction());
        put("a", new LeftAction());
        put("w", new UpAction());
        put("e", new AbilityAction());
        put("q", new NoAction());
    }};


    public Player(String name, Integer healthPool, Integer healthAmount , Integer attackPoints, Integer defensePoints,String specialAbility) {
        super('@', name, healthPool, healthAmount, attackPoints, defensePoints);
        this.experience = 0;
        this.level = 1;
        this.specialAbility = specialAbility;
    }

    public void initialize(MessageCallback m, InputReader r){
        this.m = m;
        this.r = r;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void levelUp(){
    this.experience = this.experience - (level*LEVELUP);
    this.level = level + 1;
    setHealthPool((getHealthPool() + (level*HEALTHPOOLUP)));
    setHealthAmount(getHealthPool());
    setAttackPoints(getAttackPoints() + (level*ATTACKUP));
    setDefensePoints(getDefensePoints() + (level*DEFENSEUP));
    }

    public void handleKill(int experienceValue){
        this.addExperience(experienceValue);

    }

    public int handleDeath(){
        this.setTile('X');
        m.send("X-X");
        return -1;
    }

    public void abilityCast() {
    }

    public boolean isAlive(){
        return getHealthAmount() > 0;
    }

    public void accept(Unit unit) {
        unit.attack(this);
        this.attack(unit);
    }


    public void tick(){
        String command = r.readInput();
        switch(command){
            case "w":
                moveUp();
                this.handleTick();
                break;
            case "s":
                moveDown();
                this.handleTick();
                break;
            case "d":
                moveRight();
                this.handleTick();
                break;
            case "a":
                moveLeft();
                this.handleTick();
                break;
            case "q":
                this.handleTick();
                break;
            case "e":
                abilityCast();
                break;
            default:
                System.out.println("Pls enter a valid move");
                tick();
        }
    }

    public abstract void handleTick();

    public void visit(Empty empty){

    }
    public void visit(Enemy enemy){

    }
    public void visit(Wall wall){

    }
    public void visit(Player player){

    }

    public void addExperience(int experience){
        this.experience = this.experience + experience;
        if(this.experience >= (level*LEVELUP))
            roleLevelUp();
    }

    public String getPlayerDetails() {
        return String.format("Health: %d/%d\tAttack: %d\tDefense: %d\tLevel: %d\tExperience: %d/%d",
                getHealthAmount(), getHealthPool(), getAttackPoints(), getDefensePoints(), getLevel(), getExperience(), 50);
    }

    public abstract void roleLevelUp();

    public Integer getExperience() {
        return experience;
    }

    public Integer getLevel() {
        return level;
    }







    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

}
