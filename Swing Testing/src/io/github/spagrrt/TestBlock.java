package io.github.spagrrt;

import java.awt.*;

public class TestBlock {

    private int x;
    private int y;

    private int xSize;
    private int ySize;

    private int xDirect;
    private int yDirect;

    private int speed;

    private Color color;

    private boolean rainbow = false;
    private double hue = 0;

    public TestBlock(int x, int y, int xSize, int ySize, Color color, int speed) {
        this.x = x;
        this.y = y;

        this.xSize = xSize;
        this.ySize = ySize;

        this.color = color;

        xDirect = speed;
        yDirect = speed;

        this.speed = speed;
    }

    public void checkCollisions(int xBound, int yBound){
        if(x >= xBound - (xSize + Constants.bounceFixX)){
            xDirect = -speed;
        }
        if(y >= yBound - (ySize + Constants.bounceFixY)){
            yDirect = -speed;
        }
        if(x <= 0){
            xDirect = speed;
        }
        if(y <= 0){
            yDirect = speed;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getXSize(){
        return xSize;
    }

    public int getYSize(){
        return ySize;
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

    public void makeRainbow(){
        rainbow = true;
    }

    public void incHue(double hue){
        this.hue += hue;
        if(this.hue < 1){
            hue -= 1;
        }
        if(rainbow) {
            this.color = Color.getHSBColor((float)this.hue, 1f, 1f);
        }
    }

}
