public class RightAction extends Action{
    @Override
    public void preform(Player p) {
        p.getPosition().setxAxis(p.getPosition().getxAxis()+1);
    }

}
