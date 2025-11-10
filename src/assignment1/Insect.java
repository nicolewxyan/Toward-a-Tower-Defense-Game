package assignment1;
import java.util.Objects;

public abstract class Insect {
    private Tile position;
    private int health;

    public Insect(Tile position, int health) {
        if(position != null && !position.addInsect(this)) {
            throw new IllegalArgumentException("Cannot add insect to the  tile");
        }
        this.position = position;
        this.health = health;
    }

    public final Tile getPosition() {
        return position;
    }

    public final int getHealth() {
        return health;
    }

    public void setPosition(Tile position) {
        this.position = position;
    }

    public void takeDamage(int damage){
        health -= damage;
        if(health <= 0){
            if(position != null){
                position.removeInsect(this);
            }
        }
    }

    public abstract boolean takeAction();


    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insect insect = (Insect) o;
        return health == insect.health && Objects.equals(position, insect.position);
    }


    public void regenerateHealth(double percentage){
        int increase = (int) (this.health * percentage);
        this.health += increase;
    }
}


