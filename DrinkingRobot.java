import java.util.Random;
/**
 * DrinkingRobot is a robot that can be in one of two states: drunk or sober. The robot's movements change based on its current state. When drunk, the robot
 * exhibits erratic and unpredictable movements, while when sober, it moves in a more controlled and steady manner.
 * 
 * @author Avin IRANNEZHAD
 * @version 31/10/2023
 */


public class DrinkingRobot extends Robot {
        private boolean isDrunk;
/**
     * Constructor for objects of class DrunkRobot
     * 
     * @param  name       Sets the name of the robot
     * @param  xPosition  Sets its position on the x axis of the canvas
     * @param  yPosition  Sets its position on the y axis of the canvas
     * @param  colourBody sets its color body
     * @param  w          Sets the world in which the robot will be added
     * 
     */
public DrinkingRobot(String name, int x, int y, String colourBody, World w) {
        super(name, x, y, colourBody, w);
        w.addRobots(this);
        //The robot is randomly drunk or sober
        Random random = new Random();
        isDrunk = random.nextBoolean();
        setColourHead("YELLOW");
        setColourEye("BLUE");
    }
public boolean isDrunk() {
        return isDrunk;
    }
/**
 * Moves the DrinkingRobot in accordance with its current state, which can be either drunk or sober.
 * When the robot is drunk, it exhibits erratic and unpredictable movements, taking two random steps with a one-second pause between each step.
 * When the robot is sober, it moves in a more controlled manner, taking two steps in a random direction without any pauses. 
 */
public void move() {
    int x = getXPosition();
    int y = getYPosition();

    // Create a new random number generator for choosing directions.
    Random randomDirection = new Random();
    int randomStepSize = 2; // The number of steps to take.

    if (isDrunk()) {
        // Behavior when the robot is drunk
        for (int i = 0; i < 2; i++) {
            // Generate a random direction: 0 for up, 1 for down, 2 for left, 3 for right.
            int direction = randomDirection.nextInt(4);

            // Depending on the direction, adjust the robot's position.
            if (direction == 0 && y + randomStepSize <= getMaxPosition()) {
                y += randomStepSize;
            } else if (direction == 1 && y - randomStepSize >= getMinPosition()) {
                y -= randomStepSize;
            } else if (direction == 2 && x - randomStepSize >= getMinPosition()) {
                x -= randomStepSize;
            } else if (direction == 3 && x + randomStepSize <= getMaxPosition()) {
                x += randomStepSize;
            }

            // Set the new X and Y positions of the robot.
            setXPosition(x);
            setYPosition(y);

            // Redraw the robot's position.
            redraw();

            try {
                // Pause for 1 second (1000 milliseconds) between steps.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle any interruptions during sleep (optional).
                Thread.currentThread().interrupt();
            }
        }
    } else {
        // Behavior when the robot is sober
        int direction = randomDirection.nextInt(4);

        if (direction == 0 && y + randomStepSize <= getMaxPosition()) {
            y += randomStepSize;
        } else if (direction == 1 && y - randomStepSize >= getMinPosition()) {
            y -= randomStepSize;
        } else if (direction == 2 && x - randomStepSize >= getMinPosition()) {
            x -= randomStepSize;
        } else if (direction == 3 && x + randomStepSize <= getMaxPosition()) {
            x += randomStepSize;
        }

    
        setXPosition(x);
        setYPosition(y);
        redraw();
    }
}
}
