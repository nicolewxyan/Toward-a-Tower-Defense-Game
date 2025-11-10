package assignment1;

public class Hornet extends Insect{

    public static void main(String[] args) {
        /*
        Hornet hornet = new Hornet(null, 5, 2);

        var tempTile = new Tile();
        hornet.setPosition(tempTile);
        var temp = hornet.getPosition();
        */
    }

    private int attackDamage;
    public static int BASE_FIRE_DMG = 1;
    private boolean isTheQueen;
    private static int numOfQueens = 0;

    public Hornet(Tile position, int health, int attackDamage) {
        super(position, health);
        this.attackDamage = attackDamage;
        this.isTheQueen = false;
        if (position != null) {
            position.addInsect(this);
        }
    }

    @Override
    public boolean takeAction() {
        int actions = isTheQueen ? 2 : 1;

        HoneyBee bee = getPosition().getBee();

        for (int i = 0; i < actions; i++) {
            if (getPosition().isOnFire() && getPosition() != null) {
                this.takeDamage(BASE_FIRE_DMG);
            }
        }

        //Hornet on bee hive and no bee left on tile
        if(getPosition().isHive() && bee == null)
            return false;

        //Bee on tile
        if(bee != null){
            bee.takeDamage(attackDamage);
            return true;
        } else {
            Tile nextTile = getPosition().towardTheHive();
            if(nextTile != null){
                getPosition().removeInsect(this);
                if(nextTile.addInsect(this)){
                    setPosition(nextTile);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hornet hornet = (Hornet) o;
        return attackDamage == hornet.attackDamage;
    }


    public boolean isTheQueen() {
        return isTheQueen;
    }


    public void promote(){
        if (numOfQueens == 0) {
            numOfQueens++;
            isTheQueen = true;
        }
    }
}
