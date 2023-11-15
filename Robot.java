import java.util.Random;

/**
 * The class Robot allows the user to create a Robot.
 * A robot can move and the color of his body can be set.
 * A robot has a position defined by x,y and evolve in one world.
 * It is drawn by CanvasRobot.
 *
 * @author Group13
 * @version 10/2023
 */
public class Robot 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int xPosition;
    private int yPosition;
    private int direction = 0;
    private String name ;
    private static int numero = 0 ;
    private static int MIN_NAME_LENGTH = 3;
    private static int MIN_POSITION = 0;
    private static int MAX_POSITION = 11;
    private CanvasRobot canvasRobot;
    private String colourBody;
    private World world;
    
    /**
     * Robot Constructor - Creates a new robot.
     * The robot is drawn with a new CanvasRobot.
     * 
     * @param name  the name of the Robot
     * @param color the color of the body
     * 
     */
    public Robot(String name, String color){ 
        setName(name);
        color = color.toUpperCase();
        setColourBody(color);
        canvasRobot = new CanvasRobot(this.colourBody);
        canvasRobot.drawRobot(xPosition,yPosition);
        direction=0;
    }
    
    /**
     * Robot Constructor - Creates a new robot.
     * The robot is drawn with a new CanvasRobot.
     * 
     * @param name  the name of the Robot
     * @param x,y   position of the Robot
     * @param color the color of the body
     * @param w     world where the robot exists
     * 
     */
    public Robot(String name, int x , int y, String color, World w){ 
        setName(name);
        setXPosition(x);
        setYPosition(y);
        color = color.toUpperCase();
        setColourBody(color);
        direction=0;
        canvasRobot = new CanvasRobot(this.colourBody);
        canvasRobot.drawRobot(xPosition,yPosition);
        world = w;
    }
    
    /**
     * Set the Y position of the robot.
     * If the position if too big, the position is set to the maximum position
     * If the position if too little, the position is set to the minimum position
     * 
     * @param  y   vertical position of the robot
     */ 
    public void setYPosition (int y){
        if (y > MAX_POSITION)
            yPosition = MAX_POSITION;
        else if (y < MIN_POSITION)
            yPosition = MIN_POSITION;
        else
            yPosition = y;
    }
    
    /**
     * Set the X position of the robot.
     * If the position if too big, the position is set to the maximum position
     * If the position if too little, the position is set to the minimum position
     * 
     * @param  x   horizontal position of the robot
     */
    public void setXPosition (int x){
        if (x > MAX_POSITION)
            xPosition = MAX_POSITION;
        else if (x < MIN_POSITION)
            xPosition = MIN_POSITION;
        else
            xPosition = x;
    }
    
    /**
     * Get the Y position of the robot.
     * 
     * @return  the Y position of the Robot
     */
    public int getYPosition(){
        return yPosition ;
    }

    /**
     * Get the X position of the robot.
     * 
     * @return  the X position of the Robot
     */
    public int getXPosition(){
        return xPosition;
    }
    
    /**
     * Set the direction of the robot.
     * 
     * @param  d  direction of the robot
     */
    public void setDirection(int d)
    {
        direction = d;
    }
    
    /**
     * Get the direction of the robot.
     * 
     * @return  The direction of the robot
     */
    public int getDirection()
    {
        return direction;        
    }
    
    /**
     * Get the world of the robot.
     * 
     * @return  The world of the robot
     */
    public World getWorld()
    {
        return world;
    }
    
    /**
     * Set the name of the robot.
     * The spaces in the name are deleted.
     * If the name of the robot is long enought, the new name is set.
     * Else, a automatic name is set.
     * 
     * @param name  new name of the robot
     * 
     */
    public void setName(String name){
        name = name.trim() ;
        if ( name.length() >= MIN_NAME_LENGTH ){
        name = name ;    
        }
        else {
        numero++ ;    
        String tempname= "iRobot"+ numero ;
        name = tempname ;
        }
    }
    
    /**
     * Get the name of the robot.
     * 
     * @return  The name of the robot
     */
    public String getName()
    {
        return name ;
    }

    /**
     * Get the color of the robot.
     * 
     * @return  The color of the robot
     */
    public String getColourBody()
    {
        return this.colourBody;
    }
    
    /**
     * Get the canvasRobot of the robot.
     * 
     * @return  The canvasRobot of the robot
     */
    public CanvasRobot getCanvasRobot(){
        return this.canvasRobot;
    }
    
    /**
     * Set the color of the body of the robot.
     * Check if the new color exists.
     * If not, the color is set to blue.
     * 
     * @param colourBody    the color of the robot
     */
    public void setColourBody(String colourBody)
    {
        if (isColourFound(colourBody))
        {    
            this.colourBody = colourBody; 
        }
        else
        {
            this.colourBody = "BLUE"; 
            
        }
    }    
    
    /**
     * Set the color of the head of the robot.
     * Check if the new color exists.
     * If not, the color is set to red.
     * 
     * @param colourHead    the color of the head of the robot
     */
    public void setColourHead(String colourHead)
    {
        if (isColourFound(colourHead))
        { 
            canvasRobot.setColourHead(colourHead);
        }
        else
        {
            canvasRobot.setColourHead("RED");
        }
    }   
    
    /**
     * Set the color of the eyes of the robot.
     * Check if the new color exists.
     * If not, the color is set to blue.
     * 
     * @param colourEye    the color of the eyes of the robot
     */
    public void setColourEye(String colourEye)
    {
        if (isColourFound(colourEye))
        { 
            canvasRobot.setColourEye(colourEye);
        }
        else
        {
            canvasRobot.setColourEye("GREEN");
        }
    } 
    
    /**
     * Check if the color exists
     * Set the color to upper case
     * Check in the list of colors if the color is present
     * Return true if the color exists
     * 
     * @param newColor  the new color wanted
     * @return          true if the color exists, else, false
     */
    public boolean isColourFound(String newColor)
    {
        newColor = newColor.toUpperCase();
        for (Colour c : Colour.values()) 
        { 
            if (c.name().equals(newColor)) 
            { 
                return true;
            }   
        } 
        return false;
    }
    
    /**
     * The movement of the robot.
     * The robot increases its x and y position.
     * It is the movement by default.
     * The robot is redrawn at this position.
     */
    public void move() 
    {
        if (xPosition < MAX_POSITION && yPosition < MAX_POSITION ) {
        
            yPosition ++;
            xPosition ++;
            canvasRobot.drawRobot(xPosition,yPosition);
    
        }

    }
    
    /**
     * The robot is redrawn at the new position.
     * 
     */
    public void redraw()
    {
        canvasRobot.drawRobot(xPosition,yPosition);
    }
    
    /**
     * Check if the robot is on a border.
     * 
     * @param value the coordinate to check
     * @return      true if the robot is on border, else, false
     */
    public boolean isOnBorder(int value)
    {
        if (value == MAX_POSITION || value == MIN_POSITION)
            return true;
        else
            return false;
    }
    
    /**
     * Get the maximum position.
     * It is a static method.
     * 
     * @return  the maximum position
     * 
     */
    public static int getMaxPosition()
    {
        return MAX_POSITION;
    }
    
    /**
     * Get the minimum position.
     * It is a static method.
     * 
     * @return  the minimum position
     * 
     */
    public static int getMinPosition()
    {
        return MIN_POSITION;
    }
    
    /**
     * Set a random direction to the robot.
     * Pick a random value between 0 and 3.
     * This value is assigned to the direction of the robot.
     * 
     */
    public void randomDirection (){
         Random rand = new Random(); 
         int step = rand.nextInt(4);
         this.setDirection(step);
    }
    
    
}