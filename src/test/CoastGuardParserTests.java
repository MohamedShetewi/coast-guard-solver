package test;

import code.Entity.Location;
import code.Problem.CoastGuardParser;
import code.Problem.CoastGuardState;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class CoastGuardParserTests {

    String problem1 = "3,4;97;1,2;0,1;3,2,65;";
    String problem2 = "3,4,97;1,2;0,1;3,2,65;";
    String problem3 = "3,4;97;1,2;0,1;3,65;";

    @Test
    public void testSimpleParsing() {
        CoastGuardParser parser = new CoastGuardParser(problem1);
        CoastGuardState initialState = null;
        try {
            initialState = parser.parse();
        } catch (Exception e) {
            fail("Test failed: " + e.getMessage());
        }
        Assert.assertEquals(initialState.getGridWidth(), 3);
        Assert.assertEquals(initialState.getGridHeight(), 4);

        Assert.assertEquals(initialState.getCoastGuardBoat().getMaxPassengersCapacity(), 97);
        Assert.assertEquals(initialState.getCoastGuardBoat().getLocation(), new Location(1, 2));

        Assert.assertEquals(initialState.getStationList().size(), 1);
        Assert.assertEquals(initialState.getStationList().get(0).getLocation(), new Location(0, 1));

        Assert.assertEquals(initialState.getShipList().size(), 1);
        Assert.assertEquals(initialState.getShipList().get(0).getLocation(), new Location(3, 2));
        Assert.assertEquals(initialState.getShipList().get(0).getPassengersCount(), 65);
    }

    @Test
    public void testInvalidFormat() {
        try {
            (new CoastGuardParser(problem2)).parse();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Invalid encoding format");
        }
    }

    @Test
    public void testInvalidShipFormat() {
        try {
            (new CoastGuardParser(problem3)).parse();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Invalid ships format");
        }
    }
}
