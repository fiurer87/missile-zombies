package missilezombies;

import java.awt.Point;
import java.util.Objects;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
public class AttackResult {

    private final int zombies;
    private final Point position;

    public AttackResult(Point position, int zombies) {
        this.position = position;
        this.zombies = zombies;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", position.x, position.y, zombies);
    }

    @Override
    public boolean equals(Object o) {
        AttackResult ar = (AttackResult) o;
        return (position.x == ar.position.x && position.y == ar.position.y
                && zombies == ar.zombies);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.zombies;
        hash = 29 * hash + Objects.hashCode(this.position);
        return hash;
    }

}
