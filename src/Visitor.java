public interface Visitor {
    void visit(Empty empty);
    void visit(Enemy enemy);
    void visit(Wall wall);
    void visit(Player player);
}
