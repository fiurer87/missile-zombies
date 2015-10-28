package missilezombies;

import org.junit.Assert;
import org.junit.Test;

/**
 *
* @author Luis Roberto <luis.robertop87@gmail.com>
 */
public class GridTest {
    
    @Test
    public void testBasicGridWithoutZombies() {
        int witdh = 1;
        int height = 1;
        //Coordinates for the missile impact
        int x = 1;
        int y = 1;

        Grid grid = new Grid(witdh, height);
        Missile missile = new Missile(x, y);
        int zombiesDestroyed = grid.receiveImpactWith(missile);
        int expectedZombiesDestroyed = 0;
        Assert.assertEquals(expectedZombiesDestroyed, zombiesDestroyed);
    }
    
    @Test
    public void testBasicGridWithOneZombie() {
        int witdh = 1;
        int height = 1;
        
        //Coordinates for the missile impact
        int x = 1;
        int y = 1;

        int zombies = 1;

        Grid grid = new Grid(witdh, height);
        grid.addZombiesCell(x, y, zombies);

        Missile missile = new Missile(x, y);
        int zombiesDestroyed = grid.receiveImpactWith(missile);
        int expectedZombiesDestroyed = zombies;
        Assert.assertEquals(expectedZombiesDestroyed, zombiesDestroyed);
    }
    
    @Test
    public void testBasicGridWithOneZombie2x2() {
        int witdh = 2;
        int height = 2;
        
        //Coordinates for the missile impact
        int x = 1;
        int y = 1;

        int zombies = 1;

        Grid grid = new Grid(witdh, height);
        grid.addZombiesCell(2, 2, zombies);

        Missile missile = new Missile(x, y);
        int zombiesDestroyed = grid.receiveImpactWith(missile);
        int expectedZombiesDestroyed = zombies;
        Assert.assertEquals(expectedZombiesDestroyed, zombiesDestroyed);
    }
    
    @Test
    public void testComplexGrid10x8() {
        int witdh = 10;
        int height = 8;
        
        //Coordinates for the missile impact
        int x = 8;
        int y = 6;

        Grid grid = new Grid(witdh, height);
        grid.addZombiesCell(3, 3, 4);
        grid.addZombiesCell(2, 3, 3);
        grid.addZombiesCell(4, 2, 2);
        grid.addZombiesCell(5, 1, 3);
        grid.addZombiesCell(5, 5, 6);
        grid.addZombiesCell(8, 6, 4);
        

        Missile missile = new Missile(x, y);
        int zombiesDestroyed = grid.receiveImpactWith(missile);
        int expectedZombiesDestroyed = 4;
        Assert.assertEquals(expectedZombiesDestroyed, zombiesDestroyed);
    }
    
}
