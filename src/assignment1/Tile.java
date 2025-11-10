
package assignment1;

public class Tile {
    private int food;
    private boolean isHive; //indicating bee hive built or not
    private boolean isNest; //indicating hornet nest built or not
    private boolean onThePath;
    private Tile towardTheHive;
    private Tile towardTheNest;
    private HoneyBee bee;
    private SwarmOfHornets swarm;
    private boolean onFire;

    public Tile() {
        this.food = 0;
        this.isHive = false;
        this.isNest = false;
        this.onThePath = false;
        this.towardTheHive = null;
        this.towardTheNest = null;
        this.bee = null;
        this.swarm = new SwarmOfHornets();
        this.onFire = false;
    }

    public Tile(int food, boolean isHive, boolean isNest,
                boolean onThePath, Tile towardTheHive,
                Tile towardTheNest, HoneyBee bee,
                SwarmOfHornets swarm) {
        this.food = food;
        this.isHive = isHive;
        this.isNest = isNest;
        this.onThePath = onThePath;
        this.towardTheHive = towardTheHive;
        this.towardTheNest = towardTheNest;
        this.bee = bee;
        this.swarm = (swarm != null) ? swarm : new SwarmOfHornets();
    }

    public boolean isHive(){
        return isHive;
    }

    public boolean isNest(){
        return isNest;
    }

    public void buildHive(){
        this.isHive = true;
    }

    public void buildNest(){
        this.isNest = true;
    }

    public boolean isOnThePath(){
        return onThePath;
    }

    public Tile towardTheHive(){
        if(!onThePath || isHive) {
            return null;
        }
        return towardTheHive;
    }

    public Tile towardTheNest(){
        if(!onThePath || isNest) {
            return null;
        }
        return towardTheNest;
    }

    public void createPath(Tile towardTheHive, Tile towardTheNest){

        if ((!isHive && towardTheHive == null) || (!isNest && towardTheNest == null)) {
            throw new IllegalArgumentException("Invalid path");
        }

        this.towardTheHive = towardTheHive;
        this.towardTheNest = towardTheNest;
        this.onThePath = true;
    }

    public int collectFood(){
        int collectedFood = this.food;
        this.food = 0;
        return collectedFood;
    }

    public void storeFood(int foodReceived){
        this.food += foodReceived;
    }

    public int getNumOfHornets(){
        return swarm.sizeOfSwarm();
    }

    public HoneyBee getBee() {
        return bee;
    }

    public Hornet getHornet(){
        return swarm.getFirstHornet();
    }

    public Hornet[] getHornets(){
        return swarm.getHornets();
    }

    public boolean addInsect(Insect insect){
        if(insect == null) return false;

        //Honeybee
        insect.setPosition(this);
        if(insect instanceof HoneyBee){
            if((bee != null && bee != insect) || isNest){
                insect.setPosition(null);
                return false;
            }
            this.bee = (HoneyBee) insect;
            return true;
        }

        //Hornet
        else if(insect instanceof Hornet){
            if(!onThePath){
                insect.setPosition(null);
                return false;
            }
            swarm.addHornet((Hornet) insect);
            return true;
        }
        return false;
    }


    public boolean removeInsect(Insect insect){
        if(insect == null) return false;

        if(insect instanceof HoneyBee && this.bee == insect){
            insect.setPosition(null);
            this.bee = null;
            return true;
        } else if (insect instanceof Hornet){
            if(swarm.removeHornet((Hornet) insect)){
                insect.setPosition(null);
                return true;
            }
            return false;
        }
        return false;
    }

    public void setOnFire(){
        this.onFire = true;
    }

    public boolean isOnFire(){
        return onFire;
    }
}


