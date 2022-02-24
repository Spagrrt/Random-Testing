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

    private boolean showSel = false;
    private int xSel = 25;
    private int ySel = 25;
    private boolean superCreate = false;

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
        if(showSel){
            g.fillRect(xSel - 1, ySel - 1, 2, 2);
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
            block.incHue(0.01);
        }

        if(superCreate){
            blockList.add(new TestBlock(xSel - 25, ySel - 25, 50, 50, Color.GREEN, 3));
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
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            blockList.clear();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            for(TestBlock block : blockList){
                block.makeRainbow();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            showSel = !showSel;
        }
        if(e.getKeyCode() == KeyEvent.VK_E){
            superCreate = !superCreate;
        }
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
        else if(e.getButton() == 2){
            blockList.add(new TestBlock(e.getX() - 75, e.getY() - 75, 150, 150, Color.BLUE, 1));
            System.out.println("Mouse Clicked");
        }
        else if(e.getButton() == 3){
            blockList.add(new TestBlock(e.getX() - 50, e.getY() - 50, 100, 100, Color.RED, 2));
            System.out.println("Mouse Clicked");
        }
        else {
            xSel = e.getX();
            ySel = e.getY();
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
