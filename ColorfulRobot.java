import java.util.Random;

/**
 * The ColorfulRobot changes color everytime it moves and it moves in rectangle.
 *
 * @author Mélany LEFEVRE--ROMY
 * @version 30/10/2023
 */

public class ColorfulRobot extends Robot
{
    // instance variables - replace the example below with your own
    private static final String colors[] = {"RED", "BLACK", "BLUE", "YELLOW", "GREEN", "MAGENTA", "WHITE", "PURPLE", "PINK", "LIME", "ORANGE"};
        
    /**
     * Constructor for objects of class ColorfulRobot
     * 
     * @param  name       Sets the name of the robot
     * @param  xPosition  Sets its position on the x axis of the canvas
     * @param  yPosition  Sets its position on the y axis of the canvas
     * @param  w          Sets the world in which the robot will be added
     * 
     */
    public ColorfulRobot(String name, int xPosition, int yPosition, World w)
    {
        // initialise instance variables
        super(name, xPosition, yPosition, "BLACK", w);
        w.addRobots(this);
        this.getCanvasRobot().setColourHead("ORANGE");
        this.getCanvasRobot().setColourEye("PURPLE");
    }
    
    /**
     * Returns a random color
     * 
     * @return  String
     */
    public String randomColor()
    {
        Random rand = new Random();
        int randomColorNb = rand.nextInt(colors.length);
        String newColor = colors[randomColorNb];
        return newColor;
    }

    /**
     * Allows the robot to move in a rectangle
     * 
     * Overrides move() from Robot class
     */
    @Override
    public void move()
    {
        for (int i=0; i<3; i++) {
            moveRight();
            moveSleep();
        }
        for (int i=0; i<2; i++) {
            moveDown();
            moveSleep();
        }
        for (int i=0; i<3; i++) {
            moveLeft();
            moveSleep();
        }
        for (int i=0; i<2; i++) {
            moveUp();
            moveSleep();
        }
    }
    
    /**
     * Allows a break between every single movement
     */
    public void moveSleep()
    {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Changes the color of the body, head and eyes of the robot to a random color
     */
    public void colorChangeEverything()
    {
        this.getCanvasRobot().setColourBody(randomColor());
        this.getCanvasRobot().setColourHead(randomColor());
        this.getCanvasRobot().setColourEye(randomColor());
        super.redraw();
    }
    
    /**
     * Allows the robot to move up
     */
    public void moveUp() {
        setYPosition(getYPosition() - 1);
        colorChangeEverything();
    }

    /**
     * Allows the robot to move down
     */
    public void moveDown() {
        setYPosition(getYPosition() + 1);
        colorChangeEverything();
    }

    /**
     * Allows the robot to move left
     */
    public void moveLeft() {
        setXPosition(getXPosition() - 1);
        colorChangeEverything();
    }

    /**
     * Allows the robot to move right
     */
    public void moveRight() {
        setXPosition(getXPosition() + 1);
        colorChangeEverything();
    }
}