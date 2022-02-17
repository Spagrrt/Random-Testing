package io.github.spagrrt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class DisplayPane extends JPanel implements ActionListener, MouseListener, KeyListener {

    private static JFrame frame = new JFrame("Basic Pathfinding");
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
            g.fillRect(block.getX(), block.getY(), 50, 50);
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
        blockList.add(new TestBlock(e.getX() - 25, e.getY() - 25, 50, 50, Color.GREEN));
        System.out.println("Mouse Clicked");
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
