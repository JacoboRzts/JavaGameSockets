package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/*
 * Manage the keyboard events.
 */
public class KeyManager implements KeyListener {
    private boolean keyUp, keyDown, keyLeft, keyRigth;

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                keyUp = true;
            break;
            case KeyEvent.VK_S:
                keyDown = true;
                break;
            case KeyEvent.VK_A:
                keyLeft = true;
                break;
            case KeyEvent.VK_D:
                keyRigth = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                keyUp = false;
                break;
            case KeyEvent.VK_S:
                keyDown = false;
                break;
            case KeyEvent.VK_A:
                keyLeft = false;
                break;
            case KeyEvent.VK_D:
                keyRigth = false;
                break;
        }
    }

    public boolean getKeyUp(){
        return this.keyUp;
    }

    public boolean getKeyDown(){
        return this.keyDown;
    }

    public boolean getKeyLeft(){
        return this.keyLeft;
    }

    public boolean getKeyRight(){
        return this.keyRigth;
    }
}
