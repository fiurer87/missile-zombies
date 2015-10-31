package missilezombies;

import java.awt.Point;
import java.util.Objects;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
class Cell {

    protected Point position;
    private int zombies;

    public Cell(int x, int y, int zombies) {
        position = new Point(x, y);
        this.zombies = zombies;
    }

    public int eliminateZombies(boolean clean) {
        int eliminated = zombies;
        if (clean) {
            zombies = 0;
        }
        return eliminated;
    }

    @Override
    public boolean equals(Object o) {
        Cell cell = (Cell) o;
        return position.x == cell.position.x && position.y == cell.position.y
                && zombies == zombies;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.position);
        hash = 61 * hash + this.zombies;
        return hash;
    }

    public int getZombies() {
        return zombies;
    }
}
