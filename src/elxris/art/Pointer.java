package elxris.art;

import java.awt.Color;
import java.awt.Graphics;

public class Pointer implements Art{
    private int x, y;
    private boolean pressed;
    @Override
    public void draw(Graphics g) {
        if(!pressed){
            g.setColor(Color.WHITE);
        }else{
            g.setColor(Color.RED);
        }
        for(int i = 50; i > 30; i--){
            Color color = g.getColor();
            S
            g.drawArc(x, y, i, i, 90, 90);
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
