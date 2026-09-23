package entity;

import java.awt.image.BufferedImage;

public class Entity {
    protected int x, y, speed;
    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    protected String direction;

    /** Getters */
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getSpeed() { return this.speed; }
    public String getDirection() { return this.direction; }

    /** Setters */
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setDirection(String direction) { this.direction = direction; }
}
