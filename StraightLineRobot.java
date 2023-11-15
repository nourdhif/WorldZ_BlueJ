import java.util.Random;
/**
 * The StraightLineRobot moves in a straight line in a random direction.
 *
 * @author Nour Dorya DHIF
 * @version 02/11/2023
 */

public class StraightLineRobot extends Robot
{
    // instance variables
    int dir = 0;

    /**
     * Constructor for objects of class StraightLineRobot
     * 
     * @param  name       Sets the name of the robot
     * @param  xPosition  Sets its position on the x axis of the canvas
     * @param  yPosition  Sets its position on the y axis of the canvas
     * @param  w          Sets the world in which the robot will be added
     */
    public StraightLineRobot(String name, int xPosition, int yPosition, World w)
    {
        // initialise instance variables
        super(name, xPosition, yPosition, "BLUE", w);
        w.addRobots(this);
    }

    /**
     * Returns a random int between 0 and 3
     * 
     * @return  int
     */
    public int chooseRandomDirection()
    {
        Random rand = new Random();
        int randomDir = rand.nextInt(4);
        int newDir = randomDir;
        System.out.println(newDir);
        return newDir;
    }
    
    /**
     * Allows the robot to move in a straight line in a random direction
     * 
     * Overrides move() from Robot class
     */
    @Override
    public void move()
    {
        dir = chooseRandomDirection();
        switch(dir)
        {
            case 0 : moveUp(); break;
            case 1 : moveDown(); break;
            case 2 : moveLeft(); break;
            case 3 : moveRight();
        }
    }
    
    /**
     * Allows the robot to move up
     */
    public void moveUp() {
        setYPosition(getYPosition() -2);
        super.redraw();
    }
    
    /**
     * Allows the robot to move down
     */
    public void moveDown() {
        setYPosition(getYPosition() +2);
        super.redraw();
    }
    
    /**
     * Allows the robot to move left
     */
    public void moveLeft() {
        setXPosition(getXPosition() -2);
        super.redraw();
    }
    
    /**
     * Allows the robot to move right
     */
    public void moveRight() {
        setXPosition(getXPosition() +2);
        super.redraw();
    }
}
