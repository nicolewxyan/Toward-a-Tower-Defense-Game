package assignment1;

public class SniperBee extends HoneyBee{
    private int attackDamage;
    private int piercingPower;
    public static int BASE_HEALTH;
    public static int BASE_COST;
    private boolean isAiming;

    public SniperBee(Tile position, int attackDamage, int piercingPower) {
        super(position, BASE_HEALTH, BASE_COST);
        this.piercingPower = piercingPower;
        this.attackDamage = attackDamage;
        this.isAiming = true;
    }

    @Override
    public boolean takeAction() {
        if(!getPosition().isOnThePath() || getPosition() == null){
            return false;
        }

        if (isAiming) {
            isAiming = false;
            return false; // Still aiming, no action taken
        } else {
            isAiming = true;

            // Find the first non-empty swarm along the path to nest
            Tile target = getPosition().towardTheNest();
            while (target != null && !target.isNest()) {
                if (target.getNumOfHornets() > 0) {
                    Hornet[] hornets = target.getHornets();
                    int hornetsToAttack = Math.min(piercingPower, hornets.length);
                    for (int i = 0; i < hornetsToAttack; i++) {
                        hornets[i].takeDamage(attackDamage);
                    }
                    return true;
                }
                target = target.towardTheNest();
            }
            return false;
        }
    }
}
