package main;

import javax.swing.*;

/*
 * Starter point, main class Game
 */
public class Game {

    public static void main(String[] args){
        JFrame ventana = new JFrame();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setTitle("Cloud Game");

        GamePanel panel = new GamePanel();
        ventana.add(panel);
        ventana.pack();

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        panel.startGameThread();
    }
}
