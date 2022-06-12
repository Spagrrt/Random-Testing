package io.github.spagrrt.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.time.Instant;

public class Game extends JPanel implements ActionListener, KeyListener, MouseListener {

    List<HazardBlock> hazardBlocks = new LinkedList<>();

    Instant startTime;

    Timer t;
    Random r = new Random();

    Player player = new Player();

    public Game(){
        t = new Timer(5, this);
        t.start();
        startTime = Instant.now();

        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(player.getX(), player.getY(), 50, 50);

        for(HazardBlock block : hazardBlocks){
            if(block.getIsSpeedy()){
                g.setColor(Color.GREEN);
            }
            else{
                g.setColor(Color.BLACK);
            }
            g.fillRect(block.getX(), block.getY(), block.getXSize(), block.getYSize());
            g.setColor(Color.WHITE);
            g.drawRect(block.getX(), block.getY(), block.getXSize(), block.getYSize());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(r.nextInt(80) == 1){
            hazardBlocks.add(new FallingHazard(r.nextInt(1620), -50, r.nextInt(400) + 200, 50));
        }
        if(Instant.now().isAfter(startTime.plus(15, ChronoUnit.SECONDS)) && r.nextInt(80) == 1){
            hazardBlocks.add(new RightSwipeHazard(-50, r.nextInt(1070), 50, r.nextInt(120) + 60));
        }
        if(Instant.now().isAfter(startTime.plus(30, ChronoUnit.SECONDS)) && r.nextInt(80) == 1){
            hazardBlocks.add(new LeftSwipeHazard(1920, r.nextInt(1070), 50, r.nextInt(120) + 60));
        }

        for(HazardBlock block : hazardBlocks){
            block.move();
        }

        player.moveX();
        player.applyGravity();

        //no touch
        this.repaint();
        this.validate();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            player.setMovingRight(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            player.setMovingLeft(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            player.jump();
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            player.fall();
        }
        if(e.getKeyCode() == KeyEvent.VK_O){
            this.setBackground(Color.BLACK);
        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            this.setBackground(Color.WHITE);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            player.setMovingRight(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            player.setMovingLeft(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
