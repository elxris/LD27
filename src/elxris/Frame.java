package elxris;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.RenderingHints.Key;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import elxris.art.Pointer;

public class Frame extends JFrame implements MouseListener, KeyListener, MouseMotionListener{
    private static final long serialVersionUID = -5044773304968108L;
    private Game game;
    private Pointer mouse;
    private Tick tick;
    public Frame(){
        super("LD27 @elxris");
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        // Establece un cursor en blanco
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        setCursor(blankCursor);
        //
        game = new Game();
        mouse = new Pointer();
        Canvas canvas = new Canvas(game, mouse);
        add(canvas);
        tick = new Tick(60, canvas);
        tick.start();
    }
    public void run(){
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        mouse.setPos(e.getX(), e.getY());
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        mouse.setPos(e.getX(), e.getY());
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getExtendedKeyCode() == 27){
            System.exit(getDefaultCloseOperation());
        }
        System.out.print(e.getExtendedKeyCode());
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
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
        mouse.setPressed(true);
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        mouse.setPressed(false);
    }
}
