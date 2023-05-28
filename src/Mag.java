public class Mag extends Player{
    private Integer manaPool;
    private Integer currentMana;
    private Integer manaCost;
    private Integer spellPower;
    private Integer hitsCount;
    private Integer abilityRange;

    public Mag(char tile, String name, Integer healthPool, Integer healthAmount, Integer attackPoints, Integer defensePoints,
               Integer experience, Integer level, String specialAbility, Integer manaPool, Integer currentMana,
               Integer manaCost, Integer spellPower, Integer hitsCount, Integer abilityRange)
    {
        super(tile, name, healthPool, healthAmount, attackPoints, defensePoints, experience, level, specialAbility);
        this.manaPool = manaPool;
        this.currentMana = currentMana;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
    }





}
