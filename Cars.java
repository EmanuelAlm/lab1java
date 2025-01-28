import java.awt.*;

// Reason for choosing abstract(subclassing) instead of interfaces:
// To be able to implement variables that are common between the cars but don't have the same value
// (using interfaces the variables declared will be static and final)
public abstract class Cars implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    protected double[] pos;
    protected int[] direction;


    public Cars(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;

        // Always initialize pos and direction to default values
        this.pos = new double[]{0, 0};    // Initial position (x = 0, y = 0)
        this.direction = new int[]{0, 1}; // Initial direction (facing upward)

        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    @Override
    public void move() {
        pos[0] += getCurrentSpeed() * direction[0];
        pos[1] += getCurrentSpeed() * direction[1];
    }

    @Override
    public void turnLeft() {
        direction
    }

    @Override
    public void turnRight() {

    }
}

[0,1]
// left

[-1,0]

// left

[0,-1]

// left

[1,0]



