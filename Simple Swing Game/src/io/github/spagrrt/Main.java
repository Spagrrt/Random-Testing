package io.github.spagrrt;

import io.github.spagrrt.Game.Game;

import javax.swing.*;

public class Main {

    public static JFrame frame = new JFrame("Gaming");
    public static Game gamePanel = new Game();

    public static void main(String[] args) {
        frame.add(gamePanel);
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

}
