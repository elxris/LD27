package elxris.game;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import elxris.art.Pointer;

public class Frame extends JFrame {
    public static int WIDTH, HEIGHT;
    private static final long serialVersionUID = -5044773304968108L;
    private Game game;
    private Pointer mouse;
    private Tick tick;
    public Frame(){
        super("LD27 @elxris");
        Controls ctr = new Controls();
        addMouseListener(ctr);
        addKeyListener(ctr);
        addMouseMotionListener(ctr);
        WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
        HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(WIDTH, HEIGHT);
        // Establece un cursor en blanco
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        setCursor(blankCursor);
        
        game = new Game();
        mouse = new Pointer();
        Canvas canvas = new Canvas(game, mouse);
        add(canvas);
        tick = new Tick(120, canvas);
        tick.start();
    }
    public void run(){
    }
}
