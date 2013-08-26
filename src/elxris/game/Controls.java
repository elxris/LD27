package elxris.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import elxris.art.Pointer;

public class Controls implements MouseListener, KeyListener, MouseMotionListener{
    public static boolean up, down, right, left, space, rClick, lClick, mClick;
    public static long timeLClick, timeWin;
    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
        Pointer.x = arg0.getX();
        Pointer.y = arg0.getY();
    }
    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
        Pointer.x = arg0.getX();
        Pointer.y = arg0.getY();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getExtendedKeyCode();
        System.out.print(key+" ");
        setKey(key, true);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getExtendedKeyCode();
        setKey(key, false);
    }
    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        setMouse(arg0.getButton(), true);
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        setMouse(arg0.getButton(), false);
        resetTimers();
    }
    public void setKey(int key, boolean pressed){
        if(key == 27){
            System.exit(0);
        }else
        if(key == 68){
            right = pressed;
        }else
        if(key == 65){
            left = pressed;
        }else
        if(key == 87){
            up = pressed;
        }else
        if(key == 83){
            down = pressed;
        }else
        if(key == 32){
            space = pressed;
        }
    }
    public void setMouse(int button, boolean pressed){
        if(button == 0){
            //No button
        }else
        if(button == 1){
            // Izquierdo
            lClick = pressed;
        }
        if(button == 2){
            // Derecho
            rClick = pressed;
        }
        if(button == 3){
            // Click Medio
            mClick = pressed;
        }
    }
    public void resetTimers(){
        timeLClick = 0;
    }
}