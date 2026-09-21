package main;

import entity.Player;
import javax.swing.*;
import java.awt.*;

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

    Thread gameThread;
    KeyManager kM = new KeyManager();
    Player player = new Player(this, kM);
    int fps = 40;

    public GamePanel(){
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
        g2.setColor(Color.WHITE);
        g2.fillRect(player.getX(), player.getY(), this.tileSize, tileSize);
        g2.dispose();
    }

    public void update(){
        if (kM.getKeyUp()) {
            player.setY(player.getY() - player.getSpeed());
        } else if (kM.getKeyDown()) {
            player.setY(player.getY() + player.getSpeed());
        } else if (kM.getKeyLeft()) {
            player.setX(player.getX() - player.getSpeed());
        } else if (kM.getKeyRight()) {
            player.setX(player.getX() + player.getSpeed());
        }
    }

    public int getTileSize() {
        return this.tileSize;
    }

    public int getMaxCols() {
        return this.maxCols;
    }

    public int getMaxRows(){
        return this.maxRows;
    }

    public int getWidthScreen(){
        return this.widthScreen;
    }

    public int getHeightScreen(){
        return this.heightScreen;
    }

}
