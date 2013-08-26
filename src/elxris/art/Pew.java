package elxris.art;

import java.awt.Color;
import java.awt.Graphics;

import elxris.game.Frame;
import elxris.game.Game;

public class Pew implements Art{
    int time;
    public Pew(int time){
        this.time = time;
    }
    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        int width = (int) Game.camX+Frame.WIDTH/2, height = (int) Game.camY+Frame.HEIGHT/2;
        g.setColor(Color.GREEN);
        g.drawPolygon(new int[]{width, Pointer.x},
                new int[]{height, Pointer.y}, 2);
        time--;
    }
}
