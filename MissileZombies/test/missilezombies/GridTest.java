package missilezombies;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
public class GridTest {

    private Grid proposalGrid;

    @Before
    public void setUp() {
        proposalGrid = new Grid(10, 8);
        proposalGrid.addZombiesCell(3, 3, 4);
        proposalGrid.addZombiesCell(2, 3, 3);
        proposalGrid.addZombiesCell(4, 2, 2);
        proposalGrid.addZombiesCell(5, 1, 3);
        proposalGrid.addZombiesCell(5, 5, 6);
        proposalGrid.addZombiesCell(8, 6, 4);
    }

    @Test
    public void testBasicGridWithoutZombies() {
        int witdh = 1;
        int height = 1;
        //Coordinates for the missile impact
        int x = 1;
        int y = 1;

        Grid grid = new Grid(witdh, height);
        Missile missile = new Missile(x, y, grid);
        AttackResult result = grid.potentialResult(missile);
        AttackResult expected = new AttackResult(missile, 0);
        Assert.assertEquals(expected, result);
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

        Missile missile = new Missile(x, y, grid);
        AttackResult result = grid.potentialResult(missile);
        AttackResult expected = new AttackResult(missile, zombies);

        Assert.assertEquals(expected, result);
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

        Missile missile = new Missile(x, y, grid);
        AttackResult result = grid.potentialResult(missile);
        AttackResult expected = new AttackResult(missile, zombies);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testProposalInputOutputInExercises() {

        //Fixed value, the original value is 4 but is an error in X coordinate
        Missile missile1 = new Missile(5, 3, proposalGrid);
        AttackResult expected = new AttackResult(missile1, 15);
        AttackResult result = proposalGrid.potentialResult(missile1);
        Assert.assertEquals(expected, result);

        Missile missile2 = new Missile(8, 6, proposalGrid);
        expected = new AttackResult(missile2, 4);
        result = proposalGrid.potentialResult(missile2);
        Assert.assertEquals(expected, result);

        Missile missile3 = new Missile(10, 3, proposalGrid);
        expected = new AttackResult(missile3, 3);
        result = proposalGrid.potentialResult(missile3);
        Assert.assertEquals(expected, result);
    }

}
