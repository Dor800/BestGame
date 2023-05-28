public class Warrior extends Player{
    private Integer abilityCooldown;
    private Integer remainingCooldown;

    public Warrior(char tile, String name, Integer healthPool, Integer healthAmount, Integer attackPoints, Integer defensePoints, Integer experience, Integer level, String specialAbility, Integer abilityCooldown, Integer remainingCooldown) {
        super(tile, name, healthPool, healthAmount, attackPoints, defensePoints, experience, level, specialAbility);
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = remainingCooldown;
    }
}
