package io.github.spagrrt.Game;

public class FallingHazard extends HazardBlock{
    public FallingHazard(int x, int y, int xSize, int ySize) {
        super(x, y, xSize, ySize);
    }

    @Override
    public void move(){
        super.moveY(5);
    }

}
