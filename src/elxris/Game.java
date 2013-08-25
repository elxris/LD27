package elxris;

import java.awt.Color;
import java.awt.Graphics;

import elxris.art.Arc;
import elxris.art.Pew;
import elxris.art.Pool;
import elxris.util.ColorHandler;

public class Game {
    public static float camX = 0, camY = 0;
    public boolean pausa = false;
    public long time = 10*1000;
    Arc[] arcs = new Arc[15];
    public static Controls ctr;
    public Pool pool = new Pool();
    public Game(Controls ctrls){
        ColorHandler color = new ColorHandler(Color.RED, 0);
        for(int i = 0; i < arcs.length; i++){
            Arc arc = new Arc(new ColorHandler(color.getColor(), 300), 18);
            arc.setSize(i*30);
            //arc.setOffsetPos(i*10, i*10);
            arc.setPos(350, 450/2);
            arc.setAngle(i*8);
            arcs[i] = arc;
        }
        ctr = ctrls;
    }
    public void draw(Graphics g){
        for(int i = arcs.length-1; i >= 0; i--){
            if(arcs[i].getSize() > 30*15){
                arcs[i].setSize(0);
                arcs[i].getColor().setDarkness(180);
            }
            arcs[i].addSize(1+arcs[i].getSize()/50);
            arcs[i].getColor().addDarkness(-1);
            if(!Controls.lClick){
                arcs[i].addAngle((float)arcs[i].getSize()/800f);
            }
            arcs[i].setOffsetPos((int)camX, (int)camY);
            arcs[i].setPos(350+(int)camX/4, 450/2+(int)camY/4);
            arcs[i].draw(g);
        }
        pool.draw(g);
    }
    public void tick(){
        move();
        if(Controls.lClick){
            if(Controls.timeLClick < Tick.getSecondsToTick(0.12d)){
                if(Controls.timeLClick == 0){
                    int time = (int) Tick.getSecondsToTick(0.2d);
                    pool.addArt(new Pew(time), time);
                }
                Controls.timeLClick++;
            }else{
                Controls.lClick = false;
            }
        }
    }
    public void move(){
        int amount = 5;
        if(Controls.up){
            addMove(0, amount);
        }
        if(Controls.down){
            addMove(0, -amount);
        }
        if(Controls.left){
            addMove(-amount, 0);
        }
        if(Controls.right){
            addMove(amount, 0);
        }
    }
    public void addMove(int x, int y){
        camX += x;
        camY -= y;
        if(camX > Frame.WIDTH/4){
            camX = Frame.WIDTH/4;
        }else if(camX < -Frame.WIDTH/4){
            camX = -Frame.WIDTH/4;
        }
        if(camY > Frame.HEIGHT/4){
            camY = Frame.HEIGHT/4;
        }else if(camY < -Frame.HEIGHT/4){
            camY = -Frame.HEIGHT/4;
        }
    }
}
