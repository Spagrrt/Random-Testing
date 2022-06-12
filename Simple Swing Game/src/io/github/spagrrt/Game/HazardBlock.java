package io.github.spagrrt.Game;

import java.util.Random;

public class HazardBlock {
    private int x, y, xSize, ySize;
    private boolean isSpeedy;

    private Random r = new Random();

    public HazardBlock(int x, int y, int xSize, int ySize){
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
        if(r.nextInt(20) == 1){
            isSpeedy = true;
        }
        else{
            isSpeedy = false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public boolean getIsSpeedy(){
        return isSpeedy;
    }

    public void moveX(int dist){
        if(isSpeedy) {
            x += dist * 2;
        }
        else{
            x += dist;
        }
    }

    public void moveY(int dist){
        if(isSpeedy) {
            y += dist * 2;
        }
        else{
            y += dist;
        }
    }

    public void move(){}
}
