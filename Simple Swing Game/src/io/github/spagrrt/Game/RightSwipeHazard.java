package io.github.spagrrt.Game;

public class RightSwipeHazard extends HazardBlock{

    public RightSwipeHazard(int x, int y, int xSize, int ySize) {
        super(x, y, xSize, ySize);
    }

    @Override
    public void move(){
        super.moveX(5);
    }
}
