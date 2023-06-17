public class UpAction extends Action{
    @Override
    public void preform(Player p) {
        p.getPosition().setyAxis(p.getPosition().getyAxis()+1);
    }

}
