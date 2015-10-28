package missilezombies;

import java.awt.Point;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
public class AttackResult implements Comparable<AttackResult> {
    
    public final Missile missile;
    public final int zombies;
    
    public AttackResult(Missile missile, int zombies) {
        this.missile = missile;
        this.zombies = zombies;
    }

    @Override
    public int compareTo(AttackResult ar) {
        if ( zombies < ar.zombies ) return 1;
        if ( zombies > ar.zombies ) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", missile.arrivedPosition().x, 
                missile.arrivedPosition().y, zombies);
    }
}
