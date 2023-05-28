public class Monster extends Enemy{
    private Integer visionRange;
    private Integer dx;
    private Integer dy;

    public Monster(char tile, String name, Integer healthPool, Integer healthAmount, Integer attackPoints, Integer defensePoints, Integer experienceValue, Integer visionRange) {
        super(tile, name, healthPool, healthAmount, attackPoints, defensePoints, experienceValue);
        this.visionRange = visionRange;
    }

    public void ChasePlayer(Player player){
        if(range(this, player) < visionRange){
            Integer Mx = this.getPosition().getxAxis();
            Integer My = this.getPosition().getyAxis();
            this.dx = Mx - player.getPosition().getxAxis();
            this.dy = My - player.getPosition().getyAxis();
            if(Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0)
                    this.getPosition().setxAxis(Mx-1); // Move left
                else
                    this.getPosition().setxAxis(Mx+1); // Move right
            }
            else if (dy > 0)
                this.getPosition().setyAxis(My+1); // Move up
            else
                this.getPosition().setyAxis(My-1); // Move down
        }
    }

}
