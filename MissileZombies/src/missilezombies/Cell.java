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
    
    public int eliminateZombies () {
        return zombies;
    }
    
    @Override
    public boolean equals(Object o) {
        Cell toCompare = (Cell) o;
        return position.equals(toCompare.position);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.position);
        return hash;
    }

}
