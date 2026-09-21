package entity;

import main.GamePanel;
import main.KeyManager;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    private final GamePanel gP;
    private final KeyManager kM;

    public Player(GamePanel gP, KeyManager kM){
        this.gP = gP;
        this.kM = kM;
        startConfig();
        getSprites();
    }

    public void startConfig(){
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        this.setDirection("down");
    }

    public void update(){
        if (kM.getKeyUp()) {
            this.setY(this.getY() - this.getSpeed());
            this.setDirection("up");
        } else if (kM.getKeyDown()) {
            this.setY(this.getY() + this.getSpeed());
            this.setDirection("down");
        } else if (kM.getKeyLeft()) {
            this.setX(this.getX() - this.getSpeed());
            this.setDirection("left");
        } else if (kM.getKeyRight()) {
            this.setX(this.getX() + this.getSpeed());
            this.setDirection("right");
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage sprite = switch (this.getDirection()) {
            case "up" -> this.up1;
            case "left" -> this.left1;
            case "right" -> this.right1;
            default -> null;
        };
        g2.drawImage(sprite, this.getX(), this.getY(), gP.getTileSize(), gP.getTileSize(), null);
    }

    public void getSprites(){
        try {
            this.up1    = ImageIO.read(getClass().getResourceAsStream("/playersprites/moverArriba1.png"));
            this.up2    = ImageIO.read(getClass().getResourceAsStream("/playersprites/moverArriba2.png"));
            this.down1  = ImageIO.read(getClass().getResourceAsStream("/playersprites/moverAbajo1.png"));
            this.down2  = ImageIO.read(getClass().getResourceAsStream("/playersprites/moverAbajo2.png"));
            this.left1  = ImageIO.read(getClass().getResourceAsStream("/playersprites/moverIzquierda1.png"));
            this.left2  = ImageIO.read(getClass().getResourceAsStream("/playersprites/moverIzquierda2.png"));
            this.right1 = ImageIO.read(getClass().getResourceAsStream("/playersprites/moverDerecha1.png"));
            this.right2 = ImageIO.read(getClass().getResourceAsStream("/playersprites/moverDerecha2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
