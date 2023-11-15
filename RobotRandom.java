// Package to use randoms
import java.util.Random;
/**
 * Our random robot have to move in a random direction on a random number of cases.
 *
 * @author (Lisa)
 * @version (Final version)
 */
public class RobotRandom extends Robot

{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    
    

    /**
     * Constructeur d'objets de classe RobotRandom
     */
    public RobotRandom(String name,int x,int y, String color, World w)
    {
        // initialisation des variables d'instance
        super(name,x,y,color,w);
        w.addRobots(this);
        //Every robots have a unique color of head and eye to distinguish them
        this.setColourEye("Pink");
        this.setColourHead("White");
        //Direction = 0 -->Ouest
    }
    
    /**
     * The goal of my robot movement is to be totally random
     * He has to go in a random direction with a random number of squares
     */
    
    public void move(){
        //Direction == 1 --> Sud
        //Direction == 2 -->Est
        //Direction == 3 -->Nord
        //First we have to get the position and the direction of my robot
        int d = getDirection();
        int x = getXPosition();
        int y = getYPosition();
        //RandomDir() and z are the two random for our move
        randomDirection();
        Random rand = new Random();
        int z = rand.nextInt(getMaxPosition());
        //The for loop is between 0 and z the random number of cases we will move
        for(int i=0;i<z;i++){
            //We have four types of movements depending on the direction of the robot
            //The if is to check if there is no robot where we want to go
            if (d==0 &&!getWorld().isRobotAtPosition(x+1,y)){
                x+=1;      
            }
            else if (d==1&&!getWorld().isRobotAtPosition(x,y+1)){
                y+=1;
            }
            else if (d==2&&!getWorld().isRobotAtPosition(x-1,y)){
                x-=1;
            }
            else if (d==3 &&!getWorld().isRobotAtPosition(x,y-1)){
                y-=1;
            }
        }   
        //When we have our new xValue/yValue we set them and redraw the robot
        setXPosition(x);
        setYPosition(y);
        redraw();
    }
}