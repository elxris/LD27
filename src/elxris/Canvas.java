package elxris;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import elxris.art.Pointer;

public class Canvas extends JPanel{
    private static final long serialVersionUID = 756031998276891347L;
    private static Game game;
    private static Pointer mouse;
    public Canvas(Game game, Pointer mouse){
        super();
        setBackground(Color.BLACK);
        Canvas.game = game;
        Canvas.mouse = mouse;
    }
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        if(!game.pausa){
            game.tick();
            game.draw(g);
        }
        mouse.draw(g);
    }
    public void tick(){
        this.repaint();
    }
}
