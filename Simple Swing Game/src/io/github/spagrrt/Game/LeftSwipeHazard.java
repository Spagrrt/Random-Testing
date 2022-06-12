package io.github.spagrrt.Game;

public class LeftSwipeHazard extends HazardBlock{

    public LeftSwipeHazard(int x, int y, int xSize, int ySize) {
        super(x, y, xSize, ySize);
    }

    @Override
    public void move(){
        super.moveX(-5);
    }
}
