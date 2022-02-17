package io.github.spagrrt;

import java.awt.*;

public class TestBlock {

    private int x;
    private int y;

    private int xSize;
    private int ySize;

    private int xDirect;
    private int yDirect;

    private Color color;

    public TestBlock(int x, int y, int xSize, int ySize, Color color) {
        this.x = x;
        this.y = y;

        this.xSize = xSize;
        this.ySize = ySize;

        this.color = color;

        xDirect = 1;
        yDirect = 1;
    }

    public void checkCollisions(int xBound, int yBound){
        if(x >= xBound - (xSize + Constants.bounceFixX)){
            xDirect = -1;
        }
        if(y >= yBound - (ySize + Constants.bounceFixY)){
            yDirect = -1;
        }
        if(x <= 0){
            xDirect = 1;
        }
        if(y <= 0){
            yDirect = 1;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Color getColor(){
        return color;
    }

    public void move(){
        x += xDirect;
        y += yDirect;
    }

    public void move(int moveX, int moveY){
        x += moveX;
        y += moveY;
    }

    public void setColor(Color color){
        this.color = color;
    }
}
