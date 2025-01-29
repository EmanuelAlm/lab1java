import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

public class TestSaab {

    @Test
    public void testConstructor() {
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
        assertEquals(Color.red, saab.getColor());
        assertEquals(125, saab.getEnginePower(), 0.0);
        assertFalse(saab.getTurboStatus());
        assertEquals(0, saab.getCurrentSpeed(), 0.0);
        assertEquals(0,saab.getPos()[0],0.0);
        assertEquals(0,saab.getPos()[1],0.0);
        assertEquals(0 ,saab.getDirection()[0]);
        assertEquals(1 ,saab.getDirection()[1]);

    }

    @Test
    public void testColor(){
        Saab95 saab = new Saab95();
        saab.setColor(Color.blue);
        assertEquals(Color.blue,saab.getColor());
    }
    @Test
    public void testEngine(){
        Saab95 saab = new Saab95();
        saab.startEngine();
        assertEquals(0.1, saab.currentSpeed, 0.0);
        saab.stopEngine();
        assertEquals(0, saab.currentSpeed, 0.0);
    }

    @Test
    public void testTurbo(){
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertTrue(saab.getTurboStatus());
        saab.setTurboOff();
        assertFalse(saab.getTurboStatus());
    }

    @Test
    public void testSpeedFactor(){
        Saab95 saab = new Saab95();
        assertEquals(1.25,saab.speedFactor(), 0.0);
        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor(), 0.0);
    }

    @Test
    public void testGas(){
        Saab95 saab = new Saab95();
        saab.startEngine();
        double startSpeed = saab.getCurrentSpeed();
        saab.gas(0.3);
        assertTrue(saab.getCurrentSpeed() > startSpeed);

    }

    @Test
    public void testBrake (){
        Saab95 saab = new Saab95();
        saab.startEngine();
        double startSpeed = saab.getCurrentSpeed();
        saab.brake(0.1);
        assertTrue(saab.getCurrentSpeed() < startSpeed);
    }

    @Test
    public void testSpeedAmount() {
        Saab95 saab = new Saab95();

        saab.currentSpeed = saab.getEnginePower();
        saab.gas(1.0);

        assertEquals(saab.getCurrentSpeed(), saab.getEnginePower(), 0.0);

        saab.currentSpeed = 0;
        saab.brake(1.0);

        assertEquals(0, saab.getCurrentSpeed(), 0.0);
    }

}
