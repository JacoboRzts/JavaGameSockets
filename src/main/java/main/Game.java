package main;

import javax.swing.JFrame;

/*
 * Starter point, main class Game
 */
public class Game {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        GamePanel panel = new GamePanel();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Cloud Game");
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.add(panel);
        ventana.pack();
        panel.startGameThread();
    }
}
