import java.util.ArrayList;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
/**
 * Décrivez votre classe WORLD ici.
 *
 * @author Group13
 * @version 10/2023
 */
public class World
{
   // Our world is described as an array list of robots
    public ArrayList<Robot> robots;
   // We want to give the possiblity to the user to set a maximum number of robots
    private int maxRobots; 
    private static int MIN_POSITION = 0;
    private static int MAX_POSITION = 11;

    /**
     * Constructor for objects of class World
     */
    public World()
    {
        robots = new ArrayList<Robot>();
        
        maxRobots = 10;
    }

    /**
     * Add a new robot
     * @param  Robot - The new Robot to add
     */
    //The method to add a robot in the array list (in the world)
    public void addRobots(Robot robot)
    {
        /*if(numberOfRobots()<maxRobots){*/
            if (robot.getWorld() == this) {
                robots.add(robot);
            }
        /*}
        
        else{
            System.out.println("Le nombre de robots maximal est atteint.");
            System.exit(0);
        }*/
        
    }
    
    /**
     * Delete a robot in the world
     * @param  Robot - The robot to remove
     */
    //The method to delete a robot in the world (=remove a robot in the array list)
    public void delRobots(Robot robot)
    {
        robots.remove(robot);
    }
    
    /**
     * Méthode verifPlace
     *
     * @param x Un paramètre
     * @param y Un paramètre
     * @return La valeur de retour
     */
    //Method to verify that a robot does not have a collision with another robot
    public boolean verifPlace(int x, int y){
        if((x<=MAX_POSITION)&&(x>=MIN_POSITION)&&(y<=MAX_POSITION)&&(y>=MIN_POSITION)){
            for(Robot r:robots){
                if((x==r.getXPosition())
                &&(y==r.getYPosition())){
                return true; 
                }
            }
        }
        else{
            return true;
        }
        return false;
    } 
    
    /**
     * Display the actually number of robots
     * @return The number of robots
    */
    //Method  to return the number of robots in the world (=the size of the array list)
    public int numberOfRobots(){
        return robots.size();
    }
    
    /**
     * Give us the possibility to edit a maximum number of robots in our worlds
     *
    */
    //Method to set the maximum number of robots
    public void setMaxRobots(int nb){
        maxRobots = nb ;
    }
    
    
     /**
     * Move all the robots with their own move() method
     */
    // The method moveAll()/automaticMovements(int nb) are our two methods to check is our robot are moving great and if there is no game over
    // We can comare these two methods to the test that user could do
    public void moveAll(){
        for (Robot r : robots)
        {
            r.move();
            try {
            // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
            } 
            catch (Exception e) {
                System.out.println("Erreur");
            }  
        }
    }
        
        /**
     * Add a new robot
     * @param  The name of the new Robot to add
     * @param  His X position
     * @param His Y position
     */
    //This method allows us to add a Robot to the world, i.e. 1 possible choice, the diagonal one I have chosen
    public void addRobotInWorld(String name, int x, int y, String colourBody)
    {       
        if (!isRobotAtPosition(x,y)){
            /*if (numberOfRobots()<maxRobots){*/
               System.out.println("Choisis un robot : \n1-RobotRandom \n2-ColorfulRobot \n3-RobotRandom");
                Scanner keyboard = new Scanner(System.in);
                int choice = keyboard.nextInt();
                // The case gives us the possibilty to choose the type of robot that we want to create
                switch(choice)
                {
                    case 1 : robots.add(new RobotRandom(name, x, y, colourBody, this));break;//Julie's robot
                    case 2 : robots.add(new ColorfulRobot(name, x, y, this)); break;
                    default : System.out.print("Cette option n'est pas disponible");
                }
            /*}
            else{
                System.out.print("The world of robots is full");
            }*/
        }
        else{
            System.out.print("There is already a robot at this place");
        }
    }
    
    /**
     * 
     * Method to check if there is a robot at the position we want to move
     * 
     */
    public boolean isRobotAtPosition(int x, int y)
    {     
        // We will run through the arraylist to check if there is a robot with the same xPosition/yPosition
        for (Robot r : robots)
        {
            if (r.getXPosition() == x && r.getYPosition() == y)
            {
                // If there is a robot at this position we return true
                return true;
            }
        }
        //When all the arraylist is checked if there is no true we return false
        return false;
    }
    
    /**
     * automaticMovement give us the possibility to test our robots with a number of moovement (Generally we did 200 moveAll)
     */
    
    public void automaticMovements(int nb)
    {
        for (int i=0; i<nb; i++)
        {
            moveAll();         
        }
    }
    
    
    /**
     * Check if a square is occupied by a robot or if it is outside of the world
     * @return TRUE = The square is available. FALSE = It is outside of the world or occupied by a robot
     */
    public boolean isSquareAvailable(int X, int Y){
    if (X <= Robot.getMaxPosition() && Y <= Robot.getMaxPosition() && X >= Robot.getMinPosition() && Y >= Robot.getMinPosition() && !isRobotAtPosition(X, Y)) {
    return true;
    } else {
    return false;
    }
}
    
}//End class