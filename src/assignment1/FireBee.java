
package assignment1;

public class FireBee extends HoneyBee{
    private int attackRange;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public FireBee(Tile position, int attackRange) {
        super(position, BASE_HEALTH, BASE_COST);
        this.attackRange = attackRange;
    }

    @Override
    public boolean takeAction() {
        if(!getPosition().isOnThePath() && getPosition() == null){
            return false;
        }

        //Targets within range
        Tile target = getPosition();
        for (int i = 0; i < attackRange; i++) {
            target = target.towardTheNest();

            //Edge case
            if (target == null || target.isNest()) {
                break;
            }

            if (target.getNumOfHornets() > 0 && !target.isOnFire()) {
                target.setOnFire();
                return true;
            }
        }
        return false;
    }
}
