import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class DoorTest {
    @Before
    public void setup(){
        Door.pCount = 0;
        Door.up = false;
        //        boolean down =false;
        Door.paused = true;
        Door.str = new StringBuilder();
    }
    @Test
    public void testNormalOperation() {
//     test("should stay closed unless button is pressed (no buttonpresses)", "..........", "0000000000")
        assertEquals("0000000000", new Door().run(".........."));
    }
    @Test
    public void testNormalOpen() {
//     test("should start opening on buttonpress", "P..", "123");
        assertEquals("123", new Door().run("P.."));
    }
    @Test
    public void testNormalPress() {
//     test("should open completely and stay open", "P....", "12345");
        assertEquals("12345", new Door().run("P...."));
    }
    @Test
    public void testPause() {
//     test("should start opening and pause on second buttonpress", "P.P..", "12222");
        assertEquals("12222", new Door().run("P.P.."));
    }
    @Test
    public void testObstacles() {
        //test("should reverse while opening", "P.O....", "1210000");
        assertEquals("1210000", new Door().run("P.O...."));
    }
    @Test
    public void testExample() {
        // test("should start opening and reverse when obstacle", "..P...O.....", "001234321000");
        assertEquals("001234321000", new Door().run("..P...O....."));
    }
    //    private void test(String description,String events,String result) {
//        assertEquals(description,result,Door.run(events));
//    }
    @Test
    public void fullOpen() {
        //test("should open fully", "P.O....", "1210000");
        assertEquals("123455", new Door().run("P....."));
    }
    @Test
    public void fullClose() {
        //test("should open fully", "P.O....", "1210000");
        assertEquals("12345543210", new Door().run("P.....P...."));
    }
    @Test
    public void fullCloseWhichName() {
        //test("should open fully", "P.O....", "1210000");
        assertEquals("1234543210", new Door().run("P....P...."));
    }
    @Test
    public void hiddenTest() {
        //test("should open fully", "P.O....", "1210000");
        //                                                                     <0000012345554333321000>
        assertEquals("0000012345554333321000", new Door().run(".....P......P.P..P...."));
    }
}