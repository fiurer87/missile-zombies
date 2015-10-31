package missilezombies;

import java.awt.Point;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
public class AttackResult implements Comparable<AttackResult> {

    private final Missile missile;
    private final int zombies;
    private Point position;

    public AttackResult(Missile missile, int zombies) {
        this.missile = missile;
        this.zombies = zombies;
        this.position = new Point();
    }
    
    public AttackResult(Point position, int zombies) {
        this.position = position;
        this.zombies = zombies;
        this.missile = null;
    }

    @Override
    public int compareTo(AttackResult ar) {
        if (zombies > ar.zombies) {
            return 1;
        }
        if (zombies < ar.zombies) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        if (missile == null) {
            return String.format("%d %d %d", position.x, position.y, zombies);
        }
        return String.format("%d %d %d", missile.arrivedPosition().x,
                missile.arrivedPosition().y, zombies);
    }

    public boolean hasZombiesAttacked() {
        return zombies > 0;
    }

    public Missile getMissile() {
        return missile;
    }

    @Override
    public boolean equals(Object o) {
        AttackResult ar = (AttackResult) o;
        if (missile == null) {
            return this.compareTo(ar) == 0;
        }
        return (position.x == ar.position.x && position.y == ar.position.y 
                && zombies == ar.zombies);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.zombies;
        return hash;
    }
}
