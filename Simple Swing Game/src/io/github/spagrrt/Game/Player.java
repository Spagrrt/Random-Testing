package io.github.spagrrt.Game;

public class Player {

    private int x, y;
    private boolean isGrounded;
    private double gravity;
    private double xVelocity, yVelocity;

    private boolean movingLeft, movingRight;

    public Player(){
        this.x = 935;
        this.y = 1030;
        isGrounded = false;
        gravity = 0.05;
        yVelocity = 0;
        xVelocity = 0;
        movingLeft = false;
        movingRight = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void jump(){
        if(isGrounded) {
            setGrounded(false);
            yVelocity = 8;
        }
    }

    public void setGrounded(boolean grounded){
        isGrounded = grounded;
    }

    public void applyGravity(){

        if(y > 1030){
            isGrounded = true;
            y = 1030;
        }

        if(!isGrounded) {
            yVelocity -= gravity;
        }
        else{
            yVelocity = 0;
        }

        y -= yVelocity;
    }

    public void moveX(){

        xVelocity = 0;

        if(movingRight){
            xVelocity += 5;
        }
        if(movingLeft){
            xVelocity -= 5;
        }

        x += xVelocity;
        if(x < -50){
            x += 1970;
        }
        if (x > 1920){
            x -= 1970;
        }
    }

    public void setMovingLeft(boolean isMovingLeft){
        movingLeft = isMovingLeft;
    }
    public void setMovingRight(boolean isMovingRight){
        movingRight = isMovingRight;
    }

    public void fall(){
        if(!isGrounded && yVelocity > -6){
            yVelocity = -6;
        }
    }
}
