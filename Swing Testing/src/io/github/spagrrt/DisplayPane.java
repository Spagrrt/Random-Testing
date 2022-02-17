package io.github.spagrrt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class DisplayPane extends JPanel implements ActionListener, MouseListener, KeyListener {

    private static JFrame frame = new JFrame("What have I done");
    private static DisplayPane pane = new DisplayPane();

    private LinkedList<TestBlock> blockList = new LinkedList<>();

    Timer timer;

    private int count = 0;

    public DisplayPane(){
        timer = new Timer(5, this);
        timer.start();
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(TestBlock block : blockList){
            g.setColor(block.getColor());
            g.fillRect(block.getX(), block.getY(), block.getXSize(), block.getYSize());
            g.setColor(Color.BLACK);
            g.drawRect(block.getX(), block.getY(), block.getXSize(), block.getYSize());
        }
    }

    public static void main(String[] args) {
        frame.setSize(Constants.screenX, Constants.screenY);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(pane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(TestBlock block : blockList){
            block.checkCollisions(Constants.screenX, Constants.screenY);
            block.move();
        }

        //Refreshes the pane; leave at bottom of method
        pane.repaint();
        pane.revalidate();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == 1){
            blockList.add(new TestBlock(e.getX() - 25, e.getY() - 25, 50, 50, Color.GREEN, 3));
            System.out.println("Mouse Clicked");
        }
        if(e.getButton() == 2){
            blockList.add(new TestBlock(e.getX() - 75, e.getY() - 75, 150, 150, Color.BLUE, 1));
            System.out.println("Mouse Clicked");
        }
        if(e.getButton() == 3){
            blockList.add(new TestBlock(e.getX() - 50, e.getY() - 50, 100, 100, Color.RED, 2));
            System.out.println("Mouse Clicked");
        }
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
