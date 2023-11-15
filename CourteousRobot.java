import java.util.Random;

/**
 * La classe "CourteousRobot" permet, lorsqu'un robot de cette classe se déplace sur 
 * un autre robot, de ne pas avoir un game over. Le robot va simplement s'excuser et
 * être téléporté à un autre endroit du canvas.
 *
 * @author Clémence Renaud
 * @version (18/10/2023)
 */

public class CourteousRobot extends Robot
{
   private Random random;
    /**
     * Constructeur d'objets de classe TheTower
     * 
     * @param name - the name of the robot
     * @param x, y - the position of the robot
     * @param colourBody - the color of the robot
     * @param World w - the world the robot is belonging
     */
    public CourteousRobot(String name, int x, int y, String colourBody, World w)
    {
       super(name,x,y,colourBody,w);
       w.addRobots(this);
       // the colour of the head and the colour of the eyes of the robot has been pre-set 
       setColourHead("RED");
       setColourEye("BLUE");
       random = new Random();
    }
    /**
     * Méthode apology
     * Prints apologies and uses a random to teleport the robot to another place.
     *
     */
    public void apology(){
        System.out.println("Hi, I'm the CourteousRobot ! I'm sorry, I did not see you");
        boolean ok = false;
        int x,y;
        while (ok!=true){
            x = random.nextInt(12);
            y = random.nextInt(12);
            if(super.getWorld().verifPlace(x,
            y)==false){
                super.setXPosition(x);
                super.setYPosition(y);
                super.redraw();
                ok=true;
            }
        }
        
        
    }
    
    /**
     * Méthode moveUp
     * After checked if the place is free, Move the robot up by removing 1 from 
     * its y position
     *
     */
    public void moveUp(){
        
        if(super.getWorld().verifPlace(super.getXPosition(),
        (super.getYPosition()-1))==false){
            super.setYPosition(super.getYPosition()-1); 
            super.redraw();  
        }
        else{
            apology();
        }
        
    }
    
    /**
     * Méthode moveDown
     * After checked if the place is free, Move the robot down by adding 1 from 
     * its y position
     */
    public void moveDown(){
        
        if(super.getWorld().verifPlace(super.getXPosition(),
        (super.getYPosition()+1))==false){
            setYPosition(getYPosition()+1);
            super.redraw();  
        }
        else{
            apology();
        }
    }  
        
        
    /**
     * Méthode moveLeft
     * After checked if the place is free, Move the robot left by removing 1 from 
     * its x position
     *
     */
    public void moveLeft(){
        
        if(super.getWorld().verifPlace((super.getXPosition()-1),
        super.getYPosition())==false){
            setXPosition(getXPosition()-1);
            super.redraw();  
        }
        else{
            apology();
        }
    }
        
    /**
     * Méthode moveRight
     * After checked if the place is free, Move the robot right by adding 1 from 
     * its x position
     */
    public void moveRight(){
        
        if(super.getWorld().verifPlace((super.getXPosition()+1),
        super.getYPosition())==false){
            setXPosition(getXPosition()+1);
            super.redraw();  
        }
        else{
            apology();
        }
    }
    
    /**
     * Méthode move
     * This method called all methods which allow robot moves.
     *
     */
    public void move(){
        moveRight();
        moveRight();
        moveDown();
        moveDown();
        moveLeft();
        moveLeft();
        moveUp();
    }
}