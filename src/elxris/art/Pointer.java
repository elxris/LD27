package elxris.art;

import java.awt.Color;
import java.awt.Graphics;

import elxris.util.ColorHandler;

public class Pointer implements Art{
    private int x, y;
    private boolean pressed;
    private ColorHandler color;
    Arc[] arcs = new Arc[15];
    public Pointer(){
        color = new ColorHandler(Color.red, 180);
        for(int i = 0; i < arcs.length; i++){
            color.addDarkness(-12);
            Arc arc = new Arc(new ColorHandler(color.getColor()), 8);
            arc.setSize(i*50);
            arc.setOffsetPos(i*10, i*10);
            arc.setAngle(i*8);
            arcs[i] = arc;
        }
    }
    @Override
    public void draw(Graphics g) {
        for(int i = arcs.length-1; i >= 0; i--){
            if(color == null || !pressed){
                arcs[i].addAngle((float)i/10f);
            }
            arcs[i].setPos(x, y);
            arcs[i].draw(g);
        }
        
    }
    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setPressed(boolean status){
        pressed = status;
    }
}
