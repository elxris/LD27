package elxris.art;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import elxris.Controls;

public class Pointer implements Art{
    public static int x, y;
    public Pointer(){
    }
    @Override
    public void draw(Graphics g) {
        if(Controls.lClick){
            g.setColor(Color.RED);
        }else{
            g.setColor(Color.GREEN);
        }
        int i = 2;
        g.drawPolygon(new Polygon(new int[]{-i+x, i+x, i+x, -i+x}, new int[]{-i+y, -i+y, i+y, i+y}, 4));
    }
    public void setPos(int x, int y){
        Pointer.x = x;
        Pointer.y = y;
    }
}
