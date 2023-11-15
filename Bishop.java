import java.util.Random;
/**
 * The class that defines the attributes of the bishop robots and its methods.
 * This class extends the robot class.
 *
 * @author Titouan MONTBULEAU--GENTELET
 * @version 02.11.2023
 */
public class Bishop extends Robot
{
    /**
     * Bishop Constructor - Create a robot that can move diagonally in a random direction. 
     * If there is an obstacle, the robot stops. It travels a random number of squares 
     * between 1 and 5.
     * 
     * @param name the name of the robot
     * @param x,y the robot position
     * @param colourBody the robot colour
     * @param w the world the robot evolves in
     */
    public Bishop(String name, int x, int y, String colourBody, World w)
    {
       super(name,x,y,colourBody,w);  
       w.addRobots(this);
    }
    
    /**
     * Method move
     * 
     * Defines the movement of the robot, allowing it to move only diagonally and prevents him
     * from colliding with other robots
     * @Override
     */
    public void move(){
        //x,y current position of the robot
        int x = getXPosition();
        int y = getYPosition();
        //dir, nbSquare random numbers for a random direction and a random number of square
        this.randomDirection();
        int nbSquare = randomSquare();
        //nbSquare+1 => the random number can be 0,1,2,3,4. And the robot has to move between
        // 1 and 5 squares
        for (int i=0;i<(nbSquare+1);i++)
        {
            //randomDirection()=> 0,1,2,3 each one corresponds to a specific direction
            switch(getDirection())
            {
                    case 0:
                        //The robot cannot move in a direction if it is already at the limit
                        if(!(x==getMinPosition() || y==getMaxPosition()))
                        {
                            x-=1;
                            y+=1;
                            break;
                        }
                        //if it is at the limit, the robot stops
                        else
                            break;
                    case 1:
                        if(!(x==getMaxPosition() || y==getMaxPosition()))
                        {
                            x+=1;
                            y+=1;
                            break;
                        }
                        else
                            break;
                    case 2:
                        if(!(x==getMaxPosition() || y==getMinPosition()))
                        {
                            x+=1;
                            y-=1;
                            break;
                        }
                        else
                            break;
                    case 3:
                        if(!(x==getMinPosition() || y==getMinPosition()))
                        {
                            x-=1;
                            y-=1;
                            break;
                        }
                        else
                            break;
            }
        }
        //Check if the square is available, if there is no robot already at this position
        //If the square is available, x,y positions are set and the robot is redrawed.
        if(!getWorld().isRobotAtPosition(x,y))
        {
            setXPosition(x);
            setYPosition(y);
            redraw();
        }
    }
    
    /**
     * Method randomSquare
     * 
     * Pick a random number between 0 and 4, corresponding to the number of squares the robot
     * will move (minus 1).
     *
     *
     * @return the number of squares the robot will move (minus 1). The plus 1 is added in the
     * move() method.
     */
    private int randomSquare(){
        Random rnd = new Random();
        int square = rnd.nextInt(5);
        return square;
    }
}