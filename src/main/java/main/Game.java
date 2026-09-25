package main;

import javax.swing.JFrame;

/*
 * Starter point, main class Game
 */
public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel panel = new GamePanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setTitle("Cloud Game");
        window.setResizable(false);
        window.setVisible(true);
        window.add(panel);
        window.pack();
        panel.startGameThread();
    }
}
