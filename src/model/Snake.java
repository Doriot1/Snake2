package model;

import javafx.scene.input.KeyCode;

/**
 * Created by Daniel on 18.7.2015.
 */
public class Snake{
    private boolean isAlive = true;
    private int xPosition = 360;
    private int yPosition = 360;

    public final static int UP = 0, DOWN = 2, EAST = 1, WEST = 3;
    private int direction = 1;

    public boolean isAlive(){
        return isAlive;
    }

    public int getXPosition(){
        return xPosition;
    }

    public int getYPosition(){
        return yPosition;
    }

    public int getDirection(){
        return direction;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void move(){

        if(direction == 0)
            yPosition -= 4;
        if(direction == 1)
            xPosition += 4;
        if (direction == 2)
            yPosition += 4;
        if (direction == 3)
            xPosition -= 4;
    }

}
