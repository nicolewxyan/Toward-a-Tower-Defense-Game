package assignment1;

public abstract class HoneyBee extends Insect{
    private int cost;
    public static double HIVE_DMG_REDUCTION;

    public HoneyBee(Tile position, int health, int cost) {
        super(position, health);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage;
        if(getPosition() != null && getPosition().isHive()){
            actualDamage = (int) (damage * (1 - HIVE_DMG_REDUCTION));
        }
        super.takeDamage(actualDamage);
    }
}
