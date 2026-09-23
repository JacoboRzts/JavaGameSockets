package main;

import entity.Player;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
 * Mange the main frame of the game
 */
public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxCols = 26;
    final int maxRows = 15;
    final int widthScreen = tileSize * maxCols;
    final int heightScreen = tileSize * maxRows;
    final int fps = 40;

    KeyManager kM = new KeyManager();
    Player player = new Player(this, kM);
    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(this.widthScreen, this.heightScreen));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(kM);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long actualTime;

        // Update the screen only 'fps' times.
        while(gameThread != null){
            actualTime = System.nanoTime();
            delta += (actualTime - lastTime) / drawInterval;
            lastTime = actualTime;
            if (delta >= 1){
                update();
                repaint(); // internally call the paintComponent() method to draw into the frame.
                delta--;
            }
         }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        g2.dispose();
    }

    public void update() {
        player.update();
    }

    /** Getters */
    public int getTileSize() { return this.tileSize; }
    public int getMaxCols() { return this.maxCols; }
    public int getMaxRows(){ return this.maxRows; }
    public int getWidthScreen(){ return this.widthScreen; }
    public int getHeightScreen() { return this.heightScreen; }
}
