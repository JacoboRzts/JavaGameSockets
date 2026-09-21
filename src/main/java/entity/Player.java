package entity;

import main.GamePanel;
import main.KeyManager;

import java.awt.*;

public class Player extends Entity{
    private final GamePanel gP;
    private final KeyManager kM;

    public Player(GamePanel gP, KeyManager kM){
        this.gP = gP;
        this.kM = kM;
        startConfig();
    }

    public void startConfig(){
        this.x = 100;
        this.y = 100;
        this.speed = 4;
    }

    public void update(){
        if (kM.getKeyUp()) {
            this.setY(this.getY() - this.getSpeed());
        } else if (kM.getKeyDown()) {
            this.setY(this.getY() + this.getSpeed());
        } else if (kM.getKeyLeft()) {
            this.setX(this.getX() - this.getSpeed());
        } else if (kM.getKeyRight()) {
            this.setX(this.getX() + this.getSpeed());
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.fillRect(this.getX(), this.getY(), gP.getTileSize(), gP.getTileSize());
    }
}
