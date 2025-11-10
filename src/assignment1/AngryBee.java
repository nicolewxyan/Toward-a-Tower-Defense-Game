package assignment1;

public class AngryBee extends HoneyBee{
    private int attackDamage;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public AngryBee(Tile position, int attackDamage) {
        super(position,BASE_HEALTH, BASE_COST);
        this.attackDamage = attackDamage;
    }



    @Override
    public boolean takeAction() {
        //Check if on the path
        if (getPosition() == null || !getPosition().isOnThePath() || getPosition().isNest()) {
            return false;
        }

            //Non-Empty swarm: Same Tile
            if (getPosition().getNumOfHornets() > 0) {
                getPosition().getHornet().takeDamage(attackDamage);
                    return true;
            } else {

            //None empty swarm: Next Tile
            Tile nextTile = getPosition().towardTheNest();
            if (nextTile != null && !nextTile.isNest() && nextTile.getNumOfHornets() > 0) {
                nextTile.getHornet().takeDamage(attackDamage);
                return true;
            }
        }
        return false;
    }
}
